package cl.edutech.EduTech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cl.edutech.EduTech.dto.ResenaDTO;
import cl.edutech.EduTech.service.ResenaService;


@RestController
@RequestMapping("/resena")
public class ResenaController {

    @Autowired
    private ResenaService resenaService;

    @GetMapping
    public List<ResenaDTO> listar() {
        return resenaService.listar();
    }

    @PostMapping
    public String almacenar(@RequestBody ResenaDTO dto) {
        return resenaService.almacenar(dto);
    }
}
