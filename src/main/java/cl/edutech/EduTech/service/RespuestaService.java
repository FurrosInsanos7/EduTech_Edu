package cl.edutech.EduTech.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.edutech.EduTech.dto.RespuestaDTO;
import cl.edutech.EduTech.model.Pregunta;
import cl.edutech.EduTech.model.Respuesta;
import cl.edutech.EduTech.model.Usuario;
import cl.edutech.EduTech.repository.PreguntaRepository;
import cl.edutech.EduTech.repository.RespuestaRepository;
import cl.edutech.EduTech.repository.UsuarioRepository;

//____________________________________________________________________________________
//SERVICE HECHO POR EDUARDO URBINA INCLUYENDO SUS DTO, CONTROLLER, MODEL Y REPOSITORY
//____________________________________________________________________________________
@Service
public class RespuestaService {

    @Autowired
    private RespuestaRepository respuestaRepository;

    @Autowired
    private PreguntaRepository preguntaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public String almacenar(RespuestaDTO dto) {
        Pregunta pregunta = preguntaRepository.findById(dto.getPreguntaId()).orElse(null);
        if (pregunta == null) {
            return "Pregunta no existe";
        }

        Usuario usuario = usuarioRepository.findById(dto.getUsuarioCorreo()).orElse(null);
        if (usuario == null) {
            return "Usuario no existe";
        }

        Respuesta respuesta = new Respuesta();
        respuesta.setRespuesta(dto.getRespuesta());
        respuesta.setFechaRespuesta(dto.getFechaRespuesta());
        respuesta.setPregunta(pregunta);
        respuesta.setUsuarioRespuesta(usuario);

        respuestaRepository.save(respuesta);
        return "Respuesta almacenada correctamente";
    }

    public List<RespuestaDTO> listar() {
        List<Respuesta> respuestas = respuestaRepository.findAll();
        List<RespuestaDTO> dtos = new ArrayList<>();

        for (Respuesta r : respuestas) {
            RespuestaDTO dto = new RespuestaDTO();
            dto.setId(r.getId());
            dto.setRespuesta(r.getRespuesta());
            dto.setFechaRespuesta(r.getFechaRespuesta());
            dto.setPreguntaId(r.getPregunta().getId());
            dto.setUsuarioCorreo(r.getUsuarioRespuesta().getCorreo());
            dtos.add(dto);
        }

        return dtos;
    }
}
