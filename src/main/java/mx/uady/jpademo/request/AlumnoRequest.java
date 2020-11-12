package mx.uady.jpademo.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import mx.uady.jpademo.model.LicenciaturaEnum;

public class AlumnoRequest{

    @NotBlank
    @Size(min = 3, max = 255)
    private String nombre;

    @NotNull
    private Integer id;

    @NotNull
    private LicenciaturaEnum licenciatura;

    @NotBlank
    private String usuario;

    public AlumnoRequest(){
        
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
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

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
}