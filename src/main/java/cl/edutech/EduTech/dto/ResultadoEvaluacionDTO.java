package cl.edutech.EduTech.dto;

import java.time.LocalDateTime;

public class ResultadoEvaluacionDTO {

    private int id;
    private double nota;
    private LocalDateTime fechaPrueba;
    private int intentos;
    private String comentarios;
    private int usuarioCursoId;
    private int pruebaId;

    public ResultadoEvaluacionDTO() {}

    public ResultadoEvaluacionDTO(int id, double nota, LocalDateTime fechaPrueba, int intentos, String comentarios, int usuarioCursoId, int pruebaId) {
        this.id = id;
        this.nota = nota;
        this.fechaPrueba = fechaPrueba;
        this.intentos = intentos;
        this.comentarios = comentarios;
        this.usuarioCursoId = usuarioCursoId;
        this.pruebaId = pruebaId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public LocalDateTime getFechaPrueba() {
        return fechaPrueba;
    }

    public void setFechaPrueba(LocalDateTime fechaPrueba) {
        this.fechaPrueba = fechaPrueba;
    }

    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public int getUsuarioCursoId() {
        return usuarioCursoId;
    }

    public void setUsuarioCursoId(int usuarioCursoId) {
        this.usuarioCursoId = usuarioCursoId;
    }

    public int getPruebaId() {
        return pruebaId;
    }

    public void setPruebaId(int pruebaId) {
        this.pruebaId = pruebaId;
    }

    
}
