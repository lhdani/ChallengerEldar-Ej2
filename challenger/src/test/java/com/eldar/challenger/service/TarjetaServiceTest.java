package com.eldar.challenger.service;


import com.eldar.challenger.domain.Tarjeta;
import com.eldar.challenger.domain.Usuario;
import com.eldar.challenger.repository.TarjetaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TarjetaServiceTest {

    @Mock
    private TarjetaRepository tarjetaRepository;

    @Mock
    private JavaMailSender mailSender;

    @InjectMocks
    private TarjetaService tarjetaService;


    @Test
    void testAltaTarjeta() {
        Tarjeta tarjeta = new Tarjeta();
        tarjeta.setNumeroTarjeta("343");
        tarjeta.setId(1L);
        tarjeta.setUsuario(new Usuario());
        tarjeta.setFechaVencimiento(LocalDate.now());
        tarjeta.setCvv("323");
        when(tarjetaRepository.save(any(Tarjeta.class))).thenReturn(tarjeta);
        Tarjeta resultado = tarjetaService.altaTarjeta(tarjeta);
        verify(tarjetaRepository, times(1)).save(tarjeta);
        verify(mailSender, times(1)).send(any(SimpleMailMessage.class));

        assertEquals(tarjeta, resultado);
    }

}