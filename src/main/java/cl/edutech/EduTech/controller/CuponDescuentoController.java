package cl.edutech.EduTech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.edutech.EduTech.dto.CuponDescuentoDTO;

import cl.edutech.EduTech.service.CuponDescuentoService;

@RestController
@RequestMapping("/cupon")
public class CuponDescuentoController {

    @Autowired
    private CuponDescuentoService cuponService;

    @GetMapping
    public List<CuponDescuentoDTO> listar() {
        return cuponService.listar();
    }

    @PostMapping
    public String almacenar(@RequestBody CuponDescuentoDTO dto) {
        return cuponService.almacenar(dto);
    }
}
