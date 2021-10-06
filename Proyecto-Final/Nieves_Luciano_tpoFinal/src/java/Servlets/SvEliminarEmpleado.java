package Servlets;

import Logica.ControladoraLogica;
import Logica.Empleado;
import Logica.Huesped;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvEliminarEmpleado", urlPatterns = {"/SvEliminarEmpleado"})
public class SvEliminarEmpleado extends HttpServlet {

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
        
        int idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));
        
        ControladoraLogica controladoraLogica = new ControladoraLogica();
        
        Empleado empleado = controladoraLogica.getEmpleado(idEmpleado);
        controladoraLogica.borrarEmpleado(empleado);
        
        response.sendRedirect("EmpleadosRegistradosOK.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
