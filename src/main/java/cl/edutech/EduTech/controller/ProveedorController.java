package cl.edutech.EduTech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cl.edutech.EduTech.dto.ProveedorDTO;
import cl.edutech.EduTech.service.ProveedorService;



@RestController
@RequestMapping("/proveedor")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping
    public List<ProveedorDTO> listar() {
        return proveedorService.listar();
    }

    @PostMapping
    public String almacenar(@RequestBody ProveedorDTO dto) {
        return proveedorService.almacenar(dto);
    }
}
