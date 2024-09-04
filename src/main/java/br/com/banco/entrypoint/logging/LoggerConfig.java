package br.com.banco.entrypoint.logging;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class LoggerConfig implements WebMvcConfigurer {

    private final LoggerInterceptor loggerInterceptor;

    public LoggerConfig(LoggerInterceptor loggerInterceptor) {
        this.loggerInterceptor = loggerInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loggerInterceptor);
    }
}
