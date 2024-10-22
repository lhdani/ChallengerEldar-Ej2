package com.eldar.challenger.repository;


import com.eldar.challenger.domain.Tarjeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarjetaRepository extends JpaRepository<Tarjeta, Long> {

    Tarjeta findByNumeroTarjeta(String numeroTarjeta);
}
