package br.com.banco.entrypoint.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Instant;
import java.util.Enumeration;

@Component
public class LoggerInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LoggerInterceptor.class);
    private static final String CORRELATION_ID_HEADER = "correlationId";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String correlationId = request.getHeader(CORRELATION_ID_HEADER);
        if (correlationId == null || correlationId.isEmpty()) {
            correlationId = generateCorrelationId();
            response.setHeader(CORRELATION_ID_HEADER, correlationId);
        }

        Instant startTime = Instant.now();
        request.setAttribute("startTime", startTime);
        request.setAttribute(CORRELATION_ID_HEADER, correlationId);

        logRequest(request, correlationId, startTime);

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        Instant startTime = (Instant) request.getAttribute("startTime");
        String correlationId = (String) request.getAttribute(CORRELATION_ID_HEADER);
        Instant endTime = Instant.now();
        long duration = endTime.toEpochMilli() - startTime.toEpochMilli();

        logResponse(request, response, correlationId, duration, endTime);

        if (ex != null) {
            logger.error("Exception occurred: ", ex);
        }
    }

    private void logRequest(HttpServletRequest request, String correlationId, Instant startTime) {
        StringBuilder logMessage = new StringBuilder();
        logMessage.append("Correlation ID: ").append(correlationId).append(" | ");
        logMessage.append("Request URL: ").append(request.getRequestURI()).append(" | ");
        logMessage.append("Method: ").append(request.getMethod()).append(" | ");
        logMessage.append("Start Time: ").append(startTime.toString()).append(" | ");
        logMessage.append("Headers: ").append(getHeaders(request));

        logger.info("Request: {}", logMessage.toString());
    }

    private void logResponse(HttpServletRequest request, HttpServletResponse response, String correlationId, long duration, Instant endTime) {
        StringBuilder logMessage = new StringBuilder();
        logMessage.append("Correlation ID: ").append(correlationId).append(" | ");
        logMessage.append("Response Status: ").append(response.getStatus()).append(" | ");
        logMessage.append("Duration: ").append(duration).append(" ms | ");
        logMessage.append("End Time: ").append(endTime.toString()).append(" | ");
        logMessage.append("Headers: ").append(getHeaders(response));

        if (response.getStatus() >= 400 && response.getStatus() < 500) {
            logger.warn("Response: {}", logMessage.toString());
        } else if (response.getStatus() >= 500) {
            logger.error("Response: {}", logMessage.toString());
        } else {
            logger.info("Response: {}", logMessage.toString());
        }
    }

    private String getHeaders(HttpServletRequest request) {
        StringBuilder headers = new StringBuilder();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            headers.append(headerName).append("=").append(request.getHeader(headerName)).append(", ");
        }
        return headers.toString();
    }

    private String getHeaders(HttpServletResponse response) {
        StringBuilder headers = new StringBuilder();
        for (String headerName : response.getHeaderNames()) {
            headers.append(headerName).append("=").append(response.getHeader(headerName)).append(", ");
        }
        return headers.toString();
    }

    private String generateCorrelationId() {
        return java.util.UUID.randomUUID().toString();
    }
}
