package cl.edutech.EduTech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.edutech.EduTech.dto.RespuestaDTO;
import cl.edutech.EduTech.service.RespuestaService;

@RestController
@RequestMapping("/respuesta")
public class RespuestaController {

    @Autowired
    private RespuestaService respuestaService;

    @GetMapping
    public List<RespuestaDTO> listar() {
        return respuestaService.listar();
    }

    @PostMapping
    public String almacenar(@RequestBody RespuestaDTO dto) {
        return respuestaService.almacenar(dto);
    }
}