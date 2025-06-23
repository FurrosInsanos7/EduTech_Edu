package cl.edutech.EduTech.dto;

import java.util.List;

public class MetodoPagoDTO {

    private int id;
    private String nombre;
    private String codigo;
    private List<Integer> tarjetaIds;

    public MetodoPagoDTO() {}

    public MetodoPagoDTO(int id, String nombre, String codigo, List<Integer> tarjetaIds) {
        this.id = id;
        this.nombre = nombre;
        this.codigo = codigo;
        this.tarjetaIds = tarjetaIds;
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<Integer> getTarjetaIds() {
        return tarjetaIds;
    }

    public void setTarjetaIds(List<Integer> tarjetaIds) {
        this.tarjetaIds = tarjetaIds;
    }
    
    
}
