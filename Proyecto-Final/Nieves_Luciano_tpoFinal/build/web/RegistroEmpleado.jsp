<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Lato:wght@300&display=swap" rel="stylesheet">

        <link rel="stylesheet" href="css/DEFAULT_CSS.css" type="text/css" />
        <link rel="stylesheet" href="css/registro_empleado.css" type="text/css" />

        <title>Registro empleado</title>
    </head>
    <body>
        
        <main class="card__empleado">
            <h1 class="card__titulo">Registrar empleado</h1>

            <form class="card__form" action="SvRegistrarEmpleado" method="POST">

                <div>
                    <p>DNI: <input type="text" name="dni" required /></p>
                    <p>Nombre: <input type="text" name="nombre" required /></p>
                    <p>Apellido: <input type="text" name="apellido" required /></p>
                    <p>Nacimiento: <input type="date" name="fechaNacimiento" required /></p>
                    <p>Direccion: <input type="text" name="direccion" required /></p>
                    <p>Usuario: <input type="text" name="usuario" required /></p>
                    <p>Password: <input type="password" name="password" required /></p>
                    <p>Cargo: <input type="text" name="cargo" required /></p>
                </div>
                
                <div class="buttons">
                    <a class="btn btn__back" href="index.jsp">Cancelar</a>
                    <input class="btn btn__registrar" type="submit" value="Registrar" />
                </div>

            </form>
        </main>
        
    </body>
</html>
