package cl.edutech.EduTech.dto;

public class TarjetaDTO {

    private int id;
    private int numTarjeta;
    private String nombreTitular;
    private String usuarioCorreo;
    private int metodoPagoId;

    public TarjetaDTO() { }

    public TarjetaDTO(int id, int numTarjeta, String nombreTitular, String usuarioCorreo, int metodoPagoId) {
        this.id = id;
        this.numTarjeta = numTarjeta;
        this.nombreTitular = nombreTitular;
        this.usuarioCorreo = usuarioCorreo;
        this.metodoPagoId = metodoPagoId;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getNumTarjeta() {
        return numTarjeta;
    }
    public void setNumTarjeta(int numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }
    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public String getUsuarioCorreo() {
        return usuarioCorreo;
    }

    public void setUsuarioCorreo(String usuarioCorreo) {
        this.usuarioCorreo = usuarioCorreo;
    }

    public int getMetodoPagoId() {
        return metodoPagoId;
    }

    public void setMetodoPagoId(int metodoPagoId) {
        this.metodoPagoId = metodoPagoId;
    }

    
}
