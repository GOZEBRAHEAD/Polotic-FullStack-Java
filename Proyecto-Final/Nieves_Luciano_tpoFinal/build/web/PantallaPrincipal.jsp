<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Lato:wght@300&display=swap" rel="stylesheet">

        <link rel="stylesheet" href="css/DEFAULT_CSS.css" type="text/css" />
        <link rel="stylesheet" href="css/pantalla_principal.css" type="text/css" />
        
        <script src="https://kit.fontawesome.com/c39033e14b.js" crossorigin="anonymous"></script>

        <title>Pantalla principal</title>
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
        
        <main class="buttons">

            <a class="btn btn__container" href="RegistroHuesped.jsp">
                <i class="fas fa-user-plus"></i>
                <p class="btn__title">Crear un huesped</p>
            </a>
            
            <a class="btn btn__container" href="RegistroHabitacion.jsp">
                <i class="fas fa-door-open"></i>
                <p class="btn__title">Crear una habitacion</p>
            </a>
            
            <a class="btn btn__container" href="RegistroReserva.jsp">
                <i class="far fa-plus-square"></i>
                <p class="btn__title">Crear una reserva</p>
            </a>
            
            <a class="btn btn__container" href="ReservasHechas.jsp">
                <i class="fas fa-search"></i>
                <p class="btn__title">Lista de reservas</p>
            </a>

            <a class="btn btn__container" href="HuespedesRegistradosOK.jsp">
                <i class="fas fa-search"></i>
                <p class="btn__title">Lista de huespedes</p>
            </a>
            
            <a class="btn btn__container" href="EmpleadosRegistradosOK.jsp">
                <i class="fas fa-search"></i>
                <p class="btn__title">Lista de empleados</p>
            </a>

            <a class="btn btn__container" href="ReservasHechasPorEmpleado.jsp">
                <i class="fas fa-search"></i>
                <p class="btn__title">Reservas por empleado</p>
            </a>

            <a class="btn btn__container" href="ReservasHechasPorHuesped.jsp">
                <i class="fas fa-search"></i>
                <p class="btn__title">Reservas por huesped</p>
            </a>
            
            <a class="btn btn__container" href="index.jsp">
                <i class="far fa-times-circle"></i>
                <p class="btn__title">Cerrar sesión</p>
            </a>

        </main>
        
    </body>
</html>
