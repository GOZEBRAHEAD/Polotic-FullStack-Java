<%@page import="java.util.Locale"%>
<%@page import="java.util.logging.Logger"%>
<%@page import="java.util.logging.Level"%>
<%@page import="java.time.LocalDate"%>
<%@page import="Logica.Empleado"%>
<%@page import="Logica.Huesped"%>
<%@page import="Logica.Habitacion"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="Logica.Reserva"%>
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
        <link rel="stylesheet" href="css/reservas_hechas_OK.css" type="text/css" />
        
        <script src="https://kit.fontawesome.com/c39033e14b.js" crossorigin="anonymous"></script>

        <title>Reservas realizadas - Resultados</title>
    </head>
    <body>
        
        <%
            // =========== VERIFICADOR DE EMPLEADO LOGUEADO =========== //
            HttpSession mySession = request.getSession();
            String user = (String) mySession.getAttribute("user");
            
            if (user == null) {
                response.sendRedirect("index.jsp");
            }
            
            SimpleDateFormat formatoFechaFrontEnd = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
            SimpleDateFormat formatoFechaBackEnd = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

            String fechaGuardadaSession = mySession.getAttribute("fechaDecidida").toString();

            Date fechaElegida = new Date();

            try {
                fechaElegida = formatoFechaBackEnd.parse(fechaGuardadaSession);
            }
            catch (Exception e) {
                System.out.println(e);
            }

            String checkInTitulo = formatoFechaFrontEnd.format(fechaElegida);
        %>
        
        <h1 class="content__title">Reservas realizadas el día <%= checkInTitulo %></h1>
    
        <main class="content__wrapper">

            <div class="table__wrapper">
                <table class="content__table">
                    <thead>
                        <tr class="head__row">
                            <th>ID</th>
                            <th>Check-In</th>
                            <th>Check-Out</th>
                            <th>Habitación</th>
                            <th>Huesped</th>
                            <th>Personas</th>
                            <th>Empleado</th>
                            <th>Eliminar</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            ControladoraLogica controladoraLogica = new ControladoraLogica();
                            Hotel hotel = controladoraLogica.getHotel();
                            
                            List<Reserva> listaReservas = hotel.getListaReservas();
                            
                            for(Reserva reservaActual : listaReservas) {
                        %>
                        <tr class="body__row">
                            <%
                                String fechaReservaActual = formatoFechaFrontEnd.format(reservaActual.getFechaAlta());
                                
                                if (!fechaReservaActual.equals(checkInTitulo)) {
                                    continue;
                                }
                                
                                int id = reservaActual.getId();
                                String checkIn = formatoFechaFrontEnd.format(reservaActual.getCheckIn());
                                String checkOut = formatoFechaFrontEnd.format(reservaActual.getCheckOut());
                                
                                String huesped = 
                                        reservaActual.getHuesped().getNombre() + " " + 
                                        reservaActual.getHuesped().getApellido();
                                
                                int totalPersonas = reservaActual.getTotalPersonas();
                                
                                String habitacion = reservaActual.getHabitacion().getNombreTematica();
                                
                                String empleado = 
                                        reservaActual.getEmpleado().getNombre() + " " + 
                                        reservaActual.getEmpleado().getApellido();
                                
                            %>
                            <td><%= id %></td>
                            <td><%= checkIn %></td>
                            <td><%= checkOut %></td>
                            <td><%= habitacion %></td>
                            <td><%= huesped %></td>
                            <td><%= totalPersonas %></td>
                            <td><%= empleado %></td>
                            <td>
                                <form action="SvEliminarReserva" method="post">
                                    <input type="hidden" name="idReserva" value="<%= id %>">
                                    <button class="btn btn__delete" type="submit"><i class="far fa-trash-alt"></i></button>
                                </form>
                            </td>
                        </tr>
                        <%
                            }
                        %>
                    </tbody>
                </table>
            </div>

            <a class="btn btn__back" href="ReservasHechas.jsp">Volver</a>

        </main>
        
    </body>
</html>
