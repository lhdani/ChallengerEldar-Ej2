package com.eldar.challenger.controller;


import com.eldar.challenger.service.CompraService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/operaciones")
@Tag(description = "Realizar operaciones", name = "Operaciones")
public class OperacionController {

    @Autowired
    private CompraService compraService;

    @PostMapping("/compra")
    @Operation(summary = "Realizar una compra", description = "Registra una compra con los datos de la tarjeta")
    public String realizarCompra(@RequestParam String numeroTarjeta,
                                 @RequestParam String cvv,
                                 @RequestParam double monto,
                                 @RequestParam String detalle) {
        boolean exito = compraService.realizarCompra(numeroTarjeta, cvv, monto, detalle);

        if (exito) {
            return "Compra realizada con éxito";
        } else {
            return "Error en la compra, verifique los datos.";
        }
    }

    @GetMapping("/tasa")
    @Operation(summary = "Tasa de tarjetas", description = "Calcular la tasa según la marca de la tarjeta")
    public double consultarTasa(@RequestParam String marca, @RequestParam double importe) {
        return calcularTasa(marca, importe);
    }

    private double calcularTasa(String marca, double importe) {
        LocalDate fecha = LocalDate.now();
        switch (marca.toUpperCase()) {
            case "VISA":
                return fecha.getYear() / (double) fecha.getMonthValue();
            case "NARA":
                return fecha.getDayOfMonth() * 0.5;
            case "AMEX":
                return fecha.getMonthValue() * 0.1;
            default:
                throw new IllegalArgumentException("Marca no soportada");
        }
    }
}
