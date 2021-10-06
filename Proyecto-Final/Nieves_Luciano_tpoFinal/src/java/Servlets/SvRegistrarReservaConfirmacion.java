package Servlets;

import Logica.ControladoraLogica;
import Logica.Empleado;
import Logica.Habitacion;
import Logica.Huesped;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvRegistrarReservaConfirmacion", urlPatterns = {"/SvRegistrarReservaConfirmacion"})
public class SvRegistrarReservaConfirmacion extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ControladoraLogica controladoraLogica = new ControladoraLogica();
        SimpleDateFormat formatoFechaBackEnd = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        
        int idHabitacion = Integer.parseInt(request.getSession().getAttribute("idHabitacion").toString());
        int idHuesped = Integer.parseInt(request.getSession().getAttribute("idHuesped").toString());
        int idEmpleadoLogueado = Integer.parseInt(request.getSession().getAttribute("idLogin").toString());
        int totalPersonas = Integer.parseInt(request.getSession().getAttribute("totalPersonasReserva").toString());
        
        Habitacion habitacionQueReserva = controladoraLogica.getHabitacion(idHabitacion);
        Huesped huespedQueReserva = controladoraLogica.getHuesped(idHuesped);
        Empleado empleadoLogueado = controladoraLogica.getEmpleado(idEmpleadoLogueado);

        String auxCheckIn = request.getSession().getAttribute("reservaNuevaCheckIn").toString();
        String auxCheckOut = request.getSession().getAttribute("reservaNuevaCheckOut").toString();
        
        Date fechaCheckIn = new Date();
        Date fechaCheckOut = new Date();
        Date fechaAlta = new Date();

        try {
            fechaCheckIn = formatoFechaBackEnd.parse(auxCheckIn);
            fechaCheckOut = formatoFechaBackEnd.parse(auxCheckOut);
        }
        catch (Exception e) {
            System.out.println(e);
        }
        
        if (controladoraLogica.esCheckInMayorQueCheckOut(fechaCheckIn, fechaCheckOut)) {
            response.sendRedirect("ErrorRegistrarReserva.jsp");
            return;
        }
        
        controladoraLogica.crearReserva(fechaCheckIn, fechaCheckOut, fechaAlta, 
                totalPersonas, habitacionQueReserva, huespedQueReserva, empleadoLogueado);
        
        response.sendRedirect("ReservaNuevaCreadaExitosamente.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
