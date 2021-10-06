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
        <link rel="stylesheet" href="css/reservas_por_huesped.css" type="text/css" />

        <title>Reservas por huesped</title>
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
        
        <form action="SvReservasHechasPorHuesped" method="POST">
            <main class="content__wrapper">
                <h1>Reservas realizadas por un huesped</h1>

                <div class="content__huespedes">
                    <p>
                        Seleccione el huesped: 
                        <select name="huespedElegido">
                            <%
                                ControladoraLogica controladoraLogica = new ControladoraLogica();
                                Hotel hotel = controladoraLogica.getHotel();

                                List<Huesped> listaHuespedes = hotel.getListaHuespedes();
                                
                                for (Huesped huespedActual : listaHuespedes) {

                                    String huesped = huespedActual.getNombre() + " " + huespedActual.getApellido();
                            %>
                            <option name="empleadoElegido">
                                <%= huesped %>
                            </option>
                            <%
                                }
                            %>
                        </select>
                    </p>
                    <p>Fecha desde: <input type="date" name="fechaDesde" required /></p>
                    <p>Fecha hasta: <input type="date" name="fechaHasta" required /></p>
                </div>

                <div class="buttons">
                    <a class="btn btn__back" href="PantallaPrincipal.jsp">Cancelar</a>
                    <input class="btn btn__buscar" type="submit" value="Buscar" />
                </div>

            </main>
        </form>
        
    </body>
</html>
