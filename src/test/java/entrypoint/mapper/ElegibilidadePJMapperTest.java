package entrypoint.mapper;

import br.com.banco.core.usecase.model.ElegibilidadePJDTO;
import br.com.banco.entrypoint.mapper.ElegibilidadePJMapper;
import br.com.banco.entrypoint.model.ElegibilidadePJ;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
@DisplayName("Entrypoint :: ElegibilidadePJMapper")
public class ElegibilidadePJMapperTest {

    private ElegibilidadePJMapper elegibilidadeMapper;

    @Before
    public void setup() {
        elegibilidadeMapper = Mappers.getMapper(ElegibilidadePJMapper.class);
    }

    @Test
    @DisplayName("Deve mapear corretamente o objeto de elegibilidade DTO")
    public void deveMapearElegibilidadePJDTO() {
        var elegibilidadePj = new ElegibilidadePJ();
        elegibilidadePj.setCnpj("123456678901234");
        elegibilidadePj.setElegivel(false);

        var elegibilidadePjDTO = elegibilidadeMapper.elegibilidadePJtoElegibilidadePJDTO(elegibilidadePj);

        assertEquals(elegibilidadePjDTO.getCnpj(), elegibilidadePj.getCnpj());
        assertEquals(elegibilidadePjDTO.getElegivel(), elegibilidadePj.getElegivel());
    }

    @Test
    @DisplayName("Deve mapear corretamente o objeto de elegibilidade")
    public void deveMapearElegibilidadePJ() {
        var elegibilidadePjDTO = new ElegibilidadePJDTO();
        elegibilidadePjDTO.setCnpj("123456678901234");
        elegibilidadePjDTO.setElegivel(false);

        var elegibilidadePj = elegibilidadeMapper.elegibilidadePJDTOtoElegibilidadePJ(elegibilidadePjDTO);

        assertEquals(elegibilidadePj.getCnpj(), elegibilidadePjDTO.getCnpj());
        assertEquals(elegibilidadePj.getElegivel(), elegibilidadePjDTO.getElegivel());
    }
}
