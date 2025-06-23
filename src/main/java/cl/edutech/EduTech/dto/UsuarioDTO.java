package cl.edutech.EduTech.dto;

import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UsuarioDTO {

    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "Debe ser un email válido")
    private String correo;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 50)
    private String nombre;

    @NotBlank(message = "El apellido es obligatorio")
    @Size(max = 50)
    private String apellido;

    @Min(value = 0, message = "El estado debe ser 0 o mayor")
    private int estado;

    private List<@NotNull Integer> rolIds;
    private List<@NotNull Integer> preferenciaIds;


    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
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
    public List<Integer> getRolIds() {
        return rolIds;
    }
    public void setRolIds(List<Integer> rolIds) {
        this.rolIds = rolIds;
    }
    public List<Integer> getPreferenciaIds() {
        return preferenciaIds;
    }
    public void setPreferenciaIds(List<Integer> preferenciaIds) {
        this.preferenciaIds = preferenciaIds;
    }
}

    

