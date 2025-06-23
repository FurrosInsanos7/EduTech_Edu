package cl.edutech.EduTech.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cl.edutech.EduTech.dto.UsuarioCursoDTO;
import cl.edutech.EduTech.service.UsuarioCursoService;

@RestController
@RequestMapping("/usuariocurso")
public class UsuarioCursoController {

    @Autowired private UsuarioCursoService usuarioCursoService;

    @GetMapping
    public List<UsuarioCursoDTO> listar() {
        return usuarioCursoService.listar();
    }

    @PostMapping
    public String almacenar(@RequestBody UsuarioCursoDTO dto) {
        return usuarioCursoService.almacenar(dto);
    }

    @PutMapping("/{id}")
    public String editar(@PathVariable int id, @RequestBody UsuarioCursoDTO dto) {
        return usuarioCursoService.editar(id, dto);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable int id) {
        return usuarioCursoService.eliminar(id);
    }
}
