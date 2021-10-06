package Logica;

import Persistencia.ControladoraPersistencia;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ControladoraLogica {
    
    ControladoraPersistencia controladoraPersistencia = new ControladoraPersistencia();
    
    public boolean esCheckInMayorQueCheckOut(Date checkIn, Date checkOut) {
        
        // Si devuelve true, la fecha de CheckIn pasa a la fecha de CheckOut
        // o sea que es un error, nunca debe pasar eso.
        return checkIn.getTime() > checkOut.getTime();
    }
    
    public void crearDefaults() {
        
        crearHotel();
        
        crearTipo("Single", 1);
        crearTipo("Doble", 2);
        crearTipo("Triple", 3);
        crearTipo("Multiple", 8);
    }
    
    public void crearEmpleado(String dni, String nombre, String apellido, Date fechaNacimiento, 
            String direccion, String usuario, String password, String cargo) {
        
        Empleado empleado = new Empleado();
        
        empleado.setDni(dni);
        empleado.setNombre(nombre);
        empleado.setApellido(apellido);        
        empleado.setFechaNacimiento(fechaNacimiento);
        empleado.setDireccion(direccion);
        empleado.setUsuario(usuario);
        empleado.setPassword(password);
        empleado.setCargo(cargo);
        
        controladoraPersistencia.crearEmpleado(empleado);
    }
    
    public int esEmpleadoValido(String usuario, String password) {
        
        Hotel hotel = getHotel();
        
        List<Empleado> listaEmpleados = hotel.getListaEmpleados();
        
        if (listaEmpleados == null) {
            return -1;
        }
        
        for (Empleado empleadoActual : listaEmpleados) {
            
            if (empleadoActual.getUsuario().equals(usuario) &&
                    empleadoActual.getPassword().equals(password)) {
                
                return empleadoActual.getId();
            }
        }
        
        return -1;
    }
    
    public Empleado getEmpleado(int id) {
        
        return controladoraPersistencia.getEmpleado(id);
    }
    
    public void editarEmpleado(Empleado empleado, String dni, String nombre, String apellido, Date fechaNacimiento, 
            String direccion, String user, String pass, String cargo) {
        
        empleado.setDni(dni);
        empleado.setNombre(nombre);
        empleado.setApellido(apellido);
        empleado.setFechaNacimiento(fechaNacimiento);
        empleado.setDireccion(direccion);
        empleado.setUsuario(user);
        empleado.setPassword(pass);
        empleado.setCargo(cargo);
        
        controladoraPersistencia.editarEmpleado(empleado);
    }
    
    public void borrarEmpleado(Empleado empleado) {
        
        controladoraPersistencia.borrarEmpleado(empleado);
    }
    
    public void crearHuesped(String dni, String nombre, String apellido, Date fechaNacimiento, 
            String direccion, String profesion) {
        
        Huesped huesped = new Huesped();
        
        huesped.setDni(dni);
        huesped.setNombre(nombre);
        huesped.setApellido(apellido);
        huesped.setFechaNacimiento(fechaNacimiento);
        huesped.setDireccion(direccion);
        huesped.setProfesion(profesion);
        
        controladoraPersistencia.crearHuesped(huesped);
    }
    
    public void editarHuesped(Huesped huesped, String dni, String nombre, String apellido, Date fechaNacimiento, 
            String direccion, String profesion) {
        
        huesped.setDni(dni);
        huesped.setNombre(nombre);
        huesped.setApellido(apellido);
        huesped.setFechaNacimiento(fechaNacimiento);
        huesped.setDireccion(direccion);
        huesped.setProfesion(profesion);
        
        controladoraPersistencia.editarHuesped(huesped);
    }
    
    public Huesped getHuesped(int id) {
        
        return controladoraPersistencia.getHuesped(id);
    }
    
    public void borrarHuesped(Huesped huesped) {
        
        controladoraPersistencia.borrarHuesped(huesped);
    }
    
    public void updateHotel(Hotel hotel) {
        
        controladoraPersistencia.updateHotel(hotel);
    }
    
    public void crearHotel() {
        
        Hotel hotel = new Hotel();
        
        ArrayList<Reserva> listaReservas = new ArrayList<>();
        ArrayList<Huesped> listaHuespedes = new ArrayList<>();
        ArrayList<Empleado> listaEmpleados = new ArrayList<>();
        
        hotel.setListaEmpleados(listaEmpleados);
        hotel.setListaHuespedes(listaHuespedes);
        hotel.setListaReservas(listaReservas);
        
        controladoraPersistencia.crearHotel(hotel);
    }
    
    public Hotel getHotel() {
        
        return controladoraPersistencia.getHotel();
    }
    
    public void crearHabitacion(String piso, String nombreTematica, double precioPorNoche, Tipo tipo) {
        
        Habitacion habitacion = new Habitacion();
        
        habitacion.setPiso(piso);
        habitacion.setNombreTematica(nombreTematica);
        habitacion.setPrecioPorNoche(precioPorNoche);
        habitacion.setTipo(tipo);
        
        controladoraPersistencia.crearHabitacion(habitacion);
    }
    
    public Habitacion getHabitacion(int id) {
        
        return controladoraPersistencia.getHabitacion(id);
    }
    
    public void crearReserva(Date checkIn, Date checkOut, 
            Date fechaAlta, int totalPersonas, Habitacion habitacion, Huesped huesped, Empleado empleado) {
        
        Reserva reserva = new Reserva();
        
        reserva.setCheckIn(checkIn);
        reserva.setCheckOut(checkOut);
        reserva.setFechaAlta(fechaAlta);
        reserva.setTotalPersonas(totalPersonas);
        reserva.setHabitacion(habitacion);
        reserva.setHuesped(huesped);
        reserva.setEmpleado(empleado);
        
        controladoraPersistencia.crearReserva(reserva);
    }
    
    public Reserva getReserva(int idReserva) {
        
        return controladoraPersistencia.getReserva(idReserva);
    }
    
    public void borrarReserva(Reserva reserva) {
        
        controladoraPersistencia.borrarReserva(reserva);
    }
    
    public void crearTipo(String nombre, int maxPersonas) {
        
        Tipo tipo = new Tipo();
        
        tipo.setNombre(nombre);
        tipo.setMaxPersonas(maxPersonas);
        
        controladoraPersistencia.crearTipo(tipo);
    }
    
    public Tipo getTipo(int index) {
        
        return controladoraPersistencia.getTipo(index);
    }
}
