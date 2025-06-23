package cl.edutech.EduTech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.edutech.EduTech.model.ResultadoEvaluacion;

import org.springframework.stereotype.Repository;
@Repository
public interface ResultadoEvaluacionRepository extends JpaRepository<ResultadoEvaluacion, Integer>{

}
