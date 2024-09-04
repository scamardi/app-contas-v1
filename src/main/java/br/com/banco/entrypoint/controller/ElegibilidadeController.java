package br.com.banco.entrypoint.controller;

import br.com.banco.entrypoint.service.ElegibilidadeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.banco.entrypoint.model.ElegibilidadePJ;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/contas/v1")
public class ElegibilidadeController {

    private final ElegibilidadeService elegibilidadeService;

    @PostMapping("/elegibilidade-pessoas-juridicas")
    public ResponseEntity<ElegibilidadePJ> verificaElegibilidadePJ(
            @RequestHeader HttpHeaders httpHeaders,
            @Valid @RequestBody ElegibilidadePJ dadosPJ
    ) {

        return new ResponseEntity<>(elegibilidadeService.verificaElegibilidadePJ(httpHeaders, dadosPJ), HttpStatus.OK);
    }

}
