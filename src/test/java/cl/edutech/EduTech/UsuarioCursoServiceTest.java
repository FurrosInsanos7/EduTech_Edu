package cl.edutech.EduTech;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.util.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import cl.edutech.EduTech.dto.UsuarioCursoDTO;
import cl.edutech.EduTech.model.CuponDescuento;
import cl.edutech.EduTech.model.Curso;
import cl.edutech.EduTech.model.Usuario;
import cl.edutech.EduTech.model.UsuarioCurso;
import cl.edutech.EduTech.repository.*;
import cl.edutech.EduTech.service.UsuarioCursoService;

@ExtendWith(MockitoExtension.class)
public class UsuarioCursoServiceTest {

    @Mock UsuarioCursoRepository usuCurRepo;
    @Mock UsuarioRepository usuRepo;
    @Mock CursoRepository curRepo;
    @Mock CuponDescuentoRepository cupRepo;
    @InjectMocks UsuarioCursoService service;

    @Test
    void cupónNoExiste() {
        var dto = new UsuarioCursoDTO();
        dto.setUsuarioCorreo("u@mail.com"); dto.setCursoId(1);
        dto.setFechaInscripcion(LocalDateTime.now()); dto.setProgreso(0);
        dto.setCuponId(5);

        when(usuRepo.findById("u@mail.com")).thenReturn(Optional.of(new Usuario()));
        when(curRepo.findById(1)).thenReturn(Optional.of(new Curso()));
        when(cupRepo.findById(5)).thenReturn(Optional.empty());

        assertEquals("Cupon no existe", service.almacenar(dto));
    }

    @Test
    void cupónExpirado() {
        var dto = new UsuarioCursoDTO();
        dto.setUsuarioCorreo("u@mail.com"); dto.setCursoId(1);
        dto.setFechaInscripcion(LocalDateTime.now()); dto.setProgreso(0);
        dto.setCuponId(5);

        var cup = new CuponDescuento();
        cup.setId(5); cup.setFechaExpiracion(LocalDateTime.now().minusDays(1));
        cup.setUsoAct(0); cup.setUsoMax(1);

        when(usuRepo.findById("u@mail.com")).thenReturn(Optional.of(new Usuario()));
        when(curRepo.findById(1)).thenReturn(Optional.of(new Curso()));
        when(cupRepo.findById(5)).thenReturn(Optional.of(cup));

        assertEquals("Cupon expirado", service.almacenar(dto));
    }

    @Test
    void cupónAgotado() {
        var dto = new UsuarioCursoDTO();
        dto.setUsuarioCorreo("u@mail.com"); dto.setCursoId(1);
        dto.setFechaInscripcion(LocalDateTime.now()); dto.setProgreso(0);
        dto.setCuponId(5);

        var cup = new CuponDescuento();
        cup.setId(5); cup.setFechaExpiracion(LocalDateTime.now().plusDays(1));
        cup.setUsoAct(1); cup.setUsoMax(1);

        when(usuRepo.findById("u@mail.com")).thenReturn(Optional.of(new Usuario()));
        when(curRepo.findById(1)).thenReturn(Optional.of(new Curso()));
        when(cupRepo.findById(5)).thenReturn(Optional.of(cup));

        assertEquals("Cupon agotado", service.almacenar(dto));
    }

    @Test
    void almacenarConCupónValido() {
        var dto = new UsuarioCursoDTO();
        dto.setUsuarioCorreo("u@mail.com"); dto.setCursoId(1);
        dto.setFechaInscripcion(LocalDateTime.now()); dto.setProgreso(0);
        dto.setCuponId(5);

        var u = new Usuario(); u.setCorreo("u@mail.com");
        var c = new Curso();   c.setId(1);
        var cup = new CuponDescuento();
        cup.setId(5); cup.setFechaExpiracion(LocalDateTime.now().plusDays(1));
        cup.setUsoAct(0); cup.setUsoMax(1);

        when(usuRepo.findById("u@mail.com")).thenReturn(Optional.of(u));
        when(curRepo.findById(1)).thenReturn(Optional.of(c));
        when(cupRepo.findById(5)).thenReturn(Optional.of(cup));
        when(usuCurRepo.save(any(UsuarioCurso.class))).thenAnswer(i -> i.getArgument(0));

        String res = service.almacenar(dto);
        assertEquals("UsuarioCurso almacenado correctamente", res);
        // el usoAct debió incrementarse
        assertEquals(1, cup.getUsoAct());
        verify(cupRepo).save(cup);
    }
}
