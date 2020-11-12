package mx.uady.jpademo.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import org.springframework.data.repository.cdi.Eager;

@Entity
@Table(name = "alumnos")
public class Alumno {

    @Id
    public Integer id;

    @Column 
    private String nombre;

    @Column(name = "licenciatura")
    @Enumerated(EnumType.STRING)
    private LicenciaturaEnum licenciatura;

    @ManyToOne
    @JoinColumn(name = "id_equipo")
    private Equipo equipoId;

    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuarioId;

    /*@OneToMany(mappedBy = "alumno")
    @JsonManagedReference
    private Set<Tutoria> tutorias;*/

    public Alumno() {
    }

    public Alumno(Integer id, String nombre, Equipo equipoId, Usuario usuarioId) {
        this.id = id;
        this.nombre = nombre;
        this.equipoId = equipoId;
        this.usuarioId = usuarioId;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the licenciatura
     */
    public LicenciaturaEnum getLicenciatura() {
        return licenciatura;
    }

    /**
     * @param licenciatura the licenciatura to set
     */
    public void setLicenciatura(LicenciaturaEnum licenciatura) {
        this.licenciatura = licenciatura;
    }

    public Equipo getEquipoId() {
        return this.equipoId;
    }

    public void setEquipoId(Equipo equipoId) {
        this.equipoId = equipoId;
    }

    public Usuario getUsuarioId() {
        return this.usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    /*public Set<Tutoria> getTutorias() {
        return this.tutorias;
    }

    public void setTutorias(Set<Tutoria> tutorias) {
        this.tutorias = tutorias;
    }*/

    public Alumno id(Integer id) {
        this.id = id;
        return this;
    }

    public Alumno nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public Alumno licenciatura(LicenciaturaEnum licenciatura){
        this.licenciatura = licenciatura;
        return this;
    }

    public Alumno equipoId(Equipo equipoId) {
        this.equipoId = equipoId;
        return this;
    }

    public Alumno usuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
        return this;
    }

    /*public Alumno tutorias(Set<Tutoria> tutorias) {
        this.tutorias = tutorias;
        return this;
    }*/


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", usuarioId='" + getUsuarioId() + "'" +
            "}";
    }
    
}