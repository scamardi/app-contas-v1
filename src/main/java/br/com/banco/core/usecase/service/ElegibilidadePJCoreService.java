package br.com.banco.core.usecase.service;

import br.com.banco.core.usecase.model.ElegibilidadePJDTO;
import br.com.banco.dataprovider.database.service.ElegibilidadeDataProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
@RequiredArgsConstructor
public class ElegibilidadePJCoreService {

    private final ElegibilidadeDataProviderService elegibilidadeDataProviderService;

    public ElegibilidadePJDTO verificaElegibilidadePJ(HttpHeaders httpHeaders, @Valid ElegibilidadePJDTO dadosPJ) {
        dadosPJ.setElegivel(elegibilidadeDataProviderService.verificar(dadosPJ));

        return dadosPJ;
    }
}
