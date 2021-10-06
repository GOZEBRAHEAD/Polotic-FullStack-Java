<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Logica.Reserva"%>
<%@page import="Logica.Habitacion"%>
<%@page import="java.util.Locale"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="Logica.Huesped"%>
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
        <link rel="stylesheet" href="css/habitaciones_disponibles.css" type="text/css" />

        <title>Habitaciones disponibles - Resultados</title>
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
        
        <h1 class="content__title">Habitaciones disponibles en el sistema</h1>
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
        <h3 class="content__subtitle">Desde <%= checkIn %> hasta <%= checkOut %></h3>
    
        <main class="content__wrapper">

            <div class="table__wrapper">
                <table class="content__table">
                    <thead>
                        <tr class="head__row">
                            <th>ID</th>
                            <th>Piso</th>
                            <th>Temática</th>
                            <th>Tipo</th>
                            <th>Precio por noche</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            ControladoraLogica controladoraLogica = new ControladoraLogica();
                            Hotel hotel = controladoraLogica.getHotel();

                            List<Reserva> listaReservas = hotel.getListaReservas();
                            List<Habitacion> listaHabitaciones = hotel.getListaHabitaciones();
                            List<Habitacion> listaHabitacionesValidas = listaHabitaciones;
                            
                            // Si hay reservas, debo filtrarlas para evitar problemas de fechas...
                            if (listaReservas.size() != 0) {
                                
                                for (Reserva reservaActual : listaReservas) {
                                    
                                    if (!listaHabitacionesValidas.contains(reservaActual.getHabitacion())) {
                                        continue;
                                    }
                                    
                                    Habitacion habReservada = reservaActual.getHabitacion();
                                    
                                    Date reservaCheckIn = reservaActual.getCheckIn();
                                    Date reservaCheckOut = reservaActual.getCheckOut();

                                    // Si no es una fecha valida, debo remover esa habitacion de la lista
                                    if (!hotel.esFechaValida(
                                            reservaCheckIn.getTime(), reservaCheckOut.getTime(), 
                                            fechaCheckIn.getTime(), fechaCheckOut.getTime())) {

                                        listaHabitacionesValidas.remove(habReservada);
                                    }
                                }
                            }
                                
                            for (Habitacion habitacionActual : listaHabitacionesValidas) {
                        %>
                        
                        <tr class="body__row">
                            <%
                                int idHabitacion = habitacionActual.getId();
                                String piso = habitacionActual.getPiso();
                                String nombreTematica = habitacionActual.getNombreTematica();
                                String tipo = habitacionActual.getTipo().getNombre();
                                double precioPorNoche = habitacionActual.getPrecioPorNoche();
                            %>
                            <td><%= idHabitacion %></td>
                            <td><%= piso %></td>
                            <td><%= nombreTematica %></td>
                            <td><%= tipo %></td>
                            <td><%= precioPorNoche %></td>
                        </tr>
                        <%
                            }
                        %>
                    </tbody>
                </table>
            </div>

            <a class="btn btn__back" href="PantallaPrincipal.jsp">Volver</a>

        </main>
        
    </body>
</html>
