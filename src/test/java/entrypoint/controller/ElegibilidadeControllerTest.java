package entrypoint.controller;

import br.com.banco.entrypoint.controller.ElegibilidadeController;
import br.com.banco.entrypoint.model.ElegibilidadePJ;
import br.com.banco.entrypoint.service.ElegibilidadeService;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@DisplayName("Entrypoint :: ElegibilidadeController")
public class ElegibilidadeControllerTest {

    @InjectMocks
    private ElegibilidadeController mockElegibilidadeController;

    @Mock
    private ElegibilidadeService mockElegibilidadeService;

    @Test
    @DisplayName("Deve verificar elegibilidade com sucesso")
    public void deveVerificarElegibilidade() {
        var headers = new HttpHeaders();
        var elegibilidadePj = new ElegibilidadePJ();

        when(mockElegibilidadeService.verificaElegibilidadePJ(headers, elegibilidadePj))
                .thenReturn(elegibilidadePj);

        var retorno = mockElegibilidadeController.verificaElegibilidadePJ(headers, elegibilidadePj);

        assertEquals(retorno.getStatusCode(), HttpStatus.OK);
        assertEquals(retorno.getBody(), elegibilidadePj);
    }
}
