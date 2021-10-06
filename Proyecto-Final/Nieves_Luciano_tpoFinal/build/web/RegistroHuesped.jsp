<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Lato:wght@300&display=swap" rel="stylesheet">

        <link rel="stylesheet" href="css/DEFAULT_CSS.css" type="text/css" />
        <link rel="stylesheet" href="css/registro_huesped.css" type="text/css" />

        <title>Registro huesped</title>
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
            <h1 class="card__titulo">Registrar huesped</h1>

            <form class="card__form" action="SvRegistrarHuesped" method="POST">
                
                <div>
                    <p>DNI: <input type="text" name="dni" required /></p>
                    <p>Nombre: <input type="text" name="nombre" required /></p>
                    <p>Apellido: <input type="text" name="apellido" required /></p>
                    <p>Nacimiento: <input type="date" name="fechaNacimiento" required /></p>
                    <p>Direccion: <input type="text" name="direccion" required /></p>
                    <p>Profesion: <input type="text" name="profesion" required /></p>
                </div>
                
                <div class="buttons">
                    <a class="btn btn__back" href="PantallaPrincipal.jsp">Cancelar</a>
                    <input class="btn btn__registrar" type="submit" value="Registrar" />
                </div>

            </form>
        </main>
        
    </body>
</html>
