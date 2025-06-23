package cl.edutech.EduTech.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.edutech.EduTech.dto.MetodoPagoDTO;
import cl.edutech.EduTech.model.MetodoPago;
import cl.edutech.EduTech.model.Tarjeta;
import cl.edutech.EduTech.repository.MetodoPagoRepository;
import cl.edutech.EduTech.repository.TarjetaRepository;
//____________________________________________________________________________________
//SERVICE HECHO POR MACARENA MUÑOZ INCLUYENDO SUS DTO, CONTROLLER, MODEL Y REPOSITORY
//____________________________________________________________________________________
@Service
public class MetodoPagoService {

    @Autowired
    private MetodoPagoRepository metodoPagoRepository;

    @Autowired
    private TarjetaRepository tarjetaRepository;

    public String almacenar(MetodoPagoDTO dto) {
        MetodoPago mp = new MetodoPago();
        mp.setNombre(dto.getNombre());
        mp.setCodigo(dto.getCodigo());

        if (dto.getTarjetaIds() != null) {
            List<Tarjeta> list = new ArrayList<>();
            for (Integer tid : dto.getTarjetaIds()) {
                tarjetaRepository.findById(tid).ifPresent(list::add);
            }
            mp.setTarjetas(list);
        }

        metodoPagoRepository.save(mp);
        return "Método de pago almacenado correctamente";
    }

    public List<MetodoPagoDTO> listar() {
        List<MetodoPago> mps = metodoPagoRepository.findAll();
        List<MetodoPagoDTO> dtos = new ArrayList<>();

        for (MetodoPago mp : mps) {
            MetodoPagoDTO dto = new MetodoPagoDTO();
            dto.setId(mp.getId());
            dto.setNombre(mp.getNombre());
            dto.setCodigo(mp.getCodigo());

            List<Integer> tids = new ArrayList<>();
            if (mp.getTarjetas() != null) {
                for (Tarjeta t : mp.getTarjetas()) {
                    tids.add(t.getId());
                }
            }
            dto.setTarjetaIds(tids);

            dtos.add(dto);
        }

        return dtos;
    }
}
