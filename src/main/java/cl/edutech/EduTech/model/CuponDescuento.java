package cl.edutech.EduTech.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
//____________________________________________________________________________________
//MODEL HECHO POR MACARENA MUÑOZ INCLUYENDO SUS DTO, CONTROLLER, SERVICE Y REPOSITORY
//____________________________________________________________________________________
@Entity
public class CuponDescuento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String codigo;

    private double porceDescuento;

    private LocalDateTime fechaExpiracion;

    private int usoMax;

    private int usoAct;

    private int estado;

    @OneToMany(mappedBy = "cuponAplicado")
    private List<UsuarioCurso> inscripcionesConEsteCupon;

    public CuponDescuento() {}


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPorceDescuento() {
        return porceDescuento;
    }
    public void setPorceDescuento(double porceDescuento) {
        this.porceDescuento = porceDescuento;
    }

    public LocalDateTime getFechaExpiracion() {
        return fechaExpiracion;
    }
    public void setFechaExpiracion(LocalDateTime fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public int getUsoMax() {
        return usoMax;
    }
    public void setUsoMax(int usoMax) {
        this.usoMax = usoMax;
    }

    public int getUsoAct() {
        return usoAct;
    }
    public void setUsoAct(int usoAct) {
        this.usoAct = usoAct;
    }

    public int getEstado() {
        return estado;
    }
    public void setEstado(int estado) {
        this.estado = estado;
    }

    public List<UsuarioCurso> getInscripcionesConEsteCupon() {
        return inscripcionesConEsteCupon;
    }
    public void setInscripcionesConEsteCupon(List<UsuarioCurso> inscripcionesConEsteCupon) {
        this.inscripcionesConEsteCupon = inscripcionesConEsteCupon;
    }
}