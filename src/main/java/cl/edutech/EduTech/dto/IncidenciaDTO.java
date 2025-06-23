package cl.edutech.EduTech.dto;

import java.time.LocalDateTime;

public class IncidenciaDTO {

    private int id;
    private String titulo;
    private String descripcion;
    private LocalDateTime fechaReporte;
    private String estado;
    private String prioridad;
    private String usuarioReportaCorreo;
    private String agenteAsignadoCorreo;

    public IncidenciaDTO() {}

    public IncidenciaDTO(int id, String titulo, String descripcion, LocalDateTime fechaReporte,
                         String estado, String prioridad,
                         String usuarioReportaCorreo, String agenteAsignadoCorreo) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaReporte = fechaReporte;
        this.estado = estado;
        this.prioridad = prioridad;
        this.usuarioReportaCorreo = usuarioReportaCorreo;
        this.agenteAsignadoCorreo = agenteAsignadoCorreo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFechaReporte() {
        return fechaReporte;
    }

    public void setFechaReporte(LocalDateTime fechaReporte) {
        this.fechaReporte = fechaReporte;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getUsuarioReportaCorreo() {
        return usuarioReportaCorreo;
    }

    public void setUsuarioReportaCorreo(String usuarioReportaCorreo) {
        this.usuarioReportaCorreo = usuarioReportaCorreo;
    }

    public String getAgenteAsignadoCorreo() {
        return agenteAsignadoCorreo;
    }

    public void setAgenteAsignadoCorreo(String agenteAsignadoCorreo) {
        this.agenteAsignadoCorreo = agenteAsignadoCorreo;
    }

    

}
