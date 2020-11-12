package mx.uady.jpademo.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import mx.uady.jpademo.model.LicenciaturaEnum;

public class AlumnoUpdateRequest{

    @NotBlank
    @Size(min = 3, max = 255)
    private String nombre;

    @NotNull
    private LicenciaturaEnum licenciatura;

    public AlumnoUpdateRequest(){
        
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
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
}