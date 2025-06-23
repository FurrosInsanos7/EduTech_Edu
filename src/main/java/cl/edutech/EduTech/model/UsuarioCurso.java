package cl.edutech.EduTech.model;


import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
//____________________________________________________________________________________
//MODEL HECHO POR EDUARDO URBINA INCLUYENDO SUS DTO, CONTROLLER, SERVICE Y REPOSITORY
//____________________________________________________________________________________
@Entity
public class UsuarioCurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "fecha_inscripcion", nullable = false)
    private LocalDateTime fechaInscripcion;

    @Column(nullable = false)
    private int progreso;

    @Column(name = "fecha_finalizado")
    private LocalDateTime fechaFinalizado;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuario_correo", nullable = false)
    @JsonBackReference
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "curso_id", nullable = false)
    @JsonBackReference
    private Curso curso;

    @OneToMany(mappedBy = "usuarioCurso", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ResultadoEvaluacion> resultadosEvaluacion;

    @OneToOne(mappedBy = "usuarioCurso", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Resena resena;

    @OneToOne(mappedBy = "usuarioCurso", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Valoracion valoracion;

    @OneToMany(mappedBy = "usuarioCurso", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Pregunta> preguntas;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cupon_id")
    @JsonBackReference
    private CuponDescuento cuponAplicado;

    public UsuarioCurso(){
        this.id=0;
        this.fechaInscripcion = null;
        this.progreso=0;
        this.fechaFinalizado= null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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

    public Resena getResena() {
        return resena;
    }

    public void setResena(Resena resena) {
        this.resena = resena;
    }

    public Valoracion getValoracion() {
        return valoracion;
    }

    public void setValoracion(Valoracion valoracion) {
        this.valoracion = valoracion;
    }

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    public CuponDescuento getCuponAplicado() {
        return cuponAplicado;
    }

    public void setCuponAplicado(CuponDescuento cuponAplicado) {
        this.cuponAplicado = cuponAplicado;
    }


    
}
