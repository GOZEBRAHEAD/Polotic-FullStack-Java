<%@page import="java.util.ArrayList"%>
<%@page import="Logica.Huesped"%>
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
        <link rel="stylesheet" href="css/reservas_por_huesped_OK.css" type="text/css" />

        <title>Reservas por huesped - Resultados</title>
    </head>
    <body>
        
        <%
            // =========== VERIFICADOR DE EMPLEADO LOGUEADO =========== //
            HttpSession mySession = request.getSession();
            String user = (String) mySession.getAttribute("user");
            
            if (user == null) {
                response.sendRedirect("index.jsp");
            }
            
            String huespedDecidido = mySession.getAttribute("huespedDecidido").toString();
        %>
        
        <h1 class="content__title">Reservas realizadas por el huesped <%= huespedDecidido %></h1>
    
        <main class="content__wrapper">

            <div class="table__wrapper">
                <table class="content__table">
                    <thead>
                        <tr class="head__row">
                            <th>Fecha de Alta</th>
                            <th>Check-In</th>
                            <th>Check-Out</th>
                            <th>Habitación</th>
                            <th>Empleado</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            ControladoraLogica controladoraLogica = new ControladoraLogica();
                            Hotel hotel = controladoraLogica.getHotel();
                            
                            List<Reserva> listaReservas = hotel.getListaReservas();
                            
                            // ========== FORMATO DE FECHAS ========== //
                            SimpleDateFormat formatoFechaFrontEnd = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
                            SimpleDateFormat formatoFechaBackEnd = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
                            
                            String fechaDesdeSession = mySession.getAttribute("fechaDesde").toString();
                            String fechaHastaSession = mySession.getAttribute("fechaHasta").toString();
                            
                            Date fechaDesdeElegida = new Date();
                            Date fechaHastaElegida = new Date();
                            
                            try {
                                fechaDesdeElegida = formatoFechaBackEnd.parse(fechaDesdeSession);
                                fechaHastaElegida = formatoFechaBackEnd.parse(fechaHastaSession);
                            }
                            catch (Exception e) {
                                System.out.println(e);
                            }
                            
                            for(Reserva reservaActual : listaReservas) {
                        %>
                        <tr class="body__row">
                            <%
                                Huesped huespedActual = reservaActual.getHuesped();
                                
                                String nombreHuespedActual = 
                                        huespedActual.getNombre() + " " + huespedActual.getApellido();
                                
                                if (!nombreHuespedActual.equals(huespedDecidido)) {
                                    continue;
                                }
                                
                                Date fechaAltaReserva = reservaActual.getFechaAlta();
                                
                                if (fechaAltaReserva.before(fechaDesdeElegida) || 
                                        fechaAltaReserva.after(fechaHastaElegida)) {
                                    continue;
                                }
                                
                                String fechaAlta = formatoFechaFrontEnd.format(fechaAltaReserva);
                                String checkIn = formatoFechaFrontEnd.format(reservaActual.getCheckIn());
                                String checkOut = formatoFechaFrontEnd.format(reservaActual.getCheckOut());
                                String habitacion = reservaActual.getHabitacion().getNombreTematica();
                                String empleado = reservaActual.getEmpleado().getNombre() + " " + reservaActual.getEmpleado().getApellido();
                            %>
                            <td><%= fechaAlta %></td>
                            <td><%= checkIn %></td>
                            <td><%= checkOut %></td>
                            <td><%= habitacion %></td>
                            <td><%= empleado %></td>
                        </tr>
                        <%
                            }
                        %>
                    </tbody>
                </table>
            </div>

            <a class="btn btn__back" href="ReservasHechasPorHuesped.jsp">Volver</a>

        </main>
        
    </body>
</html>
