package cl.edutech.EduTech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.edutech.EduTech.dto.PruebaDTO;
import cl.edutech.EduTech.service.PruebaService;

@RestController
@RequestMapping("/prueba")
public class PruebaController {

    @Autowired
    private PruebaService pruebaService;

    @GetMapping
    public List<PruebaDTO> listar() {
        return pruebaService.listar();
    }

    @PostMapping
    public String almacenar(@RequestBody PruebaDTO dto) {
        return pruebaService.almacenar(dto);
    }
}
