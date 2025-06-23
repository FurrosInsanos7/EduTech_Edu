package cl.edutech.EduTech.dto;

import java.time.LocalDateTime;

public class ValoracionDTO {

    private int id;
    private int puntuacion;
    private LocalDateTime fechaValoracion;
    private int usuarioCursoId;

    public ValoracionDTO() {}

    public ValoracionDTO(int id, int puntuacion, LocalDateTime fechaValoracion, int usuarioCursoId) {
        this.id = id;
        this.puntuacion = puntuacion;
        this.fechaValoracion = fechaValoracion;
        this.usuarioCursoId = usuarioCursoId;
    }

    // Getters y setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getPuntuacion() {
        return puntuacion;
    }
    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public LocalDateTime getFechaValoracion() {
        return fechaValoracion;
    }
    public void setFechaValoracion(LocalDateTime fechaValoracion) {
        this.fechaValoracion = fechaValoracion;
    }

    public int getUsuarioCursoId() {
        return usuarioCursoId;
    }
    public void setUsuarioCursoId(int usuarioCursoId) {
        this.usuarioCursoId = usuarioCursoId;
    }
}
