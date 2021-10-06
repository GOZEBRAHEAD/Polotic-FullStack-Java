package Servlets;

import Logica.ControladoraLogica;
import Logica.Huesped;
import Logica.Reserva;
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

@WebServlet(name = "SvEditarHuesped", urlPatterns = {"/SvEditarHuesped"})
public class SvEditarHuesped extends HttpServlet {

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
            String profesion = request.getParameter("profesion");
            
            ControladoraLogica controladoraLogica = new ControladoraLogica();
            Huesped huesped = controladoraLogica.getHuesped(id);
            
            controladoraLogica.editarHuesped(huesped, dni, nombre, apellido, fechaNacimiento, direccion, profesion);
            
            response.sendRedirect("HuespedesRegistradosOK.jsp");
            
        } catch (ParseException ex) {
            Logger.getLogger(SvEditarHuesped.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int idHuesped = Integer.parseInt(request.getParameter("idHuesped"));
        
        ControladoraLogica controladoraLogica = new ControladoraLogica();
        
        Huesped huesped = controladoraLogica.getHuesped(idHuesped);
        
        HttpSession mySession = request.getSession();
        mySession.setAttribute("huespedParaModificar", huesped);
        
        response.sendRedirect("ModificarHuesped.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
