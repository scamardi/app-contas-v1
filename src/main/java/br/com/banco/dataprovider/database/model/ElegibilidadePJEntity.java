package br.com.banco.dataprovider.database.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "elegibilidade_pj")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ElegibilidadePJEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(nullable = false, unique = true)
    private String cnpj;

}
