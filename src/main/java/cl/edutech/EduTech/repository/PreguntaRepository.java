package cl.edutech.EduTech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.edutech.EduTech.model.Pregunta;

import org.springframework.stereotype.Repository;
@Repository
public interface PreguntaRepository extends JpaRepository<Pregunta, Integer>{

}
