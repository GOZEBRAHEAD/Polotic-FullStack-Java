<%@page import="java.util.Date"%>
<%@page import="Logica.Reserva"%>
<%@page import="Logica.Huesped"%>
<%@page import="Logica.Habitacion"%>
<%@page import="java.util.List"%>
<%@page import="Logica.Empleado"%>
<%@page import="Logica.Hotel"%>
<%@page import="Logica.ControladoraLogica"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Lato:wght@300&display=swap" rel="stylesheet">

        <link rel="stylesheet" href="css/DEFAULT_CSS.css" type="text/css" />
        <link rel="stylesheet" href="css/registro_reserva.css" type="text/css" />
        
        <script src="https://kit.fontawesome.com/c39033e14b.js" crossorigin="anonymous"></script>

        <title>Registro reserva</title>
    </head>
    <body>
        
        <%
            // =========== VERIFICADOR DE EMPLEADO LOGUEADO =========== //
            HttpSession mySession = request.getSession();
            String user = (String) mySession.getAttribute("user");
            
            if (user == null) {
                response.sendRedirect("index.jsp");
            }
        %>
        
        <main class="card__reserva">
            <h1 class="card__titulo">Registrar reserva</h1>

            <form class="card__form" action="SvRegistrarReserva" method="POST">
                
                <div class="card__wrapper">
                    <div class="content__fechas">
                        <p>Check-In: <input type="date" name="checkIn" required /></p>
                    </div>
                    
                    <div class="content__fechas">
                        <p>Check-Out: <input type="date" name="checkOut" required /></p>
                    </div>
                    
                    <p class="content__huesped">
                        ID huesped: <input type="text" name="idHuesped" required />
                        <a href="HuespedesRegistradosOK.jsp" target="_blank"><i class="fas fa-search"></i></a>
                    </p>
                    
                </div>
                
                <div class="buttons">
                    <a class="btn btn__back" href="PantallaPrincipal.jsp">Cancelar</a>
                    <input class="btn btn__registrar" type="submit" value="Continuar" />
                </div>

            </form>
        </main>
        
    </body>
</html>
