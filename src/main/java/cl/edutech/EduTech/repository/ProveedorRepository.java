package cl.edutech.EduTech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.edutech.EduTech.model.Proveedor;

import org.springframework.stereotype.Repository;
@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Integer>{

}
