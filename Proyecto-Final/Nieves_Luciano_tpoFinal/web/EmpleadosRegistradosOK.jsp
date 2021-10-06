<%@page import="Logica.Empleado"%>
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
        <link rel="stylesheet" href="css/empleados_registrados_OK.css" type="text/css" />

        <script src="https://kit.fontawesome.com/c39033e14b.js" crossorigin="anonymous"></script>
        
        <title>Empleados registrados - Resultados</title>
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
        
        <h1 class="content__title">Empleados registrados en el sistema</h1>
    
        <main class="content__wrapper">

            <div class="table__wrapper">
                <table class="content__table">
                    <thead>                        
                        <tr class="head__row">
                            <th>ID</th>
                            <th>Dni</th>
                            <th>Nombre y apellido</th>
                            <th>Fecha nacimiento</th>
                            <th>Dirección</th>
                            <th>Cargo</th>
                            <th>Editar</th>
                            <th>Eliminar</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            ControladoraLogica controladoraLogica = new ControladoraLogica();
                            Hotel hotel = controladoraLogica.getHotel();
                            
                            List<Empleado> listaEmpleados = hotel.getListaEmpleados();
                            
                            // ========== FORMATO DE FECHAS ========== //
                            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
                            
                            for(Empleado empleadoActual : listaEmpleados) {
                        %>
                        <tr class="body__row">
                            <%
                                int id = empleadoActual.getId();
                                String dni = empleadoActual.getDni();
                                String nombreApellido = empleadoActual.getNombre() + " " + empleadoActual.getApellido();
                                String fechaNacimiento = formatoFecha.format(empleadoActual.getFechaNacimiento());
                                String direccion = empleadoActual.getDireccion();
                                String cargo = empleadoActual.getCargo();
                            %>
                            <td><%= id %></td>
                            <td><%= dni %></td>
                            <td><%= nombreApellido %></td>
                            <td><%= fechaNacimiento %></td>
                            <td><%= direccion %></td>
                            <td><%= cargo %></td>
                            <td>
                                <form action="SvEditarEmpleado" method="post">
                                    <input type="hidden" name="idEmpleado" value="<%= id %>">
                                    <button class="btn btn__edit" type="submit"><i class="far fa-edit"></i></button>
                                </form>
                            </td>
                            <td>
                                <form action="SvEliminarEmpleado" method="post">
                                    <input type="hidden" name="idEmpleado" value="<%= id %>">
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

            <a class="btn btn__back" href="PantallaPrincipal.jsp">Volver</a>

        </main>
        
    </body>
</html>
