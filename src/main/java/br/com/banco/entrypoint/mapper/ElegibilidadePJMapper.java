package br.com.banco.entrypoint.mapper;

import br.com.banco.core.usecase.model.ElegibilidadePJDTO;
import br.com.banco.entrypoint.model.ElegibilidadePJ;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ElegibilidadePJMapper {

    ElegibilidadePJDTO elegibilidadePJtoElegibilidadePJDTO(ElegibilidadePJ elegibilidadePJ);

    ElegibilidadePJ elegibilidadePJDTOtoElegibilidadePJ(ElegibilidadePJDTO elegibilidadePJDTO);

}
