package Logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;

@Entity
@SuppressWarnings("IdDefinedInHierarchy")
public class Empleado extends Persona implements Serializable {
    
    @Basic
    private String usuario;
    private String password;
    private String cargo;

    public Empleado() {
    }

    public Empleado(String usuario, String password, String cargo, 
            int id, String dni, String nombre, String apellido, Date fechaNacimiento, String direccion) {
        
        super(id, dni, nombre, apellido, fechaNacimiento, direccion);
        
        this.usuario = usuario;
        this.password = password;
        this.cargo = cargo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
