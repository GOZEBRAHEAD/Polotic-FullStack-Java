package Servlets;

import Logica.ControladoraLogica;
import Logica.Hotel;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvRegistrarEmpleado", urlPatterns = {"/SvRegistrarEmpleado"})
public class SvRegistrarEmpleado extends HttpServlet {

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
            String dni = request.getParameter("dni");
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            Date fechaNacimiento = formatoFecha.parse(request.getParameter("fechaNacimiento"));
            
            String direccion = request.getParameter("direccion");
            String usuario = request.getParameter("usuario");
            String password = request.getParameter("password");
            String cargo = request.getParameter("cargo");
            
            request.getSession().setAttribute("registro", "empleado");
            request.getSession().setAttribute("usuario", usuario);
            
            ControladoraLogica controladoraLogica = new ControladoraLogica();
            controladoraLogica.crearEmpleado(dni, nombre, apellido, fechaNacimiento, direccion, usuario, password, cargo);
            
            response.sendRedirect("index.jsp");
        } catch (ParseException ex) {
            Logger.getLogger(SvRegistrarEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
