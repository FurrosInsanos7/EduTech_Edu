package cl.edutech.EduTech.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.edutech.EduTech.dto.ContenidoDTO;
import cl.edutech.EduTech.model.Contenido;
import cl.edutech.EduTech.model.Curso;
import cl.edutech.EduTech.repository.ContenidoRepository;
import cl.edutech.EduTech.repository.CursoRepository;
//____________________________________________________________________________________
//SERVICE HECHO POR MACARENA MUÑOZ INCLUYENDO SUS DTO, CONTROLLER, MODEL Y REPOSITORY
//____________________________________________________________________________________
@Service
public class ContenidoService {

    @Autowired
    private ContenidoRepository contenidoRepo;

    @Autowired
    private CursoRepository cursoRepo;

    public String almacenar(ContenidoDTO dto) {
        if (!cursoRepo.existsById(dto.getCursoId())) {
            return "Curso no existe";
        }
        Curso curso = cursoRepo.findById(dto.getCursoId()).get();
        Contenido c = new Contenido();
        c.setTitulo(dto.getTitulo());
        c.setDescripcion(dto.getDescripcion());
        c.setTipo(dto.getTipo());
        c.setOrden(dto.getOrden());
        c.setEstado(dto.getEstado());
        c.setCurso(curso);
        contenidoRepo.save(c);
        return "Contenido almacenado correctamente";
    }

    public List<ContenidoDTO> listar() {
        List<ContenidoDTO> dtos = new ArrayList<>();
        for (Contenido c : contenidoRepo.findAll()) {
            ContenidoDTO dto = new ContenidoDTO();
            dto.setId(c.getId());
            dto.setTitulo(c.getTitulo());
            dto.setDescripcion(c.getDescripcion());
            dto.setTipo(c.getTipo());
            dto.setOrden(c.getOrden());
            dto.setEstado(c.getEstado());
            dto.setCursoId(c.getCurso().getId());
            dtos.add(dto);
        }
        return dtos;
    }

    public String editar(int id, ContenidoDTO dto) {
        if (!contenidoRepo.existsById(id)) {
            return "Contenido no existe";
        }
        if (!cursoRepo.existsById(dto.getCursoId())) {
            return "Curso no existe";
        }
        Contenido c = contenidoRepo.findById(id).get();
        c.setTitulo(dto.getTitulo());
        c.setDescripcion(dto.getDescripcion());
        c.setTipo(dto.getTipo());
        c.setOrden(dto.getOrden());
        c.setEstado(dto.getEstado());
        c.setCurso(cursoRepo.findById(dto.getCursoId()).get());
        contenidoRepo.save(c);
        return "Contenido actualizado correctamente";
    }

    public String eliminar(int id) {
        if (!contenidoRepo.existsById(id)) {
            return "Contenido no existe";
        }
        contenidoRepo.deleteById(id);
        return "Contenido eliminado correctamente";
    }
}
