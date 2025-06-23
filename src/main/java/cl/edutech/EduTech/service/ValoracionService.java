package cl.edutech.EduTech.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.edutech.EduTech.dto.ValoracionDTO;
import cl.edutech.EduTech.model.UsuarioCurso;
import cl.edutech.EduTech.model.Valoracion;
import cl.edutech.EduTech.repository.UsuarioCursoRepository;
import cl.edutech.EduTech.repository.ValoracionRepository;
//____________________________________________________________________________________
//SERVICE HECHO POR EDUARDO URBINA INCLUYENDO SUS DTO, CONTROLLER, MODEL Y REPOSITORY
//____________________________________________________________________________________
@Service
public class ValoracionService {

    @Autowired
    private ValoracionRepository valoracionRepository;

    @Autowired
    private UsuarioCursoRepository usuarioCursoRepository;

    public String almacenar(ValoracionDTO dto) {
        UsuarioCurso uc = usuarioCursoRepository.findById(dto.getUsuarioCursoId()).orElse(null);
        if (uc == null) {
            return "UsuarioCurso no existe";
        }

        Valoracion val = new Valoracion();
        val.setPuntuacion(dto.getPuntuacion());
        val.setFechaValoracion(dto.getFechaValoracion());
        val.setUsuarioCurso(uc);

        valoracionRepository.save(val);
        return "Valoración almacenada correctamente";
    }

    public List<ValoracionDTO> listar() {
        List<Valoracion> lista = valoracionRepository.findAll();
        List<ValoracionDTO> dtos = new ArrayList<>();

        for (Valoracion v : lista) {
            ValoracionDTO dto = new ValoracionDTO();
            dto.setId(v.getId());
            dto.setPuntuacion(v.getPuntuacion());
            dto.setFechaValoracion(v.getFechaValoracion());
            dto.setUsuarioCursoId(v.getUsuarioCurso().getId());
            dtos.add(dto);
        }

        return dtos;
    }
}
