package br.com.banco.core.dao.dataprovider;

import br.com.banco.core.usecase.model.ElegibilidadePJDTO;

public interface ElegibilidadeContaPJDAO {

    boolean verificar(ElegibilidadePJDTO elegibilidadePJDTO);
}
