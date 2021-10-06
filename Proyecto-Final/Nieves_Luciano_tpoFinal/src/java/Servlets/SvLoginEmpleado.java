package Servlets;

import Logica.ControladoraLogica;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SvLoginEmpleado", urlPatterns = {"/SvLoginEmpleado"})
public class SvLoginEmpleado extends HttpServlet {

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
        
        String usuarioEscrito = request.getParameter("usuario");
        String passEscrito = request.getParameter("password");
        
        int idLogin = controladoraLogica.esEmpleadoValido(usuarioEscrito, passEscrito);
        
        if (idLogin == -1) {
            
            response.sendRedirect("LoginEmpleado.jsp");
        }
        else {
            
            HttpSession mySession = request.getSession(true);
            
            mySession.setAttribute("user", usuarioEscrito);
            mySession.setAttribute("pass", passEscrito);
            mySession.setAttribute("idLogin", idLogin);
            
            response.sendRedirect("PantallaPrincipal.jsp");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
