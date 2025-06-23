package cl.edutech.EduTech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.edutech.EduTech.model.Respuesta;

import org.springframework.stereotype.Repository;
@Repository
public interface RespuestaRepository extends JpaRepository<Respuesta, Integer>{

}
