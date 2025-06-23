package cl.edutech.EduTech.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.edutech.EduTech.dto.PreferenciaDTO;
import cl.edutech.EduTech.model.Preferencia;
import cl.edutech.EduTech.model.Usuario;
import cl.edutech.EduTech.repository.PreferenciaRepository;
import cl.edutech.EduTech.repository.UsuarioRepository;
//____________________________________________________________________________________
//SERVICE HECHO POR MACARENA MUÑOZ INCLUYENDO SUS DTO, CONTROLLER, MODEL Y REPOSITORY
//____________________________________________________________________________________
@Service
public class PreferenciaService {

    @Autowired
    private PreferenciaRepository preferenciaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public String almacenar(PreferenciaDTO dto) {
        Preferencia pref = new Preferencia();
        pref.setDescripcion(dto.getDescripcion());

        if (dto.getUsuarioCorreos() != null) {
            List<Usuario> usuarios = new ArrayList<>();
            for (String correo : dto.getUsuarioCorreos()) {
                usuarioRepository.findById(correo).ifPresent(usuarios::add);
            }
            pref.setUsuarios(usuarios);
        }

        preferenciaRepository.save(pref);
        return "Preferencia almacenada correctamente";
    }

    public List<PreferenciaDTO> listar() {
        List<Preferencia> prefs = preferenciaRepository.findAll();
        List<PreferenciaDTO> dtos = new ArrayList<>();

        for (Preferencia p : prefs) {
            PreferenciaDTO dto = new PreferenciaDTO();
            dto.setId(p.getId());
            dto.setDescripcion(p.getDescripcion());

            List<String> correos = new ArrayList<>();
            if (p.getUsuarios() != null) {
                for (Usuario u : p.getUsuarios()) {
                    correos.add(u.getCorreo());
                }
            }
            dto.setUsuarioCorreos(correos);

            dtos.add(dto);
        }
        return dtos;
    }
}
