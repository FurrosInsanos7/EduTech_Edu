package cl.edutech.EduTech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.edutech.EduTech.dto.ResultadoEvaluacionDTO;
import cl.edutech.EduTech.service.ResultadoEvaluacionService;

@RestController
@RequestMapping("/resultadoevaluacion")
public class ResultadoEvaluacionController {

    @Autowired
    private ResultadoEvaluacionService resultadoEvaluacionService;

    @GetMapping
    public List<ResultadoEvaluacionDTO> listar() {
        return resultadoEvaluacionService.listar();
    }

    @PostMapping
    public String almacenar(@RequestBody ResultadoEvaluacionDTO dto) {
        return resultadoEvaluacionService.almacenar(dto);
    }
}
