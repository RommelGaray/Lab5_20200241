package com.example.lab5gtics.repository;

import com.example.lab5gtics.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {
}
