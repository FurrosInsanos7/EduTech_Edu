package cl.edutech.EduTech.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
//____________________________________________________________________________________
//MODEL HECHO POR EDUARDO URBINA INCLUYENDO SUS DTO, CONTROLLER, SERVICE Y REPOSITORY
//____________________________________________________________________________________
@Entity
public class Usuario {

    @Id
    @Column(nullable = false, unique = true)
    private String correo;
    @Column(nullable = false, unique = true)
    private String rut;
    @JsonIgnore
    @Column(nullable = false)
    private String contraseña;
    @Column(nullable = false)
    private int estado;
    @Column(nullable = false, length = 50)
    private String nombre;
    @Column(nullable = false, length = 50)
    private String apellido;

    @ManyToMany
    @JoinTable(
      name = "usuario_rol",
      joinColumns = @JoinColumn(name = "usuario_correo"),
      inverseJoinColumns = @JoinColumn(name = "rol_id")
    )
    private List<Rol> roles;

    @ManyToMany
    @JoinTable(
        name = "usuario_preferencia",
        joinColumns = @JoinColumn(name = "usuario_correo"),
        inverseJoinColumns = @JoinColumn(name = "preferencia_id")
    )
    private List<Preferencia> preferencias;

    @OneToMany(mappedBy = "usuario")
    private List<Tarjeta> tarjetas;

    @OneToMany(mappedBy = "usuarioReporta")
    private List<Incidencia> incidenciasReportadas;

    @OneToMany(mappedBy = "agenteAsignado")
    private List<Incidencia> incidenciasAsignadas;

    @OneToMany(mappedBy = "usuario")
    private List<UsuarioCurso> inscripcionesCursos;

    @OneToMany(mappedBy = "usuarioPregunta")
    private List<Pregunta> preguntasHechas;

    @OneToMany(mappedBy = "usuarioRespuesta")
    private List<Respuesta> respuestasDadas;

    public Usuario() {
        this.correo = "";
        this.contraseña = "";
        this.estado = 0;
        this.nombre = "";
        this.apellido = "";
        this.rut = "";
    }


    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
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

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }


    public List<Preferencia> getPreferencias() {
        return preferencias;
    }


    public void setPreferencias(List<Preferencia> preferencias) {
        this.preferencias = preferencias;
    }


    public List<Tarjeta> getTarjetas() {
        return tarjetas;
    }


    public void setTarjetas(List<Tarjeta> tarjetas) {
        this.tarjetas = tarjetas;
    }


    public List<Incidencia> getIncidenciasReportadas() {
        return incidenciasReportadas;
    }


    public void setIncidenciasReportadas(List<Incidencia> incidenciasReportadas) {
        this.incidenciasReportadas = incidenciasReportadas;
    }


    public List<Incidencia> getIncidenciasAsignadas() {
        return incidenciasAsignadas;
    }


    public void setIncidenciasAsignadas(List<Incidencia> incidenciasAsignadas) {
        this.incidenciasAsignadas = incidenciasAsignadas;
    }


    public List<UsuarioCurso> getInscripcionesCursos() {
        return inscripcionesCursos;
    }


    public void setInscripcionesCursos(List<UsuarioCurso> inscripcionesCursos) {
        this.inscripcionesCursos = inscripcionesCursos;
    }


    public List<Pregunta> getPreguntasHechas() {
        return preguntasHechas;
    }


    public void setPreguntasHechas(List<Pregunta> preguntasHechas) {
        this.preguntasHechas = preguntasHechas;
    }


    public List<Respuesta> getRespuestasDadas() {
        return respuestasDadas;
    }


    public void setRespuestasDadas(List<Respuesta> respuestasDadas) {
        this.respuestasDadas = respuestasDadas;
    }
    
}
