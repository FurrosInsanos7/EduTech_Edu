package cl.edutech.EduTech.dto;

public class PersonaDTO {
    private Long personaId;
    private String nombre;
    private String apellido;
    private String email;
    private String rut;
    private String telefono;

    
    public PersonaDTO(Long personaId, String nombre, String apellido, String email, String rut, String telefono) {
        this.personaId = personaId;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.rut = rut;
        this.telefono = telefono;
    }


    public Long getPersonaId() {
        return personaId;
    }


    public void setPersonaId(Long personaId) {
        this.personaId = personaId;
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


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getRut() {
        return rut;
    }


    public void setRut(String rut) {
        this.rut = rut;
    }


    public String getTelefono() {
        return telefono;
    }


    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    


}
