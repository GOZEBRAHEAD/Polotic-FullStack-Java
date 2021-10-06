package Servlets;

import Logica.ControladoraLogica;
import Logica.Huesped;
import Logica.Reserva;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvEliminarHuesped", urlPatterns = {"/SvEliminarHuesped"})
public class SvEliminarHuesped extends HttpServlet {

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
        
        int idHuesped = Integer.parseInt(request.getParameter("idHuesped"));
        
        ControladoraLogica controladoraLogica = new ControladoraLogica();
        
        Huesped huesped = controladoraLogica.getHuesped(idHuesped);
        controladoraLogica.borrarHuesped(huesped);
        
        response.sendRedirect("HuespedesRegistradosOK.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
