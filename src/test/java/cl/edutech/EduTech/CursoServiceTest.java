package cl.edutech.EduTech;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import cl.edutech.EduTech.dto.CursoDTO;
import cl.edutech.EduTech.model.Curso;
import cl.edutech.EduTech.model.Instructor;
import cl.edutech.EduTech.repository.CursoRepository;
import cl.edutech.EduTech.repository.InstructorRepository;
import cl.edutech.EduTech.service.CursoService;

@ExtendWith(MockitoExtension.class)
public class CursoServiceTest {

    @Mock private CursoRepository cursoRepo;
    @Mock private InstructorRepository instructorRepo;
    @InjectMocks private CursoService service;

    @Test
    void almacenarCurso_SinInstructores() {
        CursoDTO dto = new CursoDTO();
        dto.setNombre("Java");
        dto.setCategoria("Desarrollo");
        dto.setNivel("Intermedio");

        when(cursoRepo.save(any(Curso.class)))
            .thenAnswer(inv -> { ((Curso)inv.getArgument(0)).setId(1); return inv.getArgument(0); });

        String res = service.almacenar(dto);
        assertEquals("Curso almacenado correctamente", res);
        verify(cursoRepo).save(any(Curso.class));
    }

    @Test
    void almacenarCurso_ConInstructores() {
        CursoDTO dto = new CursoDTO();
        dto.setNombre("Spring");
        dto.setCategoria("Backend");
        dto.setNivel("Avanzado");
        dto.setInstructorRuts(List.of("11111111-1", "22222222-2"));

        Instructor i1 = new Instructor(); i1.setRut("11111111-1");
        Instructor i2 = new Instructor(); i2.setRut("22222222-2");

        when(instructorRepo.findById("11111111-1")).thenReturn(Optional.of(i1));
        when(instructorRepo.findById("22222222-2")).thenReturn(Optional.of(i2));
        when(cursoRepo.save(any(Curso.class))).thenAnswer(inv -> inv.getArgument(0));

        String res = service.almacenar(dto);
        assertEquals("Curso almacenado correctamente", res);
        verify(cursoRepo).save(any(Curso.class));
    }

    @Test
    void listarCursos() {
        Curso c1 = new Curso(); c1.setId(1); c1.setNombre("C1"); c1.setCategoria("A"); c1.setNivel("B");
        Curso c2 = new Curso(); c2.setId(2); c2.setNombre("C2"); c2.setCategoria("X"); c2.setNivel("Y");
        when(cursoRepo.findAll()).thenReturn(List.of(c1, c2));

        var list = service.listar();
        assertEquals(2, list.size());
        assertEquals("C1", list.get(0).getNombre());
    }

    @Test
    void editarCurso_NoExiste() {
        when(cursoRepo.existsById(5)).thenReturn(false);
        assertEquals("Curso no existe", service.editar(5, new CursoDTO()));
    }

    @Test
    void editarCurso_Existente() {
        Curso existing = new Curso();
        existing.setId(1);

        when(cursoRepo.existsById(1)).thenReturn(true);
        when(cursoRepo.findById(1)).thenReturn(Optional.of(existing));
        when(cursoRepo.save(any(Curso.class))).thenAnswer(inv -> inv.getArgument(0));

        CursoDTO dto = new CursoDTO();
        dto.setNombre("Nuevo");
        dto.setCategoria("Cat");
        dto.setNivel("Nivel");
        dto.setInstructorRuts(Collections.emptyList());  // sin instructores, así no se llama a instructorRepo

        String res = service.editar(1, dto);
        assertEquals("Curso actualizado correctamente", res);
        verify(cursoRepo).save(existing);
    }

    @Test
    void eliminarCurso_NoExiste() {
        when(cursoRepo.existsById(3)).thenReturn(false);
        assertEquals("Curso no existe", service.eliminar(3));
    }

    @Test
    void eliminarCurso_Existente() {
        when(cursoRepo.existsById(4)).thenReturn(true);
        String res = service.eliminar(4);
        assertEquals("Curso eliminado correctamente", res);
        verify(cursoRepo).deleteById(4);
    }
}
