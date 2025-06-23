package cl.edutech.EduTech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.edutech.EduTech.dto.ContenidoDTO;
import cl.edutech.EduTech.service.ContenidoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/contenido")
public class ContenidoController {

    @Autowired
    private ContenidoService contenidoService;

    @GetMapping
    public List<ContenidoDTO> listar() {
        return contenidoService.listar();
    }

    @PostMapping
    public String almacenar(@RequestBody ContenidoDTO dto) {
        return contenidoService.almacenar(dto);
    }

    @PutMapping("/{id}")
    public String editar(@PathVariable int id, @RequestBody ContenidoDTO dto) {
        return contenidoService.editar(id, dto);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable int id) {
        return contenidoService.eliminar(id);
    }
}
    


