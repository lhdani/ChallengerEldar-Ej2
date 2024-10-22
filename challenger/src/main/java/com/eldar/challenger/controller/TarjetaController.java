package com.eldar.challenger.controller;


import com.eldar.challenger.domain.Tarjeta;
import com.eldar.challenger.service.TarjetaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tarjetas")
@Tag(description = "Gestión de Tarjetas", name = "Tarjetas")
public class TarjetaController {

    @Autowired
    private TarjetaService tarjetaService;

    @PostMapping("/alta")
    @Operation(summary = "Alta de una nueva tarjeta", description = "Registra una nueva tarjeta y envía los datos sensibles al email del tarjetahabiente")
    public Tarjeta altaTarjeta(@RequestBody Tarjeta tarjeta) {
        return tarjetaService.altaTarjeta(tarjeta);
    }
}
