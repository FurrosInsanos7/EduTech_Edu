package cl.edutech.EduTech.dto;

import java.util.List;

public class PreferenciaDTO {

    private int id;
    private String descripcion;
    private List<String> usuarioCorreos;

    public PreferenciaDTO() {}

    public PreferenciaDTO(int id, String descripcion, List<String> usuarioCorreos) {
        this.id = id;
        this.descripcion = descripcion;
        this.usuarioCorreos = usuarioCorreos;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<String> getUsuarioCorreos() {
        return usuarioCorreos;
    }
    public void setUsuarioCorreos(List<String> usuarioCorreos) {
        this.usuarioCorreos = usuarioCorreos;
    }

    
}
    


