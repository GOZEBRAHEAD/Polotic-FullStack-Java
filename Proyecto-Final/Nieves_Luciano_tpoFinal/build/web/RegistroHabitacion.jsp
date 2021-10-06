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
        <link rel="stylesheet" href="css/registro_habitacion.css" type="text/css" />

        <title>Registro habitacion</title>
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
        
        <main class="card__habitacion">
            <h1 class="card__titulo">Registrar habitacion</h1>

            <form class="card__form" action="SvRegistrarHabitacion" method="POST">
                
                <div class="card__wrapper">
                    
                    <p class="content__habitacion">Piso: <input type="text" name="piso" required /></p>
                    <p class="content__habitacion">Nombre temática: <input type="text" name="nombreTematica" required /></p>
                    <p class="content__habitacion">Precio por noche: <input type="text" name="precioPorNoche" required /></p>
                    <p class="content__habitacion">
                        Tipo de habitación:
                        
                        <select name="tipoElegido">
                            <option name="tipoElegido">Single</option>
                            <option name="tipoElegido">Doble</option>
                            <option name="tipoElegido">Triple</option>
                            <option name="tipoElegido">Multiple</option>
                        </select>
                    </p>
                </div>
                
                <div class="buttons">
                    <a class="btn btn__back" href="PantallaPrincipal.jsp">Cancelar</a>
                    <input class="btn btn__registrar" type="submit" value="Registrar" />
                </div>

            </form>
        </main>
        
    </body>
</html>
