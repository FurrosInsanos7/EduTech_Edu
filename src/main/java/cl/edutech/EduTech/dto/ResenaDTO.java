package cl.edutech.EduTech.dto;

import java.time.LocalDateTime;

public class ResenaDTO {

    private int id;
    private String comentario;
    private LocalDateTime fechaResena;
    private int usuarioCursoId;

    public ResenaDTO() {}

    public ResenaDTO(int id, String comentario, LocalDateTime fechaResena, int usuarioCursoId) {
        this.id = id;
        this.comentario = comentario;
        this.fechaResena = fechaResena;
        this.usuarioCursoId = usuarioCursoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDateTime getFechaResena() {
        return fechaResena;
    }

    public void setFechaResena(LocalDateTime fechaResena) {
        this.fechaResena = fechaResena;
    }

    public int getUsuarioCursoId() {
        return usuarioCursoId;
    }

    public void setUsuarioCursoId(int usuarioCursoId) {
        this.usuarioCursoId = usuarioCursoId;
    }

}
