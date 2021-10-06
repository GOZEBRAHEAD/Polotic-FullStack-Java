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

@WebServlet(name = "SvRegistrarHuesped", urlPatterns = {"/SvRegistrarHuesped"})
public class SvRegistrarHuesped extends HttpServlet {

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
            // ========= CREACION DE HUESPED ========= //
            String dni = request.getParameter("dni");
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            
            //SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            Date fechaNacimiento = formatoFecha.parse(request.getParameter("fechaNacimiento"));
            
            String direccion = request.getParameter("direccion");
            String profesion = request.getParameter("profesion");
            
            // ========= CREACION DE LA CONTROLADORA DE LA LOGICA ========= //
            ControladoraLogica controladoraLogica = new ControladoraLogica();
            controladoraLogica.crearHuesped(dni, nombre, apellido, fechaNacimiento, direccion, profesion);
            
            // ========= ENVIO DE RESPUESTA ========= //
            response.sendRedirect("FinRegistro.jsp");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
