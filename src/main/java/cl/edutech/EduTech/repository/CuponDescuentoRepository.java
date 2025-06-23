package cl.edutech.EduTech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.edutech.EduTech.model.CuponDescuento;
import org.springframework.stereotype.Repository;
@Repository
public interface CuponDescuentoRepository extends JpaRepository<CuponDescuento, Integer>{

}
