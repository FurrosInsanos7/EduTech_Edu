// src/main/java/cl/edutech/EduTech/controller/CursoController.java
package cl.edutech.EduTech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cl.edutech.EduTech.dto.CursoDTO;
import cl.edutech.EduTech.service.CursoService;

@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public List<CursoDTO> listar() {
        return cursoService.listar();
    }

    @PostMapping
    public String almacenar(@RequestBody CursoDTO dto) {
        return cursoService.almacenar(dto);
    }

    @PutMapping("/{id}")
    public String editar(@PathVariable int id, @RequestBody CursoDTO dto) {
        return cursoService.editar(id, dto);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable int id) {
        return cursoService.eliminar(id);
    }
}
