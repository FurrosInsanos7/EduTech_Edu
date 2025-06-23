package cl.edutech.EduTech.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
//____________________________________________________________________________________
//MODEL HECHO POR EDUARDO URBINA INCLUYENDO SUS DTO, CONTROLLER, SERVICE Y REPOSITORY
//____________________________________________________________________________________
@Entity
public class ResultadoEvaluacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double nota;
    private LocalDateTime fechaPrueba;
    private int intentos;
    private String comentarios;

    @ManyToOne
    @JoinColumn(name = "usuario_curso_id", nullable = false)
    @JsonBackReference
    private UsuarioCurso usuarioCurso;

    @ManyToOne
    @JoinColumn(name = "prueba_id", nullable = false)
    @JsonBackReference
    private Prueba prueba;

    public ResultadoEvaluacion(){
        this.id=0;
        this.nota=0;
        this.fechaPrueba=null;
        this.intentos=0;
        this.comentarios="";
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

    public UsuarioCurso getUsuarioCurso() {
        return usuarioCurso;
    }

    public void setUsuarioCurso(UsuarioCurso usuarioCurso) {
        this.usuarioCurso = usuarioCurso;
    }

    public Prueba getPrueba() {
        return prueba;
    }

    public void setPrueba(Prueba prueba) {
        this.prueba = prueba;
    }

    
}
