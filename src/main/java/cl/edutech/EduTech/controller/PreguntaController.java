package cl.edutech.EduTech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.edutech.EduTech.dto.PreguntaDTO;
import cl.edutech.EduTech.service.PreguntaService;

@RestController
@RequestMapping("/pregunta")
public class PreguntaController {

    @Autowired
    private PreguntaService preguntaService;

    @GetMapping
    public List<PreguntaDTO> listar() {
        return preguntaService.listar();
    }

    @PostMapping
    public String almacenar(@RequestBody PreguntaDTO dto) {
        return preguntaService.almacenar(dto);
    }
}
