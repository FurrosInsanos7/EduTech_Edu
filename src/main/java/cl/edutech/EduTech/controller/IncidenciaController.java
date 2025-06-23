package cl.edutech.EduTech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.edutech.EduTech.dto.IncidenciaDTO;
import cl.edutech.EduTech.service.IncidenciaService;

@RestController
@RequestMapping("/incidencia")
public class IncidenciaController {

    @Autowired
    private IncidenciaService incidenciaService;

    @GetMapping
    public List<IncidenciaDTO> listar() {
        return incidenciaService.listar();
    }

    @PostMapping
    public String almacenar(@RequestBody IncidenciaDTO dto) {
        return incidenciaService.almacenar(dto);
    }
}
