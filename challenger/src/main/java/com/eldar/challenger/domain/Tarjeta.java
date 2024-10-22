package com.eldar.challenger.domain;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;


import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "tarjeta")
public class Tarjeta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String numeroTarjeta; // PAN
    private LocalDate fechaVencimiento;
    private String cvv;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
