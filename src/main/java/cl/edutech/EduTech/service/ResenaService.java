package cl.edutech.EduTech.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.edutech.EduTech.dto.ResenaDTO;
import cl.edutech.EduTech.model.Resena;
import cl.edutech.EduTech.model.UsuarioCurso;
import cl.edutech.EduTech.repository.ResenaRepository;
import cl.edutech.EduTech.repository.UsuarioCursoRepository;
//____________________________________________________________________________________
//SERVICE HECHO POR EDUARDO URBINA INCLUYENDO SUS DTO, CONTROLLER, MODEL Y REPOSITORY
//____________________________________________________________________________________
@Service
public class ResenaService {

    @Autowired
    private ResenaRepository resenaRepository;

    @Autowired
    private UsuarioCursoRepository usuarioCursoRepository;

    public String almacenar(ResenaDTO dto) {
        UsuarioCurso uc = usuarioCursoRepository.findById(dto.getUsuarioCursoId()).orElse(null);
        if (uc == null) {
            return "UsuarioCurso no existe";
        }

        Resena resena = new Resena();
        resena.setComentario(dto.getComentario());
        resena.setFechaResena(dto.getFechaResena());
        resena.setUsuarioCurso(uc);

        resenaRepository.save(resena);
        return "Reseña almacenada correctamente";
    }

    public List<ResenaDTO> listar() {
        List<Resena> resenas = resenaRepository.findAll();
        List<ResenaDTO> dtos = new ArrayList<>();

        for (Resena r : resenas) {
            ResenaDTO dto = new ResenaDTO();
            dto.setId(r.getId());
            dto.setComentario(r.getComentario());
            dto.setFechaResena(r.getFechaResena());
            dto.setUsuarioCursoId(r.getUsuarioCurso().getId());
            dtos.add(dto);
        }

        return dtos;
    }
}

