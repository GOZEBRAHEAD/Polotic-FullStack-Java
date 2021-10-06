<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Locale"%>
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

            <form class="card__form" action="SvRegistrarReservaVerificador" method="POST">
                
                <!--<div>-->
                <div class="card__wrapper">
                    <%
                        SimpleDateFormat formatoFechaFrontEnd = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
                        SimpleDateFormat formatoFechaBackEnd = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
                        
                        String fechaCheckInSession = mySession.getAttribute("reservaNuevaCheckIn").toString();
                        String fechaCheckOutSession = mySession.getAttribute("reservaNuevaCheckOut").toString();
                        
                        Date fechaCheckIn = new Date();
                        Date fechaCheckOut = new Date();

                        try {
                            fechaCheckIn = formatoFechaBackEnd.parse(fechaCheckInSession);
                            fechaCheckOut = formatoFechaBackEnd.parse(fechaCheckOutSession);
                        }
                        catch (Exception e) {
                            System.out.println(e);
                        }
                        
                        String checkIn = formatoFechaFrontEnd.format(fechaCheckIn);
                        String checkOut = formatoFechaFrontEnd.format(fechaCheckOut);
                    %>
                    
                    <div class="content__fechas">
                        <p>Check-In: <input type="text" placeholder="<%= checkIn %>" disabled /></p>
                    </div>
                    
                    <div class="content__fechas">
                        <p>Check-Out: <input type="text" placeholder="<%= checkOut %>" disabled /></p>
                    </div>
                    
                    <p class="content__huesped">
                        ID habitación: <input type="text" name="idHabitacion" required />
                        <a href="HabitacionesDisponibles.jsp" target="_blank"><i class="fas fa-search"></i></a>
                    </p>
                    
                    <p class="content__huesped">
                        Total personas: <input type="number" name="totalPersonasReserva" min="1" max="8" required />
                    </p>
                </div>
                
                <div class="buttons">
                    <a class="btn btn__back" href="RegistroReserva.jsp">Cancelar</a>
                    <input class="btn btn__registrar" type="submit" value="Continuar" />
                </div>

            </form>
        </main>
        
    </body>
</html>
