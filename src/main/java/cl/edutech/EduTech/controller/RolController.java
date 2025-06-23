// src/main/java/cl/edutech/EduTech/controller/RolController.java
package cl.edutech.EduTech.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cl.edutech.EduTech.dto.RolDTO;
import cl.edutech.EduTech.service.RolService;

@RestController
@RequestMapping("/rol")
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping
    public List<RolDTO> listar() {
        return rolService.listar();
    }

    @PostMapping
    public String almacenar(@RequestBody RolDTO dto) {
        return rolService.almacenar(dto);
    }

    @PutMapping("/{id}")
    public String editar(@PathVariable int id, @RequestBody RolDTO dto) {
        return rolService.editar(id, dto);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable int id) {
        return rolService.eliminar(id);
    }
}
