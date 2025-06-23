package cl.edutech.EduTech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.edutech.EduTech.model.Incidencia;

import org.springframework.stereotype.Repository;
@Repository
public interface IncidenciaRepository extends JpaRepository<Incidencia, Integer>{

}
