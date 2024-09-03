package br.com.banco.core.usecase.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ElegibilidadePJDTO {

    @JsonProperty("cnpj")
    private String cnpj;

    @JsonProperty("elegivel")
    private Boolean elegivel;

}
