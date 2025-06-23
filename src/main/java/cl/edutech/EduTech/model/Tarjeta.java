package cl.edutech.EduTech.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
//____________________________________________________________________________________
//MODEL HECHO POR EDUARDO URBINA INCLUYENDO SUS DTO, CONTROLLER, SERVICE Y REPOSITORY
//____________________________________________________________________________________
@Entity
public class Tarjeta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int numTarjeta;
    private String nombreTitular;

    public Tarjeta() {
        this.id=0;
        this.numTarjeta=0;
        this.nombreTitular="";
    }

    @ManyToOne
    @JoinColumn(name = "usuario_correo", nullable = false)
    @JsonBackReference
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "metodo_pago_id", nullable = false)
    private MetodoPago formaPago;
    
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
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public MetodoPago getFormaPago() {
        return formaPago;
    }
    public void setFormaPago(MetodoPago formaPago) {
        this.formaPago = formaPago;
    }
    

    
}
