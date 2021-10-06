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
            <h1 class="card__titulo">Confirmación de reserva</h1>

            <form class="card__form" action="SvRegistrarReservaConfirmacion" method="POST">
                
                <div class="card__final__wrapper">
                    <%
                        ControladoraLogica controladoraLogica = new ControladoraLogica();
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
                        
                        int msPorDia = 86400000;
                        int diasTotales = (int) ((fechaCheckOut.getTime() - fechaCheckIn.getTime()) / msPorDia);
                        
                        int idHuesped = Integer.parseInt(mySession.getAttribute("idHuesped").toString());
                        int idHabitacion = Integer.parseInt(mySession.getAttribute("idHabitacion").toString());
                        
                        int idEmpleadoLogueado = Integer.parseInt(mySession.getAttribute("idLogin").toString());

                        Habitacion habitacion = controladoraLogica.getHabitacion(idHabitacion);
                        
                        double precioFinalEstadia = diasTotales * habitacion.getPrecioPorNoche();
                    %>
                    
                    <div class="content__final__fechas">
                        <p>Check-In: <input type="text" placeholder="<%= checkIn %>" disabled /></p>
                    </div>
                    
                    <div class="content__final__fechas">
                        <p>Check-Out: <input type="text" placeholder="<%= checkOut %>" disabled /></p>
                    </div>
                    
                    <p class="content__final__huesped">
                        ID huesped: <input type="text" placeholder="<%= idHuesped %>" disabled />
                    </p>
                    
                    <p class="content__final__huesped">
                        ID habitación: <input type="text" placeholder="<%= idHabitacion %>" disabled />
                    </p>
                    
                    <p class="content__final__huesped">
                        Nombre: <input type="text" placeholder="<%= habitacion.getNombreTematica() %>" disabled />
                    </p>
                    
                    <p class="content__final__huesped">
                        Tipo: <input type="text" placeholder="<%= habitacion.getTipo().getNombre() %>" disabled />
                    </p>
                    
                    <p class="content__final__huesped">
                        Piso: <input type="text" placeholder="<%= habitacion.getPiso() %>" disabled />
                    </p>
                    
                    <p class="content__final__huesped">
                        Precio de estadía: <input type="text" placeholder="<%= "$" + precioFinalEstadia %>" disabled />
                    </p>
                    
                    <p class="content__final__huesped">
                        ID del empleado: <input type="text" placeholder="<%= idEmpleadoLogueado %>" disabled />
                    </p>
                </div>
                
                <div class="buttons">
                    <a class="btn btn__back" href="PantallaPrincipal.jsp">Cancelar</a>
                    <input class="btn btn__registrar" type="submit" value="Confirmar" />
                </div>

            </form>
        </main>
        
    </body>
</html>
