package Persistencia;

import Logica.Empleado;
import Logica.Habitacion;
import Logica.Hotel;
import Logica.Huesped;
import Logica.Persona;
import Logica.Reserva;
import Logica.Tipo;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {
    
    // Controladoras de persistencia
    EmpleadoJpaController controller_empleadoJPA = new EmpleadoJpaController();
    HuespedJpaController controller_huespedJPA = new HuespedJpaController();
    PersonaJpaController controller_personaJPA = new PersonaJpaController();
    HotelJpaController controller_hotelJPA = new HotelJpaController();
    HabitacionJpaController controller_habitacionJPA = new HabitacionJpaController();
    ReservaJpaController controller_reservaJPA = new ReservaJpaController();
    TipoJpaController controller_tipoJPA = new TipoJpaController();
    
    // Funciones de creacion
    public void crearEmpleado(Empleado empleadoNuevo) {
        
        controller_empleadoJPA.create(empleadoNuevo);
        
        Hotel hotel = getHotel();
        
        if (hotel == null) {
            crearHotel(hotel);
        }
        
        hotel.addEmpleado(empleadoNuevo);
        
        updateHotel(hotel);
    }
    
    public Empleado getEmpleado(int id) {
        
        return controller_empleadoJPA.findEmpleado(id);
    }
    
    public void editarEmpleado(Empleado empleado) {
        
        try {
            controller_empleadoJPA.edit(empleado);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void borrarEmpleado(Empleado empleado) {
        
        try {
            Hotel hotel = getHotel();
        
            if (hotel == null) {
                crearHotel(hotel);
            }
            
            List<Reserva> listaReservas = getListaReservas();
            
            int empleadoID = empleado.getId();
            
            for(Reserva reservaActual : listaReservas) {
            
                if (reservaActual.getEmpleado().getId() != empleadoID) {
                    continue;
                }

                borrarReserva(reservaActual);
            }

            hotel.updateListaEmpleados(empleado);

            updateHotel(hotel);
            
            controller_empleadoJPA.destroy(empleadoID);
            
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void crearHuesped(Huesped huespedNuevo) {
        
        controller_huespedJPA.create(huespedNuevo);
        
        Hotel hotel = getHotel();
        
        if (hotel == null) {
            crearHotel(hotel);
        }
        
        hotel.addHuesped(huespedNuevo);
        
        updateHotel(hotel);
    }
    
    public void editarHuesped(Huesped huesped) {
        
        try {
            controller_huespedJPA.edit(huesped);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Huesped getHuesped(int id) {
        
        return controller_huespedJPA.findHuesped(id);
    }
    
    public void borrarHuesped(Huesped huesped) {
        
        try {
            Hotel hotel = getHotel();
        
            if (hotel == null) {
                crearHotel(hotel);
            }
            
            List<Reserva> listaReservas = getListaReservas();
            
            int huespedID = huesped.getId();
            
            for(Reserva reservaActual : listaReservas) {
            
                if (reservaActual.getHuesped().getId() != huespedID) {
                    continue;
                }

                borrarReserva(reservaActual);
            }

            hotel.updateListaHuespedes(huesped);

            updateHotel(hotel);
            
            controller_huespedJPA.destroy(huespedID);
            
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void crearPersona(Persona personaNuevo) {
        
        controller_personaJPA.create(personaNuevo);
    }
    
    public void crearHotel(Hotel hotelNuevo) {
        
        if (getHotel() == null) {
            System.out.println("Hotel creado!");
            controller_hotelJPA.create(hotelNuevo);
        }
        else {
            System.out.println("Ya hay un hotel creado, no se creará uno nuevo.");
        }
    }
    
    public Hotel getHotel() {
        
        List<Hotel> listaHoteles = controller_hotelJPA.findHotelEntities();
        
        return (listaHoteles.size() != 0) ? listaHoteles.get(0) : null;
    }
    
    public void updateHotel(Hotel hotel) {
        
        try {
            controller_hotelJPA.edit(hotel);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void crearHabitacion(Habitacion habitacionNueva) {
        
        controller_habitacionJPA.create(habitacionNueva);
        
        Hotel hotel = getHotel();
        
        if (hotel == null) {
            crearHotel(hotel);
        }
        
        hotel.addHabitacion(habitacionNueva);
        
        updateHotel(hotel);
    }
    
    public Habitacion getHabitacion(int id) {
        
        return controller_habitacionJPA.findHabitacion(id);
    }
    
    public void crearReserva(Reserva reservaNuevo) {
        
        controller_reservaJPA.create(reservaNuevo);
        
        Hotel hotel = getHotel();
        
        if (hotel == null) {
            crearHotel(hotel);
        }
        
        hotel.addReserva(reservaNuevo);
        
        updateHotel(hotel);
    }
    
    public Reserva getReserva(int id) {
        
        return controller_reservaJPA.findReserva(id);
    }
    
    public List<Reserva> getListaReservas() {
        
        return controller_reservaJPA.findReservaEntities();
    }
    
    public void borrarReserva(Reserva reserva) {
        
        try {
            Hotel hotel = getHotel();
        
            if (hotel == null) {
                crearHotel(hotel);
            }
            
            System.out.println("funcion borrarReserva");

            hotel.updateListaReservas(reserva);

            updateHotel(hotel);
            
            controller_reservaJPA.destroy(reserva.getId());
            
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void crearTipo(Tipo tipoNuevo) {
        
        if (controller_tipoJPA.findTipoEntities().size() == 4) {
            return;
        }
        
        controller_tipoJPA.create(tipoNuevo);
    }
    
    public Tipo getTipo(int index) {
        
        List<Tipo> listaTipos = controller_tipoJPA.findTipoEntities();
        
        return (listaTipos.size() != 0) ? listaTipos.get(index) : null;
    }
}
