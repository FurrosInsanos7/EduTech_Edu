package cl.edutech.EduTech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.edutech.EduTech.dto.ValoracionDTO;
import cl.edutech.EduTech.service.ValoracionService;

@RestController
@RequestMapping("/valoracion")
public class ValoracionController {

    @Autowired
    private ValoracionService valoracionService;

    @GetMapping
    public List<ValoracionDTO> listar() {
        return valoracionService.listar();
    }

    @PostMapping
    public String almacenar(@RequestBody ValoracionDTO dto) {
        return valoracionService.almacenar(dto);
    }
}
