package cl.edutech.EduTech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.edutech.EduTech.dto.UsuarioDTO;
import cl.edutech.EduTech.model.Rol;
import cl.edutech.EduTech.model.Usuario;
import cl.edutech.EduTech.repository.RolRepository;
import cl.edutech.EduTech.repository.UsuarioRepository;

import java.util.ArrayList;
import java.util.List;
//____________________________________________________________________________________
//SERVICE HECHO POR EDUARDO URBINA INCLUYENDO SUS DTO, CONTROLLER, MODEL Y REPOSITORY
//____________________________________________________________________________________

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    public String almacenar(UsuarioDTO dto) {
        if (usuarioRepository.existsById(dto.getCorreo())) {
            return "Usuario ya existe";
        }

        Usuario usuario = new Usuario();
        usuario.setCorreo(dto.getCorreo());
        usuario.setNombre(dto.getNombre());
        usuario.setApellido(dto.getApellido());
        usuario.setEstado(dto.getEstado());

        List<Rol> roles = new ArrayList<>();
        if (dto.getRolIds() != null) {
            for (Integer rolId : dto.getRolIds()) {
                rolRepository.findById(rolId).ifPresent(roles::add);
            }
        }
        usuario.setRoles(roles);

        usuarioRepository.save(usuario);
        return "Usuario almacenado correctamente";
    }

    public List<UsuarioDTO> listar() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<UsuarioDTO> dtos = new ArrayList<>();

        for (Usuario u : usuarios) {
            UsuarioDTO dto = new UsuarioDTO();
            dto.setCorreo(u.getCorreo());
            dto.setNombre(u.getNombre());
            dto.setApellido(u.getApellido());
            dto.setEstado(u.getEstado());
            List<Integer> rolIds = new ArrayList<>();
            if (u.getRoles() != null) {
                for (Rol r : u.getRoles()) {
                    rolIds.add(r.getId());
                }
            }
            dto.setRolIds(rolIds);
            dtos.add(dto);
        }
        return dtos;
    }

    public String asignarRolAUsuario(String correoUsuario, int rolId) {
        Usuario usuario = usuarioRepository.findById(correoUsuario).orElse(null);
        if (usuario == null) {
            return "Usuario no existe";
        }
        Rol rol = rolRepository.findById(rolId).orElse(null);
        if (rol == null) {
            return "Rol no existe";
        }

        usuario.getRoles().add(rol);
        usuarioRepository.save(usuario);

        return "Rol asignado correctamente";
    }

    public String editarUsuario(String correoUsuario, UsuarioDTO dto) {
        Usuario usuario = usuarioRepository.findById(correoUsuario).orElse(null);
        if (usuario == null) {
            return "Usuario no existe";
        }

        usuario.setNombre(dto.getNombre());
        usuario.setApellido(dto.getApellido());
        usuario.setEstado(dto.getEstado());

        // Actualizar roles
        List<Rol> roles = new ArrayList<>();
        if (dto.getRolIds() != null) {
            for (Integer rolId : dto.getRolIds()) {
                rolRepository.findById(rolId).ifPresent(roles::add);
            }
        }
        usuario.setRoles(roles);

        usuarioRepository.save(usuario);
        return "Usuario actualizado correctamente";
    }

    public String eliminarUsuario(String correoUsuario) {
        Usuario usuario = usuarioRepository.findById(correoUsuario).orElse(null);
        if (usuario == null) {
            return "Usuario no existe";
        }

        usuarioRepository.delete(usuario);
        return "Usuario eliminado correctamente";
    }
}
