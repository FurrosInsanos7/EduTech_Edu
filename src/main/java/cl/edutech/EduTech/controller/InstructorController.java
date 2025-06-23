package cl.edutech.EduTech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.edutech.EduTech.dto.InstructorDTO;
import cl.edutech.EduTech.service.InstructorService;

@RestController
@RequestMapping("/instructor")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    @GetMapping
    public List<InstructorDTO> listar() {
        return instructorService.listar();
    }

    @PostMapping
    public String almacenar(@RequestBody InstructorDTO dto) {
        return instructorService.almacenar(dto);
    }
}
