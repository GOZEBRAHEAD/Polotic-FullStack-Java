<%@page import="Logica.Huesped"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Lato:wght@300&display=swap" rel="stylesheet">

        <link rel="stylesheet" href="css/DEFAULT_CSS.css" type="text/css" />
        <link rel="stylesheet" href="css/modificar_huesped.css" type="text/css" />

        <title>Modificar huesped</title>
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
        
        <main class="card__huesped">
            <h1 class="card__titulo">Modificar huesped</h1>

            <form class="card__form" action="SvEditarHuesped" method="GET">
                
                <%
                    Huesped huesped = (Huesped) mySession.getAttribute("huespedParaModificar");
                %>
                
                <div>
                    <p>DNI: <input type="text" name="dni" value="<%= huesped.getDni() %>" required /></p>
                    <p>Nombre: <input type="text" name="nombre" value="<%= huesped.getNombre() %>" required /></p>
                    <p>Apellido: <input type="text" name="apellido" value="<%= huesped.getApellido() %>" required /></p>
                    <p>Nacimiento: <input type="date" name="fechaNacimiento" value="<%= huesped.getFechaNacimiento() %>" required /></p>
                    <p>Direccion: <input type="text" name="direccion" value="<%= huesped.getDireccion() %>" required /></p>
                    <p>Profesion: <input type="text" name="profesion" value="<%= huesped.getProfesion() %>" required /></p>
                </div>
                
                <div class="buttons">
                    <a class="btn btn__back" href="PantallaPrincipal.jsp">Cancelar</a>
                    <input type="hidden" name="id" value="<%= huesped.getId() %>" />
                    <button class="btn btn__registrar" type="submit">Confirmar</button>
                </div>

            </form>
        </main>
        
    </body>
</html>
