package cl.edutech.EduTech;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import cl.edutech.EduTech.dto.UsuarioDTO;
import cl.edutech.EduTech.model.Usuario;
import cl.edutech.EduTech.model.Rol;
import cl.edutech.EduTech.repository.UsuarioRepository;
import cl.edutech.EduTech.repository.RolRepository;
import cl.edutech.EduTech.service.UsuarioService;

@ExtendWith(MockitoExtension.class)
public class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private RolRepository rolRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    @Test
    void almacenarUsuarioNuevo() {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setCorreo("edu@gmail.com");
        dto.setNombre("Eduardo");
        dto.setApellido("Gonzalez");
        dto.setEstado(1);
        dto.setRolIds(List.of(1));

        when(usuarioRepository.existsById(dto.getCorreo())).thenReturn(false);
        when(rolRepository.findById(1)).thenReturn(Optional.of(new Rol()));
        when(usuarioRepository.save(org.mockito.ArgumentMatchers.any(Usuario.class)))
            .thenAnswer(i -> i.getArgument(0));

        String resultado = usuarioService.almacenar(dto);

        assertEquals("Usuario almacenado correctamente", resultado);
    }

    @Test
    void almacenarUsuarioExistente() {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setCorreo("edu@gmail.com");
        dto.setNombre("Eduardo");
        dto.setApellido("Gonzalez");
        dto.setEstado(1);

        when(usuarioRepository.existsById(dto.getCorreo())).thenReturn(true);

        String resultado = usuarioService.almacenar(dto);

        assertEquals("Usuario ya existe", resultado);
    }

    @Test
    void listarUsuarios() {
        Usuario u1 = new Usuario();
        u1.setCorreo("edu@gmail.com");
        u1.setNombre("Eduardo");
        u1.setApellido("Gonzalez");

        Usuario u2 = new Usuario();
        u2.setCorreo("ana@gmail.com");
        u2.setNombre("Ana");
        u2.setApellido("Martinez");

        when(usuarioRepository.findAll())
            .thenReturn(List.of(u1, u2));

        List<UsuarioDTO> lista = usuarioService.listar();

        assertEquals(2, lista.size());
    }

    @Test
    void editarUsuario_Success() {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setCorreo("edu@gmail.com");
        dto.setNombre("Nuevo");
        dto.setApellido("Nombre");
        dto.setEstado(2);
        dto.setRolIds(new ArrayList<>());

        Usuario u = new Usuario();
        u.setCorreo("edu@gmail.com");
        u.setNombre("Viejo");
        u.setApellido("Usuario");
        u.setEstado(1);
        u.setRoles(new ArrayList<>());

        when(usuarioRepository.findById("edu@gmail.com"))
            .thenReturn(Optional.of(u));
        when(usuarioRepository.save(org.mockito.ArgumentMatchers.any(Usuario.class)))
            .thenAnswer(i -> i.getArgument(0));

        String resultado = usuarioService.editarUsuario("edu@gmail.com", dto);

        assertEquals("Usuario actualizado correctamente", resultado);
    }

    @Test
    void editarUsuario_UsuarioNoExiste() {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setCorreo("no@mail.com");
        dto.setNombre("X");
        dto.setApellido("Y");
        dto.setEstado(1);

        when(usuarioRepository.findById("no@mail.com"))
            .thenReturn(Optional.empty());

        String resultado = usuarioService.editarUsuario("no@mail.com", dto);

        assertEquals("Usuario no existe", resultado);
    }

    @Test
    void eliminarUsuario_Success() {
        Usuario u = new Usuario();
        u.setCorreo("borrar@mail.com");

        when(usuarioRepository.findById("borrar@mail.com"))
            .thenReturn(Optional.of(u));

        String resultado = usuarioService.eliminarUsuario("borrar@mail.com");

        assertEquals("Usuario eliminado correctamente", resultado);
    }

    @Test
    void eliminarUsuario_NoExiste() {
        when(usuarioRepository.findById("borrar@mail.com"))
            .thenReturn(Optional.empty());

        String resultado = usuarioService.eliminarUsuario("borrar@mail.com");

        assertEquals("Usuario no existe", resultado);
    }
}
