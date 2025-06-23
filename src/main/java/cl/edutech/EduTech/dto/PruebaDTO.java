package cl.edutech.EduTech.dto;

import java.util.List;

public class PruebaDTO {

    private int id;
    private String nombre;
    private String descripcion;
    private String tipoPrueba;
    private int cursoId;
    private List<Integer> resultadoEvaluacionIds;

    public PruebaDTO() {}

    public PruebaDTO(int id, String nombre, String descripcion, String tipoPrueba, int cursoId, List<Integer> resultadoEvaluacionIds) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipoPrueba = tipoPrueba;
        this.cursoId = cursoId;
        this.resultadoEvaluacionIds = resultadoEvaluacionIds;
    }

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

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoPrueba() {
        return tipoPrueba;
    }
    public void setTipoPrueba(String tipoPrueba) {
        this.tipoPrueba = tipoPrueba;
    }

    public int getCursoId() {
        return cursoId;
    }
    public void setCursoId(int cursoId) {
        this.cursoId = cursoId;
    }

    public List<Integer> getResultadoEvaluacionIds() {
        return resultadoEvaluacionIds;
    }
    public void setResultadoEvaluacionIds(List<Integer> resultadoEvaluacionIds) {
        this.resultadoEvaluacionIds = resultadoEvaluacionIds;
    }
}
