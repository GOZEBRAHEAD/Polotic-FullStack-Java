package Servlets;

import Logica.ControladoraLogica;
import Logica.Empleado;
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
import javax.servlet.http.HttpSession;

@WebServlet(name = "SvEditarEmpleado", urlPatterns = {"/SvEditarEmpleado"})
public class SvEditarEmpleado extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            
            int id = Integer.parseInt(request.getParameter("id"));
            String dni = request.getParameter("dni");
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            Date fechaNacimiento = formatoFecha.parse(request.getParameter("fechaNacimiento"));
            
            String direccion = request.getParameter("direccion");
            String cargo = request.getParameter("cargo");
            
            String user = request.getParameter("usuario");
            String pass = request.getParameter("password");
            
            ControladoraLogica controladoraLogica = new ControladoraLogica();
            Empleado empleado = controladoraLogica.getEmpleado(id);
            
            controladoraLogica.editarEmpleado(empleado, dni, nombre, apellido, fechaNacimiento, direccion, user, pass, cargo);
            
            response.sendRedirect("EmpleadosRegistradosOK.jsp");
            
        } catch (ParseException ex) {
            Logger.getLogger(SvEditarEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));
        
        ControladoraLogica controladoraLogica = new ControladoraLogica();
        
        Empleado empleado = controladoraLogica.getEmpleado(idEmpleado);
        
        HttpSession mySession = request.getSession();
        mySession.setAttribute("empleadoParaModificar", empleado);
        
        response.sendRedirect("ModificarEmpleado.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
