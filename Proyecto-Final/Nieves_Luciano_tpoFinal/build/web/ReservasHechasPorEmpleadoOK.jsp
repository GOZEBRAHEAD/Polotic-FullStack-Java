<%@page import="java.util.ArrayList"%>
<%@page import="Logica.Empleado"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Locale"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Logica.Reserva"%>
<%@page import="java.util.List"%>
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
        <link rel="stylesheet" href="css/reservas_por_empleado_OK.css" type="text/css" />

        <title>Reservas por empleado - Resultados</title>
    </head>
    <body>
        
        <%
            // =========== VERIFICADOR DE EMPLEADO LOGUEADO =========== //
            HttpSession mySession = request.getSession();
            String user = (String) mySession.getAttribute("user");
            
            if (user == null) {
                response.sendRedirect("index.jsp");
            }
            
            String empleadoDecidido = mySession.getAttribute("empleadoDecidido").toString();
        %>
        
        <h1 class="content__title">Reservas realizadas por el empleado <%= empleadoDecidido %></h1>
    
        <main class="content__wrapper">

            <div class="table__wrapper">
                <table class="content__table">
                    <thead>
                        <tr class="head__row">
                            <th>Fecha de Alta</th>
                            <th>Check-In</th>
                            <th>Check-Out</th>
                            <th>Habitación</th>
                            <th>Huesped</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            ControladoraLogica controladoraLogica = new ControladoraLogica();
                            Hotel hotel = controladoraLogica.getHotel();
                            
                            List<Reserva> listaReservas = hotel.getListaReservas();
                            
                            // ========== FORMATO DE FECHAS ========== //
                            SimpleDateFormat formatoFechaFrontEnd = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
                            
                            for(Reserva reservaActual : listaReservas) {
                        %>
                        <tr class="body__row">
                            <%
                                Empleado empleadoActual = reservaActual.getEmpleado();
                                
                                String nombreEmpleadoActual = 
                                        empleadoActual.getNombre() + " " + empleadoActual.getApellido();
                                
                                if (!nombreEmpleadoActual.equals(empleadoDecidido)) {
                                    continue;
                                }
                                
                                String fecha = formatoFechaFrontEnd.format(reservaActual.getFechaAlta());
                                String checkIn = formatoFechaFrontEnd.format(reservaActual.getCheckIn());
                                String checkOut = formatoFechaFrontEnd.format(reservaActual.getCheckOut());
                                String habitacion = reservaActual.getHabitacion().getNombreTematica();
                                String huesped = reservaActual.getHuesped().getNombre() + " " + reservaActual.getHuesped().getApellido();
                            %>
                            <td><%= fecha %></td>
                            <td><%= checkIn %></td>
                            <td><%= checkOut %></td>
                            <td><%= habitacion %></td>
                            <td><%= huesped %></td>
                        </tr>
                        <%
                            }
                        %>
                    </tbody>
                </table>
            </div>

            <a class="btn btn__back" href="ReservasHechasPorEmpleado.jsp">Volver</a>

        </main>
        
    </body>
</html>
