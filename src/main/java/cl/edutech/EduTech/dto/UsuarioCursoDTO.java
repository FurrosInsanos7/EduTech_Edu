package cl.edutech.EduTech.dto;

import java.time.LocalDateTime;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UsuarioCursoDTO {
    private int id;

    @NotBlank(message = "El correo de usuario es obligatorio")
    private String usuarioCorreo;

    @NotNull(message = "El ID de curso es obligatorio")
    private Integer cursoId;

    @NotNull(message = "La fecha de inscripción es obligatoria")
    private LocalDateTime fechaInscripcion;

    @Min(value = 0, message = "El progreso debe ser al menos 0")
    private int progreso;

    private LocalDateTime fechaFinalizado;

    private Integer cuponId;    

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuarioCorreo() {
        return usuarioCorreo;
    }

    public void setUsuarioCorreo(String usuarioCorreo) {
        this.usuarioCorreo = usuarioCorreo;
    }

    public Integer getCursoId() {
        return cursoId;
    }

    public void setCursoId(Integer cursoId) {
        this.cursoId = cursoId;
    }

    public LocalDateTime getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(LocalDateTime fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public int getProgreso() {
        return progreso;
    }

    public void setProgreso(int progreso) {
        this.progreso = progreso;
    }

    public LocalDateTime getFechaFinalizado() {
        return fechaFinalizado;
    }

    public void setFechaFinalizado(LocalDateTime fechaFinalizado) {
        this.fechaFinalizado = fechaFinalizado;
    }

    public Integer getCuponId() {
        return cuponId;
    }

    public void setCuponId(Integer cuponId) {
        this.cuponId = cuponId;
    }
}
