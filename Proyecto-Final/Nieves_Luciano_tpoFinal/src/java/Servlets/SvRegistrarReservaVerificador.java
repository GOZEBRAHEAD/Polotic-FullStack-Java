package Servlets;

import Logica.ControladoraLogica;
import Logica.Habitacion;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvRegistrarReservaVerificador", urlPatterns = {"/SvRegistrarReservaVerificador"})
public class SvRegistrarReservaVerificador extends HttpServlet {

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
        
        int idHabitacion, totalPersonasReserva;
        
        try {
            
            idHabitacion = Integer.parseInt(request.getParameter("idHabitacion"));
            
            ControladoraLogica controladoraLogica = new ControladoraLogica();
            
            Habitacion habitacion = controladoraLogica.getHabitacion(idHabitacion);
            
            if (controladoraLogica.getHabitacion(idHabitacion) == null) {
                response.sendRedirect("ErrorRegistrarReserva.jsp");
                return;
            }
            
            int maxPersonasHabitacion = habitacion.getTipo().getMaxPersonas();
            String tipoHabitacion = habitacion.getTipo().getNombre();
            
            // Total de personas que se quedan en la reserva de esa habitacion
            totalPersonasReserva = Integer.parseInt(request.getParameter("totalPersonasReserva"));
            
            switch(tipoHabitacion) {
                
                case "Single":
                    totalPersonasReserva = 1;
                    break;
                    
                case "Doble":
                case "Triple":
                case "Multiple":
                    
                    if (totalPersonasReserva <= 0 || (totalPersonasReserva > maxPersonasHabitacion)) {
                        response.sendRedirect("ErrorRegistrarReserva.jsp");
                        return;
                    }
                    break;
                    
                default:
                    response.sendRedirect("ErrorRegistrarReserva.jsp");
                    return;
            }
        }
        catch (NumberFormatException e) {
            
            response.sendRedirect("ErrorRegistrarReserva.jsp");
            System.out.println(e);
            return;
        }
        
        request.getSession().setAttribute("idHabitacion", idHabitacion);
        request.getSession().setAttribute("totalPersonasReserva", totalPersonasReserva);
        
        response.sendRedirect("RegistroReservaConfirmacion.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
