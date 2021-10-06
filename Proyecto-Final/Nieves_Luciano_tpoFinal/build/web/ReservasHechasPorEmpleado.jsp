<%@page import="Logica.Empleado"%>
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
        <link rel="stylesheet" href="css/reservas_por_empleado.css" type="text/css" />

        <title>Reservas por empleado</title>
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
        
        <form action="SvReservasHechasPorEmpleado" method="POST">
            <main class="content__wrapper">
                <h1>Reservas realizadas por un empleado</h1>

                <div class="content__empleados">
                    <p>
                        Seleccione el empleado:
                        <select name="empleadoElegido">
                            <%
                                ControladoraLogica controladoraLogica = new ControladoraLogica();
                                Hotel hotel = controladoraLogica.getHotel();

                                List<Empleado> listaEmpleados = hotel.getListaEmpleados();

                                for (Empleado empleadoActual : listaEmpleados) {

                                    String empleado = empleadoActual.getNombre() + " " + empleadoActual.getApellido();
                            %>
                            <option name="empleadoElegido">
                                <%= empleado %>
                            </option>
                            <%
                                }
                            %>
                        </select>
                    </p>
                </div>

                <div class="buttons">
                    <a class="btn btn__back" href="PantallaPrincipal.jsp">Cancelar</a>
                    <input class="btn btn__buscar" type="submit" value="Buscar" />
                </div>

            </main>
        </form>
        
    </body>
</html>
