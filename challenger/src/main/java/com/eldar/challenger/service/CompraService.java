package com.eldar.challenger.service;

import com.eldar.challenger.domain.Tarjeta;
import com.eldar.challenger.repository.TarjetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class CompraService {

    @Autowired
    private TarjetaRepository tarjetaRepository;

    @Autowired
    private JavaMailSender mailSender;

    public boolean realizarCompra(String numeroTarjeta, String cvv, double monto, String detalle) {
        Tarjeta tarjeta = tarjetaRepository.findByNumeroTarjeta(numeroTarjeta);

        if (tarjeta != null && tarjeta.getCvv().equals(cvv) && monto < 10000) {
            // Enviar notificación al usuario por email
            enviarEmailCompra(tarjeta.getUsuario().getEmail(), monto, detalle);
            return true;
        }
        return false;
    }

    private void enviarEmailCompra(String email, double monto, String detalle) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Compra realizada con éxito");
        message.setText("Su compra de " + monto + " ha sido realizada exitosamente. Detalle: " + detalle);

        mailSender.send(message);
    }
}
