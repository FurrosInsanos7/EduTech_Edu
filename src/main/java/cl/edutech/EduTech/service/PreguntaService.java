package cl.edutech.EduTech.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.edutech.EduTech.dto.PreguntaDTO;
import cl.edutech.EduTech.model.Pregunta;
import cl.edutech.EduTech.model.Respuesta;
import cl.edutech.EduTech.model.Usuario;
import cl.edutech.EduTech.model.UsuarioCurso;
import cl.edutech.EduTech.repository.PreguntaRepository;
import cl.edutech.EduTech.repository.RespuestaRepository;
import cl.edutech.EduTech.repository.UsuarioCursoRepository;
import cl.edutech.EduTech.repository.UsuarioRepository;
//____________________________________________________________________________________
//SERVICE HECHO POR MACARENA MUÑOZ INCLUYENDO SUS DTO, CONTROLLER, MODEL Y REPOSITORY
//____________________________________________________________________________________
@Service
public class PreguntaService {

    @Autowired
    private PreguntaRepository preguntaRepository;

    @Autowired
    private UsuarioCursoRepository usuarioCursoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RespuestaRepository respuestaRepository;

    public String almacenar(PreguntaDTO dto) {
        UsuarioCurso uc = usuarioCursoRepository.findById(dto.getUsuarioCursoId()).orElse(null);
        if (uc == null) {
            return "UsuarioCurso no existe";
        }

        Usuario u = usuarioRepository.findById(dto.getUsuarioPreguntaCorreo()).orElse(null);
        if (u == null) {
            return "Usuario no existe";
        }

        Pregunta preg = new Pregunta();
        preg.setPregunta(dto.getPregunta());
        preg.setCuerpoPregunta(dto.getCuerpoPregunta());
        preg.setFechaPregunta(dto.getFechaPregunta());
        preg.setSeRespondio(dto.getSeRespondio());
        preg.setUsuarioCurso(uc);
        preg.setUsuarioPregunta(u);

        if (dto.getRespuestaIds() != null) {
            List<Respuesta> respuestas = new ArrayList<>();
            for (Integer rid : dto.getRespuestaIds()) {
                respuestaRepository.findById(rid).ifPresent(respuestas::add);
            }
            preg.setRespuestas(respuestas);
        }

        preguntaRepository.save(preg);
        return "Pregunta almacenada correctamente";
    }

    public List<PreguntaDTO> listar() {
        List<Pregunta> lista = preguntaRepository.findAll();
        List<PreguntaDTO> dtos = new ArrayList<>();

        for (Pregunta p : lista) {
            PreguntaDTO dto = new PreguntaDTO();
            dto.setId(p.getId());
            dto.setPregunta(p.getPregunta());
            dto.setCuerpoPregunta(p.getCuerpoPregunta());
            dto.setFechaPregunta(p.getFechaPregunta());
            dto.setSeRespondio(p.getSeRespondio());
            dto.setUsuarioCursoId(p.getUsuarioCurso().getId());
            dto.setUsuarioPreguntaCorreo(p.getUsuarioPregunta().getCorreo());

            List<Integer> rids = new ArrayList<>();
            if (p.getRespuestas() != null) {
                for (Respuesta r : p.getRespuestas()) {
                    rids.add(r.getId());
                }
            }
            dto.setRespuestaIds(rids);

            dtos.add(dto);
        }

        return dtos;
    }
}
