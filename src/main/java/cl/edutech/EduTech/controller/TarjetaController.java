package cl.edutech.EduTech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cl.edutech.EduTech.dto.TarjetaDTO;
import cl.edutech.EduTech.service.TarjetaService;

@RestController
@RequestMapping("/tarjeta")
public class TarjetaController {

    @Autowired
    private TarjetaService tarjetaService;

    @GetMapping
    public List<TarjetaDTO> listar() {
        return tarjetaService.listar();
    }

    @PostMapping
    public String almacenar(@RequestBody TarjetaDTO dto) {
        return tarjetaService.almacenar(dto);
    }
}
