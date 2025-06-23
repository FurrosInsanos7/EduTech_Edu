// src/main/java/cl/edutech/EduTech/service/RolService.java
package cl.edutech.EduTech.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.edutech.EduTech.dto.RolDTO;
import cl.edutech.EduTech.model.Rol;
import cl.edutech.EduTech.repository.RolRepository;

@Service
public class RolService {

    @Autowired
    private RolRepository rolRepo;

    public String almacenar(RolDTO dto) {
        // siempre creamos un nuevo Rol (id autogenerado)
        Rol rol = new Rol();
        rol.setCodigo(dto.getCodigo());
        rol.setNombre(dto.getNombre());
        rolRepo.save(rol);
        return "Rol almacenado correctamente";
    }

    public List<RolDTO> listar() {
        List<RolDTO> dtos = new ArrayList<>();
        for (Rol rol : rolRepo.findAll()) {
            RolDTO dto = new RolDTO();
            dto.setId(rol.getId());
            dto.setCodigo(rol.getCodigo());
            dto.setNombre(rol.getNombre());
            dtos.add(dto);
        }
        return dtos;
    }

    public String editar(int id, RolDTO dto) {
        if (!rolRepo.existsById(id)) {
            return "Rol no existe";
        }
        // usa findById para cargar la entidad, existsById ya garantizó su existencia
        Rol rol = rolRepo.findById(id).get();
        rol.setCodigo(dto.getCodigo());
        rol.setNombre(dto.getNombre());
        rolRepo.save(rol);
        return "Rol actualizado correctamente";
    }

    public String eliminar(int id) {
        if (!rolRepo.existsById(id)) {
            return "Rol no existe";
        }
        rolRepo.deleteById(id);
        return "Rol eliminado correctamente";
    }
}
