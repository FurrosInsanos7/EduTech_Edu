package cl.edutech.EduTech.dto;

import java.time.LocalDateTime;
import java.util.List;

public class CuponDescuentoDTO {

    private int id;
    private String codigo;
    private double porceDescuento;
    private LocalDateTime fechaExpiracion;
    private int usoMax;
    private int usoAct;
    private int estado;
    private List<Integer> usuarioCursoIds;

    public CuponDescuentoDTO() {}

    public CuponDescuentoDTO(int id, String codigo, double porceDescuento, LocalDateTime fechaExpiracion,
                             int usoMax, int usoAct, int estado, List<Integer> usuarioCursoIds) {
        this.id = id;
        this.codigo = codigo;
        this.porceDescuento = porceDescuento;
        this.fechaExpiracion = fechaExpiracion;
        this.usoMax = usoMax;
        this.usoAct = usoAct;
        this.estado = estado;
        this.usuarioCursoIds = usuarioCursoIds;
    }

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

    public List<Integer> getUsuarioCursoIds() {
        return usuarioCursoIds;
    }

    public void setUsuarioCursoIds(List<Integer> usuarioCursoIds) {
        this.usuarioCursoIds = usuarioCursoIds;
    }

    
    

}
