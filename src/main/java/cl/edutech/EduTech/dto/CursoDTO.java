    package cl.edutech.EduTech.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public class CursoDTO {

    private int id;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "La categoría es obligatoria")
    private String categoria;

    @NotBlank(message = "El nivel es obligatorio")
    private String nivel;

    // Lista de RUTs de instructores
    private List<String> instructorRuts;

    // Getters y setters

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

    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNivel() {
        return nivel;
    }
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public List<String> getInstructorRuts() {
        return instructorRuts;
    }
    public void setInstructorRuts(List<String> instructorRuts) {
        this.instructorRuts = instructorRuts;
    }
}
