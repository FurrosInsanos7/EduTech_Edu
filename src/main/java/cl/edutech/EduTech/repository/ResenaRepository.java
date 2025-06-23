package cl.edutech.EduTech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.edutech.EduTech.model.Resena;
import org.springframework.stereotype.Repository;
@Repository
public interface ResenaRepository extends JpaRepository<Resena, Integer>{

}
