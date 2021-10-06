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
        <link rel="stylesheet" href="css/index.css" type="text/css" />
        
        <%
            ControladoraLogica controladoraLogica = new ControladoraLogica();
            controladoraLogica.crearDefaults();
            
            HttpSession mySession = request.getSession();
            
            mySession.invalidate();
        %>
        
        <title>Sistema de reservas</title>
    </head>
    <body>
        
        <header>
            <h1>TPO Final Integrador - PoloTIC Misiones</h1>
            <h3>Alumno Luciano Nieves | Comisión 1 | 2021</h3>
        </header>

        <main>
            <a class="btn" href="LoginEmpleado.jsp">Iniciar sesión</a>
            <a class="btn" href="RegistroEmpleado.jsp">Registrar empleado</a>
            <!--
            <form action="SvCrearDefaults" method="POST">
                <a class="btn" href="LoginEmpleado.jsp">Iniciar sesión</a>
                <a class="btn" href="RegistroEmpleado.jsp">Registrar empleado</a>
            </form>
            -->
        </main>
        
    </body>
</html>
