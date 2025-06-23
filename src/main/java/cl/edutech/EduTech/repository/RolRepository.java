package cl.edutech.EduTech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.edutech.EduTech.model.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol,Integer> {

}
