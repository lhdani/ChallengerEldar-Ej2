package com.eldar.challenger.service;

import com.eldar.challenger.domain.Tarjeta;
import com.eldar.challenger.repository.TarjetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class TarjetaService {

    @Autowired
    private TarjetaRepository tarjetaRepository;

    @Autowired
    private JavaMailSender mailSender;

    public Tarjeta altaTarjeta(Tarjeta tarjeta) {
        Tarjeta savedTarjeta = tarjetaRepository.save(tarjeta);
        enviarEmailConDatosSensibles(savedTarjeta);
        return savedTarjeta;
    }

    private void enviarEmailConDatosSensibles(Tarjeta tarjeta) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(tarjeta.getUsuario().getEmail());
        message.setSubject("Datos de su nueva tarjeta");
        message.setText("Número de tarjeta: " + tarjeta.getNumeroTarjeta() + "\nCVV: " + tarjeta.getCvv());

        mailSender.send(message);
    }
}
