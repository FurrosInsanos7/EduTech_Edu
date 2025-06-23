package cl.edutech.EduTech.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.edutech.EduTech.dto.TarjetaDTO;
import cl.edutech.EduTech.model.MetodoPago;
import cl.edutech.EduTech.model.Tarjeta;
import cl.edutech.EduTech.model.Usuario;
import cl.edutech.EduTech.repository.MetodoPagoRepository;
import cl.edutech.EduTech.repository.TarjetaRepository;
import cl.edutech.EduTech.repository.UsuarioRepository;
//____________________________________________________________________________________
//SERVICE HECHO POR EDUARDO URBINA INCLUYENDO SUS DTO, CONTROLLER, MODEL Y REPOSITORY
//____________________________________________________________________________________
@Service
public class TarjetaService {

    @Autowired
    private TarjetaRepository tarjetaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private MetodoPagoRepository metodoPagoRepository;

    public String almacenar(TarjetaDTO dto) {
        Usuario usuario = usuarioRepository.findById(dto.getUsuarioCorreo()).orElse(null);
        if (usuario == null) {
            return "Usuario no existe";
        }

        MetodoPago mp = metodoPagoRepository.findById(dto.getMetodoPagoId()).orElse(null);
        if (mp == null) {
            return "MetodoPago no existe";
        }

        Tarjeta tarjeta = new Tarjeta();
        tarjeta.setNumTarjeta(dto.getNumTarjeta());
        tarjeta.setNombreTitular(dto.getNombreTitular());
        tarjeta.setUsuario(usuario);
        tarjeta.setFormaPago(mp);

        tarjetaRepository.save(tarjeta);
        return "Tarjeta almacenada correctamente";
    }

    public List<TarjetaDTO> listar() {
        List<Tarjeta> tarjetas = tarjetaRepository.findAll();
        List<TarjetaDTO> dtos = new ArrayList<>();

        for (Tarjeta t : tarjetas) {
            TarjetaDTO dto = new TarjetaDTO();
            dto.setId(t.getId());
            dto.setNumTarjeta(t.getNumTarjeta());
            dto.setNombreTitular(t.getNombreTitular());
            dto.setUsuarioCorreo(t.getUsuario().getCorreo());
            dto.setMetodoPagoId(t.getFormaPago().getId());
            dtos.add(dto);
        }

        return dtos;
    }
}