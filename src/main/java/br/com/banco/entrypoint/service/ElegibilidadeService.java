package br.com.banco.entrypoint.service;

import br.com.banco.core.usecase.service.ElegibilidadePJCoreService;
import br.com.banco.entrypoint.mapper.ElegibilidadePJMapper;
import br.com.banco.entrypoint.model.ElegibilidadePJ;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import javax.validation.Valid;


@Service
@RequiredArgsConstructor
public class ElegibilidadeService {

    private final ElegibilidadePJCoreService elegibilidadePJCoreService;

    private final ElegibilidadePJMapper elegibilidadePJMapper;

    public ElegibilidadePJ verificaElegibilidadePJ(HttpHeaders httpHeaders, @Valid ElegibilidadePJ dadosPJ) {

        var retornoElegibilidadePJDTO = elegibilidadePJCoreService.verificaElegibilidadePJ(httpHeaders,
                elegibilidadePJMapper.elegibilidadePJtoElegibilidadePJDTO(dadosPJ));

        return elegibilidadePJMapper.elegibilidadePJDTOtoElegibilidadePJ(retornoElegibilidadePJDTO);
    }
}
