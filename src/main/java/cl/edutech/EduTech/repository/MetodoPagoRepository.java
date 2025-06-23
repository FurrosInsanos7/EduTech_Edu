package cl.edutech.EduTech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.edutech.EduTech.model.MetodoPago;

import org.springframework.stereotype.Repository;
@Repository
public interface MetodoPagoRepository extends JpaRepository<MetodoPago, Integer>{

}
