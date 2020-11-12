package mx.uady.jpademo.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "profesores")
public class Profesor {

    @Id
    private Integer id;

    @Column
    private String nombre;

    @OneToMany(mappedBy = "profesor")
    @JsonManagedReference
    private Set<Tutoria> tutorias;

    public Profesor() {
    }

    public Profesor(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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

    public Profesor id(Integer id) {
        this.id = id;
        return this;
    }

    public Profesor nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nombre='" + getNombre() + "'" +
            "}";
    }

    public void setTutoria(Set<Tutoria> tutorias){
        this.tutorias = tutorias;
    }

    public Set<Tutoria> getTutorias() {
        return tutorias;
    }

}