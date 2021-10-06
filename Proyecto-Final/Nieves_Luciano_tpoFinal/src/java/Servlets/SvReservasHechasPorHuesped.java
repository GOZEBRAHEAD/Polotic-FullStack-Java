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

@WebServlet(name = "SvReservasHechasPorHuesped", urlPatterns = {"/SvReservasHechasPorHuesped"})
public class SvReservasHechasPorHuesped extends HttpServlet {

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
        
        String huespedFinal = request.getParameter("huespedElegido");
        String fechaDesde = request.getParameter("fechaDesde");
        String fechaHasta = request.getParameter("fechaHasta");
        
        SimpleDateFormat formatoFechaBackEnd = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

        Date fechaCheckIn = new Date();
        Date fechaCheckOut = new Date();

        try {
            fechaCheckIn = formatoFechaBackEnd.parse(fechaDesde);
            fechaCheckOut = formatoFechaBackEnd.parse(fechaHasta);
        }
        catch (Exception e) {
            System.out.println(e);
        }
        
        ControladoraLogica controladoraLogica = new ControladoraLogica();
        
        if (controladoraLogica.esCheckInMayorQueCheckOut(fechaCheckIn, fechaCheckOut)) {
            response.sendRedirect("ErrorRegistrarReserva.jsp");
            return;
        }
        
        request.getSession().setAttribute("huespedDecidido", huespedFinal);
        request.getSession().setAttribute("fechaDesde", fechaDesde);
        request.getSession().setAttribute("fechaHasta", fechaHasta);
            
        response.sendRedirect("ReservasHechasPorHuespedOK.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
