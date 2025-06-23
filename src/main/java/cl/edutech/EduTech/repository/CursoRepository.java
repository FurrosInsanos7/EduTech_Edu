package cl.edutech.EduTech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.edutech.EduTech.model.Curso;

import org.springframework.stereotype.Repository;
@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer>{

}
