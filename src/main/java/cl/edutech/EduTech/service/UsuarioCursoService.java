package cl.edutech.EduTech.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.edutech.EduTech.dto.UsuarioCursoDTO;
import cl.edutech.EduTech.model.CuponDescuento;
import cl.edutech.EduTech.model.Curso;
import cl.edutech.EduTech.model.Usuario;
import cl.edutech.EduTech.model.UsuarioCurso;
import cl.edutech.EduTech.repository.CuponDescuentoRepository;
import cl.edutech.EduTech.repository.CursoRepository;
import cl.edutech.EduTech.repository.UsuarioCursoRepository;
import cl.edutech.EduTech.repository.UsuarioRepository;

@Service
public class UsuarioCursoService {

    @Autowired private UsuarioCursoRepository usuarioCursoRepo;
    @Autowired private UsuarioRepository usuarioRepo;
    @Autowired private CursoRepository cursoRepo;
    @Autowired private CuponDescuentoRepository cuponRepo;

    public String almacenar(UsuarioCursoDTO dto) {
        Optional<Usuario> uOpt = usuarioRepo.findById(dto.getUsuarioCorreo());
        if (uOpt.isEmpty()) return "Usuario no existe";

        Optional<Curso> cOpt = cursoRepo.findById(dto.getCursoId());
        if (cOpt.isEmpty()) return "Curso no existe";

        UsuarioCurso uc = new UsuarioCurso();
        uc.setUsuario(uOpt.get());
        uc.setCurso(cOpt.get());
        uc.setFechaInscripcion(dto.getFechaInscripcion());
        uc.setProgreso(dto.getProgreso());
        uc.setFechaFinalizado(dto.getFechaFinalizado());

        if (dto.getCuponId() != null) {
            Optional<CuponDescuento> cupOpt = cuponRepo.findById(dto.getCuponId());
            if (cupOpt.isEmpty()) return "Cupon no existe";
            CuponDescuento cup = cupOpt.get();
            // validar expiración
            if (cup.getFechaExpiracion().isBefore(LocalDateTime.now()))
                return "Cupon expirado";
            // validar usos restantes
            if (cup.getUsoAct() >= cup.getUsoMax())
                return "Cupon agotado";
            // aplicar cupón
            uc.setCuponAplicado(cup);
            // incrementar contador y guardar cupón
            cup.setUsoAct(cup.getUsoAct() + 1);
            cuponRepo.save(cup);
        }

        usuarioCursoRepo.save(uc);
        return "UsuarioCurso almacenado correctamente";
    }

    public List<UsuarioCursoDTO> listar() {
        return usuarioCursoRepo.findAll().stream()
            .map(this::mapToDTO)
            .collect(Collectors.toList());
    }

    public String editar(int id, UsuarioCursoDTO dto) {
        Optional<UsuarioCurso> ucOpt = usuarioCursoRepo.findById(id);
        if (ucOpt.isEmpty()) return "UsuarioCurso no existe";

        UsuarioCurso uc = ucOpt.get();
        uc.setFechaInscripcion(dto.getFechaInscripcion());
        uc.setProgreso(dto.getProgreso());
        uc.setFechaFinalizado(dto.getFechaFinalizado());
        usuarioCursoRepo.save(uc);
        return "UsuarioCurso actualizado correctamente";
    }

    public String eliminar(int id) {
        Optional<UsuarioCurso> ucOpt = usuarioCursoRepo.findById(id);
        if (ucOpt.isEmpty()) return "UsuarioCurso no existe";
        usuarioCursoRepo.delete(ucOpt.get());
        return "UsuarioCurso eliminado correctamente";
    }

    private UsuarioCursoDTO mapToDTO(UsuarioCurso uc) {
        UsuarioCursoDTO dto = new UsuarioCursoDTO();
        dto.setId(uc.getId());
        dto.setUsuarioCorreo(uc.getUsuario().getCorreo());
        dto.setCursoId(uc.getCurso().getId());
        dto.setFechaInscripcion(uc.getFechaInscripcion());
        dto.setProgreso(uc.getProgreso());
        dto.setFechaFinalizado(uc.getFechaFinalizado());
        if (uc.getCuponAplicado() != null) {
            dto.setCuponId(uc.getCuponAplicado().getId());
        }
        return dto;
    }
}
