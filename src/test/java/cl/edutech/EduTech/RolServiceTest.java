// src/test/java/cl/edutech/EduTech/RolServiceTest.java
package cl.edutech.EduTech;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import cl.edutech.EduTech.dto.RolDTO;
import cl.edutech.EduTech.model.Rol;
import cl.edutech.EduTech.repository.RolRepository;
import cl.edutech.EduTech.service.RolService;

@ExtendWith(MockitoExtension.class)
public class RolServiceTest {

    @Mock private RolRepository rolRepo;
    @InjectMocks private RolService rolService;

    @Test
    void almacenarRol_Success() {
        RolDTO dto = new RolDTO();
        dto.setCodigo("ADMIN");
        dto.setNombre("Administrador");

        when(rolRepo.save(any(Rol.class))).thenAnswer(inv -> {
            Rol r = inv.getArgument(0);
            r.setId(1);  // simula autogeneración
            return r;
        });

        String res = rolService.almacenar(dto);
        assertEquals("Rol almacenado correctamente", res);
        verify(rolRepo).save(any(Rol.class));
    }

    @Test
    void listarRoles() {
        Rol r1 = new Rol(); r1.setId(1); r1.setCodigo("A"); r1.setNombre("One");
        Rol r2 = new Rol(); r2.setId(2); r2.setCodigo("B"); r2.setNombre("Two");

        when(rolRepo.findAll()).thenReturn(Arrays.asList(r1, r2));

        List<RolDTO> lista = rolService.listar();
        assertEquals(2, lista.size());
        assertEquals("A", lista.get(0).getCodigo());
        assertEquals("B", lista.get(1).getCodigo());
    }

    @Test
    void editarRol_NotExists() {
        when(rolRepo.existsById(5)).thenReturn(false);
        assertEquals("Rol no existe", rolService.editar(5, new RolDTO()));
    }

    @Test
    void editarRol_Success() {
        Rol existing = new Rol();
        existing.setId(1);
        existing.setCodigo("OLD");
        existing.setNombre("OldName");

        when(rolRepo.existsById(1)).thenReturn(true);
        when(rolRepo.findById(1)).thenReturn(Optional.of(existing));
        when(rolRepo.save(any(Rol.class))).thenAnswer(inv -> inv.getArgument(0));

        RolDTO dto = new RolDTO();
        dto.setCodigo("NEW");
        dto.setNombre("NewName");

        String res = rolService.editar(1, dto);
        assertEquals("Rol actualizado correctamente", res);
        verify(rolRepo).save(existing);
    }

    @Test
    void eliminarRol_NotExists() {
        when(rolRepo.existsById(3)).thenReturn(false);
        assertEquals("Rol no existe", rolService.eliminar(3));
    }

    @Test
    void eliminarRol_Success() {
        when(rolRepo.existsById(4)).thenReturn(true);

        String res = rolService.eliminar(4);
        assertEquals("Rol eliminado correctamente", res);
        verify(rolRepo).deleteById(4);
    }
}
