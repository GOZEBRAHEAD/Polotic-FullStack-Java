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
        <link rel="stylesheet" href="css/huespedes_registrados_OK.css" type="text/css" />
        
        <script src="https://kit.fontawesome.com/c39033e14b.js" crossorigin="anonymous"></script>

        <title>Huespedes registrados - Resultados</title>
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
        
        <h1 class="content__title">Huespedes registrados en el sistema</h1>
    
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
                            <th>Profesión</th>
                            <th>Editar</th>
                            <th>Eliminar</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%                            
                            ControladoraLogica controladoraLogica = new ControladoraLogica();
                            Hotel hotel = controladoraLogica.getHotel();
                            
                            List<Huesped> listaHuespedes = hotel.getListaHuespedes();
                            
                            // ========== FORMATO DE FECHAS ========== //
                            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
                            
                            for(Huesped huespedActual : listaHuespedes) {
                        %>
                        <tr class="body__row">
                            <%
                                int id = huespedActual.getId();
                                String dni = huespedActual.getDni();
                                String nombreApellido = huespedActual.getNombre() + " " + huespedActual.getApellido();
                                String fechaNacimiento = formatoFecha.format(huespedActual.getFechaNacimiento());
                                String direccion = huespedActual.getDireccion();
                                String profesion = huespedActual.getProfesion();
                            %>
                            <td><%= id %></td>
                            <td><%= dni %></td>
                            <td><%= nombreApellido %></td>
                            <td><%= fechaNacimiento %></td>
                            <td><%= direccion %></td>
                            <td><%= profesion %></td>
                            <td>
                                <form action="SvEditarHuesped" method="post">
                                    <input type="hidden" name="idHuesped" value="<%= id %>">
                                    <button class="btn btn__edit" type="submit"><i class="far fa-edit"></i></button>
                                </form>
                            </td>
                            <td>
                                <form action="SvEliminarHuesped" method="post">
                                    <input type="hidden" name="idHuesped" value="<%= id %>">
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
