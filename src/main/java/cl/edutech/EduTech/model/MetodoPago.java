package cl.edutech.EduTech.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
//____________________________________________________________________________________
//MODEL HECHO POR MACARENA MUÑOZ INCLUYENDO SUS DTO, CONTROLLER, SERVICE Y REPOSITORY
//____________________________________________________________________________________
@Entity
public class MetodoPago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String codigo;

    @OneToMany(mappedBy = "formaPago")
    private List<Tarjeta> tarjetas;
    
    public MetodoPago() {
        this.id = 0;
        this.nombre = "";
        this.codigo = "";
    }

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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<Tarjeta> getTarjetas() {
        return tarjetas;
    }

    public void setTarjetas(List<Tarjeta> tarjetas) {
        this.tarjetas = tarjetas;
    }

    
}
