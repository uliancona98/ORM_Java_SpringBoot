package mx.uady.jpademo.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
public class ProfesorRequest{

    @NotNull
    private Integer id;

    @NotBlank
    @Size(min = 3, max = 255)
    private String nombre;

    private Integer horas;

    public ProfesorRequest(){
        
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }
    
    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the profesor
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * @param profesor the profesor to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the horas
     */
    public Integer getHoras() {
        return this.horas;
    }
    
    /**
     * @param horas the id to set
     */
    public void setHoras(Integer horas) {
        this.horas = horas;
    }


}