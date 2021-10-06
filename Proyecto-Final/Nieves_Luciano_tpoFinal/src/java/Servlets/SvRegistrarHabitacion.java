package Servlets;

import Logica.ControladoraLogica;
import Logica.Tipo;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvRegistrarHabitacion", urlPatterns = {"/SvRegistrarHabitacion"})
public class SvRegistrarHabitacion extends HttpServlet {

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
        
        try {
            String piso = request.getParameter("piso");
            String nombreTematica = request.getParameter("nombreTematica");
            double precioPorNoche = Double.parseDouble(request.getParameter("precioPorNoche"));
            
            String tipoElegido = request.getParameter("tipoElegido");
            int tipoIndex;           
            
            switch(tipoElegido) {
                case "Single":
                    tipoIndex = 0;
                    break;
                    
                case "Doble":
                    tipoIndex = 1;
                    break;
                    
                case "Triple":
                    tipoIndex = 2;
                    break;
                    
                case "Multiple":
                    tipoIndex = 3;
                    break;
                    
                default:
                    response.sendRedirect("ErrorRegistrarReserva.jsp");
                    return;
            }
            
            ControladoraLogica controladoraLogica = new ControladoraLogica();
            
            Tipo tipoHabitacion = controladoraLogica.getTipo(tipoIndex);
            
            controladoraLogica.crearHabitacion(piso, nombreTematica, precioPorNoche, tipoHabitacion);
            
            response.sendRedirect("PantallaPrincipal.jsp");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
