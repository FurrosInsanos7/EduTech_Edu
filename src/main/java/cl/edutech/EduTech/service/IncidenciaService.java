package cl.edutech.EduTech.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.edutech.EduTech.dto.IncidenciaDTO;
import cl.edutech.EduTech.model.Incidencia;
import cl.edutech.EduTech.model.Usuario;
import cl.edutech.EduTech.repository.IncidenciaRepository;
import cl.edutech.EduTech.repository.UsuarioRepository;
//____________________________________________________________________________________
//SERVICE HECHO POR MACARENA MUÑOZ INCLUYENDO SUS DTO, CONTROLLER, MODEL Y REPOSITORY
//____________________________________________________________________________________
@Service
public class IncidenciaService {

    @Autowired
    private IncidenciaRepository incidenciaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public String almacenar(IncidenciaDTO dto) {
        Usuario reporta = usuarioRepository.findById(dto.getUsuarioReportaCorreo()).orElse(null);
        if (reporta == null) {
            return "Usuario reporta no existe";
        }

        Incidencia inc = new Incidencia();
        inc.setTitulo(dto.getTitulo());
        inc.setDescripcion(dto.getDescripcion());
        inc.setFechaReporte(dto.getFechaReporte());
        inc.setEstado(dto.getEstado());
        inc.setPrioridad(dto.getPrioridad());
        inc.setUsuarioReporta(reporta);

        if (dto.getAgenteAsignadoCorreo() != null) {
            Usuario agente = usuarioRepository.findById(dto.getAgenteAsignadoCorreo()).orElse(null);
            if (agente == null) {
                return "Usuario agente no existe";
            }
            inc.setAgenteAsignado(agente);
        }

        incidenciaRepository.save(inc);
        return "Incidencia almacenada correctamente";
    }

    public List<IncidenciaDTO> listar() {
        List<Incidencia> list = incidenciaRepository.findAll();
        List<IncidenciaDTO> dtos = new ArrayList<>();

        for (Incidencia inc : list) {
            IncidenciaDTO dto = new IncidenciaDTO();
            dto.setId(inc.getId());
            dto.setTitulo(inc.getTitulo());
            dto.setDescripcion(inc.getDescripcion());
            dto.setFechaReporte(inc.getFechaReporte());
            dto.setEstado(inc.getEstado());
            dto.setPrioridad(inc.getPrioridad());
            dto.setUsuarioReportaCorreo(inc.getUsuarioReporta().getCorreo());
            dto.setAgenteAsignadoCorreo(
                inc.getAgenteAsignado() != null ? inc.getAgenteAsignado().getCorreo() : null);
            dtos.add(dto);
        }
        return dtos;
    }

}
