package core.usecase.service;

import br.com.banco.core.usecase.model.ElegibilidadePJDTO;
import br.com.banco.core.usecase.service.ElegibilidadePJCoreService;
import br.com.banco.dataprovider.database.service.ElegibilidadeDataProviderService;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpHeaders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@DisplayName("Core :: ElegibilidadePJCoreService")
public class ElegibilidadePJCoreServiceTest {

    @InjectMocks
    private ElegibilidadePJCoreService mockElegibilidadePJCoreService;

    @Mock
    private ElegibilidadeDataProviderService mockElegibilidadeDataProviderService;

    @Test
    @DisplayName("Deve verificar elegibilidade com sucesso")
    public void deveVerificarElegibilidade() {
        var headers = new HttpHeaders();
        var elegibilidadePjDTO = new ElegibilidadePJDTO("12345678901234", null);

        when(mockElegibilidadeDataProviderService.verificar(elegibilidadePjDTO))
                .thenReturn(true);

        var retorno = mockElegibilidadePJCoreService.verificaElegibilidadePJ(headers, elegibilidadePjDTO);

        assertEquals(retorno.getCnpj(), elegibilidadePjDTO.getCnpj());
        assertEquals(retorno.getElegivel(), true);
    }
}
