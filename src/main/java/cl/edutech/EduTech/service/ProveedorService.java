package cl.edutech.EduTech.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.edutech.EduTech.dto.ProveedorDTO;
import cl.edutech.EduTech.model.Proveedor;
import cl.edutech.EduTech.repository.ProveedorRepository;
//____________________________________________________________________________________
//SERVICE HECHO POR MACARENA MUÑOZ INCLUYENDO SUS DTO, CONTROLLER, MODEL Y REPOSITORY
//____________________________________________________________________________________
@Service
public class ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    public String almacenar(ProveedorDTO dto) {
        Proveedor proveedor = new Proveedor();
        proveedor.setRut(dto.getRut());
        proveedor.setNombre(dto.getNombre());
        proveedor.setDescripcion(dto.getDescripcion());
        proveedor.setCorreo(dto.getCorreo());
        proveedor.setTelefono(dto.getTelefono());

        proveedorRepository.save(proveedor);
        return "Proveedor almacenado correctamente";
    }

    public List<ProveedorDTO> listar() {
        List<Proveedor> proveedores = proveedorRepository.findAll();
        List<ProveedorDTO> dtos = new ArrayList<>();

        for (Proveedor p : proveedores) {
            ProveedorDTO dto = new ProveedorDTO();
            dto.setId(p.getId());
            dto.setRut(p.getRut());
            dto.setNombre(p.getNombre());
            dto.setDescripcion(p.getDescripcion());
            dto.setCorreo(p.getCorreo());
            dto.setTelefono(p.getTelefono());
            dtos.add(dto);
        }

        return dtos;
    }
}
