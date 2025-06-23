package cl.edutech.EduTech.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.edutech.EduTech.dto.ResultadoEvaluacionDTO;
import cl.edutech.EduTech.model.Prueba;
import cl.edutech.EduTech.model.ResultadoEvaluacion;
import cl.edutech.EduTech.model.UsuarioCurso;
import cl.edutech.EduTech.repository.PruebaRepository;
import cl.edutech.EduTech.repository.ResultadoEvaluacionRepository;
import cl.edutech.EduTech.repository.UsuarioCursoRepository;
//____________________________________________________________________________________
//SERVICE HECHO POR EDUARDO URBINA INCLUYENDO SUS DTO, CONTROLLER, MODEL Y REPOSITORY
//____________________________________________________________________________________
@Service
public class ResultadoEvaluacionService {

    @Autowired
    private ResultadoEvaluacionRepository resultadoEvaluacionRepository;

    @Autowired
    private UsuarioCursoRepository usuarioCursoRepository;

    @Autowired
    private PruebaRepository pruebaRepository;

    public String almacenar(ResultadoEvaluacionDTO dto) {
        UsuarioCurso uc = usuarioCursoRepository.findById(dto.getUsuarioCursoId()).orElse(null);
        if (uc == null) {
            return "UsuarioCurso no existe";
        }

        Prueba prueba = pruebaRepository.findById(dto.getPruebaId()).orElse(null);
        if (prueba == null) {
            return "Prueba no existe";
        }

        ResultadoEvaluacion resultado = new ResultadoEvaluacion();
        resultado.setNota(dto.getNota());
        resultado.setFechaPrueba(dto.getFechaPrueba());
        resultado.setIntentos(dto.getIntentos());
        resultado.setComentarios(dto.getComentarios());
        resultado.setUsuarioCurso(uc);
        resultado.setPrueba(prueba);

        resultadoEvaluacionRepository.save(resultado);
        return "ResultadoEvaluacion almacenado correctamente";
    }

    public List<ResultadoEvaluacionDTO> listar() {
        List<ResultadoEvaluacion> resultados = resultadoEvaluacionRepository.findAll();
        List<ResultadoEvaluacionDTO> dtos = new ArrayList<>();

        for (ResultadoEvaluacion r : resultados) {
            ResultadoEvaluacionDTO dto = new ResultadoEvaluacionDTO();
            dto.setId(r.getId());
            dto.setNota(r.getNota());
            dto.setFechaPrueba(r.getFechaPrueba());
            dto.setIntentos(r.getIntentos());
            dto.setComentarios(r.getComentarios());
            dto.setUsuarioCursoId(r.getUsuarioCurso().getId());
            dto.setPruebaId(r.getPrueba().getId());
            dtos.add(dto);
        }

        return dtos;
    }
}
