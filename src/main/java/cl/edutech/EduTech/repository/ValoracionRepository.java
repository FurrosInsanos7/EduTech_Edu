package cl.edutech.EduTech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.edutech.EduTech.model.Valoracion;

import org.springframework.stereotype.Repository;
@Repository
public interface ValoracionRepository extends JpaRepository<Valoracion, Integer>{

}
