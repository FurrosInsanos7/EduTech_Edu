package cl.edutech.EduTech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.edutech.EduTech.model.Contenido;

@Repository
public interface ContenidoRepository extends JpaRepository<Contenido, Integer>{

}
