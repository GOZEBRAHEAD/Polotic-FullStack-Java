package Servlets;

import Logica.ControladoraLogica;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvRegistrarReserva", urlPatterns = {"/SvRegistrarReserva"})
public class SvRegistrarReserva extends HttpServlet {

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
        
        int idHuesped = Integer.parseInt(request.getParameter("idHuesped"));
        
        if (controladoraLogica.getHuesped(idHuesped) == null) {
            response.sendRedirect("ErrorRegistrarReserva.jsp");
            return;
        }
        
        String checkIn = request.getParameter("checkIn");
        String checkOut = request.getParameter("checkOut");
        
        SimpleDateFormat formatoFechaBackEnd = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        
        Date fechaCheckIn = new Date();
        Date fechaCheckOut = new Date();
        
        try {
            fechaCheckIn = formatoFechaBackEnd.parse(checkIn);
            fechaCheckOut = formatoFechaBackEnd.parse(checkOut);
        }
        catch (Exception e) {
            System.out.println(e);
        }
        
        if (controladoraLogica.esCheckInMayorQueCheckOut(fechaCheckIn, fechaCheckOut)) {
            response.sendRedirect("ErrorRegistrarReserva.jsp");
            return;
        }
        
        request.getSession().setAttribute("idHuesped", idHuesped);
        request.getSession().setAttribute("reservaNuevaCheckIn", checkIn);
        request.getSession().setAttribute("reservaNuevaCheckOut", checkOut);
            
        response.sendRedirect("RegistroReservaVerificador.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
