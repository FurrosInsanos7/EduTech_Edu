package cl.edutech.EduTech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.edutech.EduTech.model.Tarjeta;

import org.springframework.stereotype.Repository;

@Repository
public interface TarjetaRepository extends JpaRepository<Tarjeta, Integer>{

}
