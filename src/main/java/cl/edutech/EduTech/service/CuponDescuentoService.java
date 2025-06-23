package cl.edutech.EduTech.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.edutech.EduTech.dto.CuponDescuentoDTO;
import cl.edutech.EduTech.model.CuponDescuento;
import cl.edutech.EduTech.model.UsuarioCurso;
import cl.edutech.EduTech.repository.CuponDescuentoRepository;
import cl.edutech.EduTech.repository.UsuarioCursoRepository;
//____________________________________________________________________________________
//SERVICE HECHO POR MACARENA MUÑOZ INCLUYENDO SUS DTO, CONTROLLER, MODEL Y REPOSITORY
//____________________________________________________________________________________
@Service
public class CuponDescuentoService {

    @Autowired
    private CuponDescuentoRepository cuponRepository;

    @Autowired
    private UsuarioCursoRepository usuarioCursoRepository;

    public String almacenar(CuponDescuentoDTO dto) {
        CuponDescuento cupon = new CuponDescuento();
        cupon.setCodigo(dto.getCodigo());
        cupon.setPorceDescuento(dto.getPorceDescuento());
        cupon.setFechaExpiracion(dto.getFechaExpiracion());
        cupon.setUsoMax(dto.getUsoMax());
        cupon.setUsoAct(dto.getUsoAct());
        cupon.setEstado(dto.getEstado());

        if (dto.getUsuarioCursoIds() != null) {
            List<UsuarioCurso> inscripciones = new ArrayList<>();
            for (Integer ucId : dto.getUsuarioCursoIds()) {
                usuarioCursoRepository.findById(ucId).ifPresent(inscripciones::add);
            }
            cupon.setInscripcionesConEsteCupon(inscripciones);
        }

        cuponRepository.save(cupon);
        return "CuponDescuento almacenado correctamente";
    }

    public List<CuponDescuentoDTO> listar() {
        List<CuponDescuento> cupones = cuponRepository.findAll();
        List<CuponDescuentoDTO> dtos = new ArrayList<>();

        for (CuponDescuento c : cupones) {
            CuponDescuentoDTO dto = new CuponDescuentoDTO();
            dto.setId(c.getId());
            dto.setCodigo(c.getCodigo());
            dto.setPorceDescuento(c.getPorceDescuento());
            dto.setFechaExpiracion(c.getFechaExpiracion());
            dto.setUsoMax(c.getUsoMax());
            dto.setUsoAct(c.getUsoAct());
            dto.setEstado(c.getEstado());

            List<Integer> ucIds = new ArrayList<>();
            if (c.getInscripcionesConEsteCupon() != null) {
                for (UsuarioCurso uc : c.getInscripcionesConEsteCupon()) {
                    ucIds.add(uc.getId());
                }
            }
            dto.setUsuarioCursoIds(ucIds);

            dtos.add(dto);
        }
        return dtos;
    }
}
