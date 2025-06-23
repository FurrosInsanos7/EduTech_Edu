package cl.edutech.EduTech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.edutech.EduTech.dto.UsuarioDTO;
import cl.edutech.EduTech.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioDTO> listar() {
        return usuarioService.listar();
    }

    @PostMapping
    public String almacenar(@RequestBody UsuarioDTO dto) {
        return usuarioService.almacenar(dto);
    }

    @PostMapping("/{correo}/rol/{rolId}")
    public String asignarRol(@PathVariable String correo,
                             @PathVariable int rolId) {
        return usuarioService.asignarRolAUsuario(correo, rolId);
    }

    @PutMapping("/{correo}")
    public String editar(@PathVariable String correo,
                         @RequestBody UsuarioDTO dto) {
        return usuarioService.editarUsuario(correo, dto);
    }

    @DeleteMapping("/{correo}")
    public String eliminar(@PathVariable String correo) {
        return usuarioService.eliminarUsuario(correo);
    }
}
