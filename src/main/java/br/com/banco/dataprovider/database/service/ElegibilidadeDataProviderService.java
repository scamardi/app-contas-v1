package br.com.banco.dataprovider.database.service;

import br.com.banco.core.dao.dataprovider.ElegibilidadeContaPJDAO;
import br.com.banco.core.usecase.model.ElegibilidadePJDTO;
import br.com.banco.dataprovider.database.repository.ElegibilidadePJRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ElegibilidadeDataProviderService implements ElegibilidadeContaPJDAO {

    private final ElegibilidadePJRepository elegibilidadePJRepository;

    @Override
    public boolean verificar(ElegibilidadePJDTO elegibilidadePJDTO) {

        return elegibilidadePJRepository.findByCnpj(elegibilidadePJDTO.getCnpj()).isPresent();
    }

}
