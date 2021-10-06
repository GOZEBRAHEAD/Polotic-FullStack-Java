package Logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;

@Entity
@SuppressWarnings("IdDefinedInHierarchy")
public class Huesped extends Persona implements Serializable {
    
    @Basic
    private String profesion;

    public Huesped() {
    }

    public Huesped(String profesion, int id, String dni, String nombre, 
            String apellido, Date fechaNacimiento, String direccion) {
        
        super(id, dni, nombre, apellido, fechaNacimiento, direccion);
        
        this.profesion = profesion;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }
}
