package com.example.opapi.respository;

import com.example.opapi.model.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonajeRespository extends JpaRepository<Personaje, Long> {
}
