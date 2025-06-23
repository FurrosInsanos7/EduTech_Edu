package cl.edutech.EduTech.model;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
//____________________________________________________________________________________
//MODEL HECHO POR MACARENA MUÑOZ INCLUYENDO SUS DTO, CONTROLLER, SERVICE Y REPOSITORY
//____________________________________________________________________________________
@Entity
public class Pregunta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String pregunta;
    private String cuerpoPregunta;
    private LocalDateTime fechaPregunta;
    private int seRespondio;//0=no 1=si

    @ManyToOne
    @JoinColumn(name = "usuario_curso_id", nullable = false)
    @JsonBackReference
    private UsuarioCurso usuarioCurso;

    @ManyToOne
    @JoinColumn(name = "usuario_pregunta", referencedColumnName = "correo", nullable = false)
    @JsonBackReference
    private Usuario usuarioPregunta;

    @OneToMany(mappedBy = "pregunta")
    private List<Respuesta> respuestas;

    public Pregunta(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getCuerpoPregunta() {
        return cuerpoPregunta;
    }

    public void setCuerpoPregunta(String cuerpoPregunta) {
        this.cuerpoPregunta = cuerpoPregunta;
    }

    public LocalDateTime getFechaPregunta() {
        return fechaPregunta;
    }

    public void setFechaPregunta(LocalDateTime fechaPregunta) {
        this.fechaPregunta = fechaPregunta;
    }

    public int getSeRespondio() {
        return seRespondio;
    }

    public void setSeRespondio(int seRespondio) {
        this.seRespondio = seRespondio;
    }

    public UsuarioCurso getUsuarioCurso() {
        return usuarioCurso;
    }

    public void setUsuarioCurso(UsuarioCurso usuarioCurso) {
        this.usuarioCurso = usuarioCurso;
    }

    public Usuario getUsuarioPregunta() {
        return usuarioPregunta;
    }

    public void setUsuarioPregunta(Usuario usuarioPregunta) {
        this.usuarioPregunta = usuarioPregunta;
    }

    public List<Respuesta> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }
    
}
