package cl.edutech.EduTech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.edutech.EduTech.dto.MetodoPagoDTO;
import cl.edutech.EduTech.service.MetodoPagoService;

@RestController
@RequestMapping("/metodopago")
public class MetodoPagoController {

    @Autowired
    private MetodoPagoService metodoPagoService;

    @GetMapping
    public List<MetodoPagoDTO> listar() {
        return metodoPagoService.listar();
    }

    @PostMapping
    public String almacenar(@RequestBody MetodoPagoDTO dto) {
        return metodoPagoService.almacenar(dto);
    }
}
