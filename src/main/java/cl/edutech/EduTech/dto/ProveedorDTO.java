package cl.edutech.EduTech.dto;

public class ProveedorDTO {

    private int id;
    private String rut;
    private String nombre;
    private String descripcion;
    private String correo;
    private String telefono;

    public ProveedorDTO() {}

    public ProveedorDTO(int id, String rut, String nombre, String descripcion, String correo, String telefono) {
        this.id = id;
        this.rut = rut;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.correo = correo;
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    
}
