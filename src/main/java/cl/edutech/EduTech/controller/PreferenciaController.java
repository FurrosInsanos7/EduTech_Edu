package cl.edutech.EduTech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.edutech.EduTech.dto.PreferenciaDTO;
import cl.edutech.EduTech.service.PreferenciaService;

@RestController
@RequestMapping("/preferencia")
public class PreferenciaController {

    @Autowired
    private PreferenciaService preferenciaService;

    @GetMapping
    public List<PreferenciaDTO> listar() {
        return preferenciaService.listar();
    }

    @PostMapping
    public String almacenar(@RequestBody PreferenciaDTO dto) {
        return preferenciaService.almacenar(dto);
    }
}
