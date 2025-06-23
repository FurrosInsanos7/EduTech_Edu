package cl.edutech.EduTech.dto;

import java.time.LocalDateTime;
import java.util.List;

public class PreguntaDTO {

    private int id;
    private String pregunta;
    private String cuerpoPregunta;
    private LocalDateTime fechaPregunta;
    private int seRespondio;
    private int usuarioCursoId;
    private String usuarioPreguntaCorreo;
    private List<Integer> respuestaIds;

    public PreguntaDTO() {}

    public PreguntaDTO(int id, String pregunta, String cuerpoPregunta,
                       LocalDateTime fechaPregunta, int seRespondio,
                       int usuarioCursoId, String usuarioPreguntaCorreo,
                       List<Integer> respuestaIds) {
        this.id = id;
        this.pregunta = pregunta;
        this.cuerpoPregunta = cuerpoPregunta;
        this.fechaPregunta = fechaPregunta;
        this.seRespondio = seRespondio;
        this.usuarioCursoId = usuarioCursoId;
        this.usuarioPreguntaCorreo = usuarioPreguntaCorreo;
        this.respuestaIds = respuestaIds;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getCuerpoPregunta() {
        return cuerpoPregunta;
    }

    public void setCuerpoPregunta(String cuerpoPregunta) {
        this.cuerpoPregunta = cuerpoPregunta;
    }

    public LocalDateTime getFechaPregunta() {
        return fechaPregunta;
    }

    public void setFechaPregunta(LocalDateTime fechaPregunta) {
        this.fechaPregunta = fechaPregunta;
    }

    public int getSeRespondio() {
        return seRespondio;
    }

    public void setSeRespondio(int seRespondio) {
        this.seRespondio = seRespondio;
    }

    public int getUsuarioCursoId() {
        return usuarioCursoId;
    }

    public void setUsuarioCursoId(int usuarioCursoId) {
        this.usuarioCursoId = usuarioCursoId;
    }

    public String getUsuarioPreguntaCorreo() {
        return usuarioPreguntaCorreo;
    }

    public void setUsuarioPreguntaCorreo(String usuarioPreguntaCorreo) {
        this.usuarioPreguntaCorreo = usuarioPreguntaCorreo;
    }

    public List<Integer> getRespuestaIds() {
        return respuestaIds;
    }

    public void setRespuestaIds(List<Integer> respuestaIds) {
        this.respuestaIds = respuestaIds;
    }

    
    
}
