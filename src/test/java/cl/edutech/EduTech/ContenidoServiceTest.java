package cl.edutech.EduTech;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import cl.edutech.EduTech.dto.ContenidoDTO;
import cl.edutech.EduTech.model.Contenido;
import cl.edutech.EduTech.model.Curso;
import cl.edutech.EduTech.repository.ContenidoRepository;
import cl.edutech.EduTech.repository.CursoRepository;
import cl.edutech.EduTech.service.ContenidoService;

@ExtendWith(MockitoExtension.class)
public class ContenidoServiceTest {

    @Mock
    private ContenidoRepository contenidoRepo;

    @Mock
    private CursoRepository cursoRepo;

    @InjectMocks
    private ContenidoService service;

    @Test
    void almacenarContenido_CursoExiste() {
        ContenidoDTO dto = new ContenidoDTO();
        dto.setTitulo("Título 1");
        dto.setDescripcion("Descripción 1");
        dto.setTipo("Video");
        dto.setOrden(1);
        dto.setEstado(1);
        dto.setCursoId(100);

        when(cursoRepo.existsById(100)).thenReturn(true);
        Curso curso = new Curso();
        curso.setId(100);
        when(cursoRepo.findById(100)).thenReturn(Optional.of(curso));
        when(contenidoRepo.save(any(Contenido.class)))
            .thenAnswer(inv -> {
                Contenido c = inv.getArgument(0);
                c.setId(5);
                return c;
            });

        String res = service.almacenar(dto);
        assertEquals("Contenido almacenado correctamente", res);
        verify(contenidoRepo).save(any(Contenido.class));
    }

    @Test
    void almacenarContenido_CursoNoExiste() {
        ContenidoDTO dto = new ContenidoDTO();
        dto.setCursoId(200);

        when(cursoRepo.existsById(200)).thenReturn(false);

        String res = service.almacenar(dto);
        assertEquals("Curso no existe", res);
        verify(contenidoRepo, never()).save(any());
    }

    @Test
    void listarContenido_ConDatos() {
        Contenido c1 = new Contenido();
        c1.setId(1);
        c1.setTitulo("T1");
        c1.setDescripcion("D1");
        c1.setTipo("Pdf");
        c1.setOrden(2);
        c1.setEstado(1);
        Curso curso = new Curso();
        curso.setId(50);
        c1.setCurso(curso);

        Contenido c2 = new Contenido();
        c2.setId(2);
        c2.setTitulo("T2");
        c2.setDescripcion("D2");
        c2.setTipo("Video");
        c2.setOrden(3);
        c2.setEstado(0);
        Curso curso2 = new Curso();
        curso2.setId(60);
        c2.setCurso(curso2);

        when(contenidoRepo.findAll()).thenReturn(List.of(c1, c2));

        List<ContenidoDTO> list = service.listar();
        assertEquals(2, list.size());
        assertEquals("T1", list.get(0).getTitulo());
        assertEquals(50, list.get(0).getCursoId());
        assertEquals("T2", list.get(1).getTitulo());
        assertEquals(60, list.get(1).getCursoId());
    }

    @Test
    void editarContenido_Exito() {
        ContenidoDTO dto = new ContenidoDTO();
        dto.setTitulo("Nuevo T");
        dto.setDescripcion("Nueva D");
        dto.setTipo("Audio");
        dto.setOrden(5);
        dto.setEstado(0);
        dto.setCursoId(300);

        Contenido existing = new Contenido();
        existing.setId(7);

        when(contenidoRepo.existsById(7)).thenReturn(true);
        when(cursoRepo.existsById(300)).thenReturn(true);
        when(contenidoRepo.findById(7)).thenReturn(Optional.of(existing));
        when(cursoRepo.findById(300)).thenReturn(Optional.of(new Curso()));
        when(contenidoRepo.save(any(Contenido.class))).thenAnswer(inv -> inv.getArgument(0));

        String res = service.editar(7, dto);
        assertEquals("Contenido actualizado correctamente", res);
        verify(contenidoRepo).save(existing);
    }

    @Test
    void editar_ContenidoNoExiste() {
        when(contenidoRepo.existsById(8)).thenReturn(false);

        String res = service.editar(8, new ContenidoDTO());
        assertEquals("Contenido no existe", res);
        verify(contenidoRepo, never()).save(any());
    }

    @Test
    void editarContenido_CursoNoExiste() {
        ContenidoDTO dto = new ContenidoDTO();
        dto.setCursoId(400);

        when(contenidoRepo.existsById(9)).thenReturn(true);
        when(cursoRepo.existsById(400)).thenReturn(false);

        String res = service.editar(9, dto);
        assertEquals("Curso no existe", res);
        verify(contenidoRepo, never()).save(any());
    }

    @Test
    void eliminarContenido_Exito() {
        when(contenidoRepo.existsById(11)).thenReturn(true);

        String res = service.eliminar(11);
        assertEquals("Contenido eliminado correctamente", res);
        verify(contenidoRepo).deleteById(11);
    }

    @Test
    void eliminar_ContenidoNoExiste() {
        when(contenidoRepo.existsById(12)).thenReturn(false);

        String res = service.eliminar(12);
        assertEquals("Contenido no existe", res);
        verify(contenidoRepo, never()).deleteById(anyInt());
    }
}
