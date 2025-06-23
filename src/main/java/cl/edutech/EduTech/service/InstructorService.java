package cl.edutech.EduTech.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.edutech.EduTech.dto.InstructorDTO;
import cl.edutech.EduTech.model.Curso;
import cl.edutech.EduTech.model.Instructor;
import cl.edutech.EduTech.repository.CursoRepository;
import cl.edutech.EduTech.repository.InstructorRepository;
//____________________________________________________________________________________
//SERVICE HECHO POR MACARENA MUÑOZ INCLUYENDO SUS DTO, CONTROLLER, MODEL Y REPOSITORY
//____________________________________________________________________________________
@Service
public class InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public String almacenar(InstructorDTO dto) {
        if (instructorRepository.existsById(dto.getRut())) {
            return "Instructor ya existe";
        }

        Instructor ins = new Instructor();
        ins.setRut(dto.getRut());
        ins.setCorreo(dto.getCorreo());
        ins.setContrasena(dto.getContrasena());
        ins.setNombre(dto.getNombre());
        ins.setApellido(dto.getApellido());
        ins.setEstado(dto.getEstado());

        if (dto.getCursoIds() != null) {
            List<Curso> cursos = new ArrayList<>();
            for (Integer cid : dto.getCursoIds()) {
                cursoRepository.findById(cid).ifPresent(cursos::add);
            }
            ins.setCursos(cursos);
        }

        instructorRepository.save(ins);
        return "Instructor almacenado correctamente";
    }

    public List<InstructorDTO> listar() {
        List<Instructor> lista = instructorRepository.findAll();
        List<InstructorDTO> dtos = new ArrayList<>();

        for (Instructor ins : lista) {
            InstructorDTO dto = new InstructorDTO();
            dto.setRut(ins.getRut());
            dto.setCorreo(ins.getCorreo());
            dto.setContrasena(ins.getContrasena());
            dto.setNombre(ins.getNombre());
            dto.setApellido(ins.getApellido());
            dto.setEstado(ins.getEstado());

            List<Integer> cids = new ArrayList<>();
            if (ins.getCursos() != null) {
                for (Curso c : ins.getCursos()) {
                    cids.add(c.getId());
                }
            }
            dto.setCursoIds(cids);

            dtos.add(dto);
        }

        return dtos;
    }
}

