package Logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Reserva implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Temporal(TemporalType.DATE)
    private Date checkIn;
    
    @Temporal(TemporalType.DATE)
    private Date checkOut;
    
    @Temporal(TemporalType.DATE)
    private Date fechaAlta;
    
    @Basic
    private int totalPersonas;
    
    @OneToOne
    private Habitacion habitacion;
    
    @OneToOne
    private Huesped huesped;
    
    @OneToOne
    private Empleado empleado;

    public Reserva() {
    }

    public Reserva(int id, Date checkIn, Date checkOut, 
            Date fechaAlta, int totalPersonas, Habitacion habitacion, Huesped huesped, Empleado empleado) {
        
        this.id = id;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.fechaAlta = fechaAlta;
        this.totalPersonas = totalPersonas;
        this.habitacion = habitacion;
        this.huesped = huesped;
        this.empleado = empleado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public int getTotalPersonas() {
        return totalPersonas;
    }

    public void setTotalPersonas(int totalPersonas) {
        this.totalPersonas = totalPersonas;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public Huesped getHuesped() {
        return huesped;
    }

    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
}
