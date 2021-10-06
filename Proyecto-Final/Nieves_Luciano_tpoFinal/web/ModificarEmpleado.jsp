<%@page import="Logica.Empleado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Lato:wght@300&display=swap" rel="stylesheet">

        <link rel="stylesheet" href="css/DEFAULT_CSS.css" type="text/css" />
        <link rel="stylesheet" href="css/modificar_empleado.css" type="text/css" />

        <title>Modificar empleado</title>
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
        
        <main class="card__empleado">
            <h1 class="card__titulo">Modificar empleado</h1>

            <form class="card__form" action="SvEditarEmpleado" method="GET">
                
                <%
                    Empleado empleado = (Empleado) mySession.getAttribute("empleadoParaModificar");
                %>

                <div>
                    <p>DNI: <input type="text" name="dni" value="<%= empleado.getDni() %>" required /></p>
                    <p>Nombre: <input type="text" name="nombre" value="<%= empleado.getNombre() %>" required /></p>
                    <p>Apellido: <input type="text" name="apellido" value="<%= empleado.getApellido() %>" required /></p>
                    <p>Nacimiento: <input type="date" name="fechaNacimiento" value="<%= empleado.getFechaNacimiento() %>" required /></p>
                    <p>Direccion: <input type="text" name="direccion" value="<%= empleado.getDireccion() %>" required /></p>
                    <p>Usuario: <input type="text" name="usuario" value="<%= empleado.getUsuario() %>" required /></p>
                    <p>Password: <input type="password" name="password" value="<%= empleado.getPassword() %>" required /></p>
                    <p>Cargo: <input type="text" name="cargo" value="<%= empleado.getCargo() %>" required /></p>
                </div>
                
                <div class="buttons">
                    <a class="btn btn__back" href="PantallaPrincipal.jsp">Cancelar</a>
                    <input type="hidden" name="id" value="<%= empleado.getId() %>" />
                    <button class="btn btn__registrar" type="submit">Confirmar</button>
                </div>

            </form>
        </main>
        
    </body>
</html>
