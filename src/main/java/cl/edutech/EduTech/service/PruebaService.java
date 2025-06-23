package cl.edutech.EduTech.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.edutech.EduTech.dto.PruebaDTO;
import cl.edutech.EduTech.model.Curso;
import cl.edutech.EduTech.model.Prueba;
import cl.edutech.EduTech.model.ResultadoEvaluacion;
import cl.edutech.EduTech.repository.CursoRepository;
import cl.edutech.EduTech.repository.PruebaRepository;
import cl.edutech.EduTech.repository.ResultadoEvaluacionRepository;
//____________________________________________________________________________________
//SERVICE HECHO POR EDUARDO URBINA INCLUYENDO SUS DTO, CONTROLLER, MODEL Y REPOSITORY
//____________________________________________________________________________________
@Service
public class PruebaService {

    @Autowired
    private PruebaRepository pruebaRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private ResultadoEvaluacionRepository resultadoEvaluacionRepository;

    public String almacenar(PruebaDTO dto) {
        Curso curso = cursoRepository.findById(dto.getCursoId()).orElse(null);
        if (curso == null) {
            return "Curso no existe";
        }

        Prueba prueba = new Prueba();
        prueba.setNombre(dto.getNombre());
        prueba.setDescripcion(dto.getDescripcion());
        prueba.setTipoPrueba(dto.getTipoPrueba());
        prueba.setCurso(curso);

        if (dto.getResultadoEvaluacionIds() != null) {
            List<ResultadoEvaluacion> resultados = new ArrayList<>();
            for (Integer idRes : dto.getResultadoEvaluacionIds()) {
                resultadoEvaluacionRepository.findById(idRes).ifPresent(resultados::add);
            }
            prueba.setResultadosEvaluacion(resultados);
        }

        pruebaRepository.save(prueba);
        return "Prueba almacenada correctamente";
    }

    public List<PruebaDTO> listar() {
        List<Prueba> pruebas = pruebaRepository.findAll();
        List<PruebaDTO> dtos = new ArrayList<>();

        for (Prueba p : pruebas) {
            PruebaDTO dto = new PruebaDTO();
            dto.setId(p.getId());
            dto.setNombre(p.getNombre());
            dto.setDescripcion(p.getDescripcion());
            dto.setTipoPrueba(p.getTipoPrueba());
            dto.setCursoId(p.getCurso().getId());

            List<Integer> resIds = new ArrayList<>();
            if (p.getResultadosEvaluacion() != null) {
                for (ResultadoEvaluacion r : p.getResultadosEvaluacion()) {
                    resIds.add(r.getId());
                }
            }
            dto.setResultadoEvaluacionIds(resIds);

            dtos.add(dto);
        }
        return dtos;
    }
}
