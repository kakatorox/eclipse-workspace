package cl.presentacion.formuval.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.presentacion.formuval.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Integer>{

}
