package entrypoint.service;

import br.com.banco.core.usecase.model.ElegibilidadePJDTO;
import br.com.banco.core.usecase.service.ElegibilidadePJCoreService;
import br.com.banco.entrypoint.mapper.ElegibilidadePJMapper;
import br.com.banco.entrypoint.model.ElegibilidadePJ;
import br.com.banco.entrypoint.service.ElegibilidadeService;
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
@DisplayName("Entrypoint :: ElegibilidadeServiceTest")
public class ElegibilidadeServiceTest {

    @InjectMocks
    private ElegibilidadeService mockElegibilidadeService;

    @Mock
    private ElegibilidadePJCoreService mockElegibilidadePJCoreService;

    @Mock
    private ElegibilidadePJMapper mockElegibilidadePJMapper;

    @Test
    @DisplayName("Deve verificar elegibilidade com sucesso")
    public void deveVerificarElegibilidade() {
        var headers = new HttpHeaders();
        var elegibilidadePjDTO = new ElegibilidadePJDTO("12345678901234", true);
        var elegibilidadePj = new ElegibilidadePJ();
        elegibilidadePj.setCnpj(elegibilidadePjDTO.getCnpj());
        elegibilidadePj.setElegivel(elegibilidadePjDTO.getElegivel());

        when(mockElegibilidadePJCoreService.verificaElegibilidadePJ(headers, elegibilidadePjDTO))
                .thenReturn(elegibilidadePjDTO);
        when(mockElegibilidadePJMapper.elegibilidadePJDTOtoElegibilidadePJ(elegibilidadePjDTO))
                .thenReturn(elegibilidadePj);
        when(mockElegibilidadePJMapper.elegibilidadePJtoElegibilidadePJDTO(elegibilidadePj))
                .thenReturn(elegibilidadePjDTO);

        var retorno = mockElegibilidadeService.verificaElegibilidadePJ(headers, elegibilidadePj);

        assertEquals(retorno.getCnpj(), elegibilidadePjDTO.getCnpj());
        assertEquals(retorno.getElegivel(), elegibilidadePjDTO.getElegivel());
    }
}
