package dataprovider.database.service;

import br.com.banco.core.usecase.model.ElegibilidadePJDTO;
import br.com.banco.dataprovider.database.model.ElegibilidadePJEntity;
import br.com.banco.dataprovider.database.repository.ElegibilidadePJRepository;
import br.com.banco.dataprovider.database.service.ElegibilidadeDataProviderService;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@DisplayName("DataProvider :: ElegibilidadeDataProviderService")
public class ElegibilidadeDataProviderServiceTest {


    @InjectMocks
    private ElegibilidadeDataProviderService mockElegibilidadeDataProviderService;

    @Mock
    private ElegibilidadePJRepository mockElegibilidadePJRepository;

    @Test
    @DisplayName("Deve verificar elegibilidade validando que o CNPJ exista no banco")
    public void deveVerificarQueCNPJExisteNoBanco() {
        var elegibilidadePjDTO = new ElegibilidadePJDTO("12345678901234", null);

        when(mockElegibilidadePJRepository.findByCnpj(elegibilidadePjDTO.getCnpj()))
                .thenReturn(Optional.of(new ElegibilidadePJEntity()));

        var retorno = mockElegibilidadeDataProviderService.verificar(elegibilidadePjDTO);

        assertTrue(retorno);
    }
}
