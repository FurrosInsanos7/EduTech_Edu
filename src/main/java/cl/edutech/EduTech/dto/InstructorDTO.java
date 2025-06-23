package cl.edutech.EduTech.dto;

import java.util.List;

public class InstructorDTO {

    private String rut;
    private String correo;
    private String contrasena;
    private String nombre;
    private String apellido;
    private int estado;
    private List<Integer> cursoIds;

    public InstructorDTO() {}

    public InstructorDTO(String rut, String correo, String contrasena,
                         String nombre, String apellido, int estado,
                         List<Integer> cursoIds) {
        this.rut = rut;
        this.correo = correo;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.apellido = apellido;
        this.estado = estado;
        this.cursoIds = cursoIds;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public List<Integer> getCursoIds() {
        return cursoIds;
    }

    public void setCursoIds(List<Integer> cursoIds) {
        this.cursoIds = cursoIds;
    }

    
    

}
