package cl.edutech.EduTech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.edutech.EduTech.model.Instructor;

import org.springframework.stereotype.Repository;
@Repository
public interface InstructorRepository extends JpaRepository<Instructor, String>{

}
