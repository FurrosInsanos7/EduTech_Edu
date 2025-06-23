package cl.edutech.EduTech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.edutech.EduTech.model.Preferencia;

@Repository
public interface PreferenciaRepository extends JpaRepository<Preferencia, Integer> {
    
}
