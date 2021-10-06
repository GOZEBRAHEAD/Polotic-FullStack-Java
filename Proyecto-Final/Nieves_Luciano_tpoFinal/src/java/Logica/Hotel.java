package Logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Hotel implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @OneToMany
    private List<Reserva> listaReservas;
    
    @OneToMany
    private List<Huesped> listaHuespedes;
    
    @OneToMany
    private List<Empleado> listaEmpleados;
    
    @OneToMany
    private List<Habitacion> listaHabitaciones;

    public Hotel() {
    }

    public Hotel(int id, List<Reserva> listaReservas, 
            List<Huesped> listaHuespedes, List<Empleado> listaEmpleados, List<Habitacion> listaHabitaciones) {
        
        this.id = id;
        this.listaReservas = listaReservas;
        this.listaHuespedes = listaHuespedes;
        this.listaEmpleados = listaEmpleados;
        this.listaHabitaciones = listaHabitaciones;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(List<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

    public List<Huesped> getListaHuespedes() {
        return listaHuespedes;
    }

    public void setListaHuespedes(List<Huesped> listaHuespedes) {
        this.listaHuespedes = listaHuespedes;
    }

    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public List<Habitacion> getListaHabitaciones() {
        return listaHabitaciones;
    }

    public void setListaHabitaciones(List<Habitacion> listaHabitaciones) {
        this.listaHabitaciones = listaHabitaciones;
    }
    
    public void addEmpleado(Empleado empleado) {
        this.listaEmpleados.add(empleado);
    }
    
    public void updateListaEmpleados(Empleado empleado) {
        
        List<Empleado> listaNuevaEmpleados = new ArrayList<>();
        
        int empleadoID = empleado.getId();
        
        for(Empleado empleadoActual : this.listaEmpleados) {
            
            if (empleadoActual.getId() == empleadoID) {
                continue;
            }
            
            listaNuevaEmpleados.add(empleadoActual);
        }
        
        this.listaEmpleados = listaNuevaEmpleados;
    }
    
    public void addHuesped(Huesped huesped) {
        this.listaHuespedes.add(huesped);
    }
    
    public void updateListaHuespedes(Huesped huesped) {
        
        List<Huesped> listaNuevaHuespedes = new ArrayList<>();
        
        int huespedID = huesped.getId();
        
        for(Huesped huespedActual : this.listaHuespedes) {
            
            if (huespedActual.getId() == huespedID) {
                continue;
            }
            
            listaNuevaHuespedes.add(huespedActual);
        }
        
        this.listaHuespedes = listaNuevaHuespedes;
    }
    
    public void addReserva(Reserva reserva) {
        this.listaReservas.add(reserva);
    }
    
    public void updateListaReservas(Reserva reserva) {
        
        List<Reserva> listaNueva = new ArrayList<>();
        
        for(Reserva reservaActual : this.listaReservas) {
            
            if (reservaActual.getId() == reserva.getId()) {
                
                continue;
            }
            
            listaNueva.add(reservaActual);
        }
        
        this.listaReservas = listaNueva;
    }
    
    public void addHabitacion(Habitacion habitacion) {
        this.listaHabitaciones.add(habitacion);
    }
    
    public boolean esFechaValida(long reservaCheckIn, long reservaCheckOut, long checkInNuevo, long checkOutNuevo) {
        
        if ((checkInNuevo <= reservaCheckOut && checkOutNuevo >= reservaCheckIn) ||
            (checkInNuevo >= reservaCheckIn && checkOutNuevo <= reservaCheckOut) || 
            (checkInNuevo <= reservaCheckIn && checkOutNuevo >= reservaCheckOut)) {
            
            return false;
        }
        
        return true;
    }
}
