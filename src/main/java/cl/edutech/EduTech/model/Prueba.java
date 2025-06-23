package cl.edutech.EduTech.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
//____________________________________________________________________________________
//MODEL HECHO POR EDUARDO URBINA INCLUYENDO SUS DTO, CONTROLLER, SERVICE Y REPOSITORY
//____________________________________________________________________________________
@Entity
public class Prueba {               //Prueba = Evaluacion
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String descripcion;
    private String tipoPrueba;//"QUIZ", "TAREA", "EXAMEN_FINAL"
    
    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    @JsonBackReference
    private Curso curso;

    @OneToMany(mappedBy = "prueba")
    @JsonManagedReference
    private List<ResultadoEvaluacion> resultadosEvaluacion;
    
    public Prueba(){
        this.id=0;
        this.nombre="";
        this.descripcion="";
        this.tipoPrueba="";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

     public String getTipoPrueba() {
        return tipoPrueba;
    }

    public void setTipoPrueba(String tipoPrueba) {
        this.tipoPrueba = tipoPrueba;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<ResultadoEvaluacion> getResultadosEvaluacion() {
        return resultadosEvaluacion;
    }

    public void setResultadosEvaluacion(List<ResultadoEvaluacion> resultadosEvaluacion) {
        this.resultadosEvaluacion = resultadosEvaluacion;
    }
}

