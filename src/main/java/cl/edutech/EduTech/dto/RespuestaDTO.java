package cl.edutech.EduTech.dto;

import java.time.LocalDateTime;

public class RespuestaDTO {

    private int id;
    private String respuesta;
    private LocalDateTime fechaRespuesta;
    private int preguntaId;
    private String usuarioCorreo;

    public RespuestaDTO() {}

    public RespuestaDTO(int id, String respuesta, LocalDateTime fechaRespuesta, int preguntaId, String usuarioCorreo) {
        this.id = id;
        this.respuesta = respuesta;
        this.fechaRespuesta = fechaRespuesta;
        this.preguntaId = preguntaId;
        this.usuarioCorreo = usuarioCorreo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public LocalDateTime getFechaRespuesta() {
        return fechaRespuesta;
    }

    public void setFechaRespuesta(LocalDateTime fechaRespuesta) {
        this.fechaRespuesta = fechaRespuesta;
    }

    public int getPreguntaId() {
        return preguntaId;
    }

    public void setPreguntaId(int preguntaId) {
        this.preguntaId = preguntaId;
    }

    public String getUsuarioCorreo() {
        return usuarioCorreo;
    }

    public void setUsuarioCorreo(String usuarioCorreo) {
        this.usuarioCorreo = usuarioCorreo;
    }

    
}
