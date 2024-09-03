package br.com.banco.dataprovider.database.repository;

import br.com.banco.dataprovider.database.model.ElegibilidadePJEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ElegibilidadePJRepository extends JpaRepository<ElegibilidadePJEntity, String> {

    Optional<ElegibilidadePJEntity> findByCnpj(String cnpj);
}
