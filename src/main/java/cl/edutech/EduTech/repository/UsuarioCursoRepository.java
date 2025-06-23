package cl.edutech.EduTech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.edutech.EduTech.model.UsuarioCurso;

import org.springframework.stereotype.Repository;
@Repository
public interface UsuarioCursoRepository extends JpaRepository<UsuarioCurso, Integer>{

}
