// src/main/java/cl/edutech/EduTech/service/CursoService.java
package cl.edutech.EduTech.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.edutech.EduTech.dto.CursoDTO;
import cl.edutech.EduTech.model.Curso;
import cl.edutech.EduTech.model.Instructor;
import cl.edutech.EduTech.repository.CursoRepository;
import cl.edutech.EduTech.repository.InstructorRepository;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepo;

    @Autowired
    private InstructorRepository instructorRepo;

    public String almacenar(CursoDTO dto) {
        Curso c = new Curso();
        c.setNombre(dto.getNombre());
        c.setCategoria(dto.getCategoria());
        c.setNivel(dto.getNivel());
        if (dto.getInstructorRuts() != null) {
            List<Instructor> insList = new ArrayList<>();
            for (String rut : dto.getInstructorRuts()) {
                instructorRepo.findById(rut).ifPresent(insList::add);
            }
            c.setInstructores(insList);
        }
        cursoRepo.save(c);
        return "Curso almacenado correctamente";
    }

    public List<CursoDTO> listar() {
        List<CursoDTO> dtos = new ArrayList<>();
        for (Curso c : cursoRepo.findAll()) {
            CursoDTO dto = new CursoDTO();
            dto.setId(c.getId());
            dto.setNombre(c.getNombre());
            dto.setCategoria(c.getCategoria());
            dto.setNivel(c.getNivel());
            List<String> ruts = new ArrayList<>();
            if (c.getInstructores() != null) {
                for (Instructor i : c.getInstructores()) {
                    ruts.add(i.getRut());
                }
            }
            dto.setInstructorRuts(ruts);
            dtos.add(dto);
        }
        return dtos;
    }

    public String editar(int id, CursoDTO dto) {
        if (!cursoRepo.existsById(id)) {
            return "Curso no existe";
        }
        Curso c = cursoRepo.findById(id).get();
        c.setNombre(dto.getNombre());
        c.setCategoria(dto.getCategoria());
        c.setNivel(dto.getNivel());
        if (dto.getInstructorRuts() != null) {
            List<Instructor> insList = new ArrayList<>();
            for (String rut : dto.getInstructorRuts()) {
                instructorRepo.findById(rut).ifPresent(insList::add);
            }
            c.setInstructores(insList);
        }
        cursoRepo.save(c);
        return "Curso actualizado correctamente";
    }

    public String eliminar(int id) {
        if (!cursoRepo.existsById(id)) {
            return "Curso no existe";
        }
        cursoRepo.deleteById(id);
        return "Curso eliminado correctamente";
    }
}
