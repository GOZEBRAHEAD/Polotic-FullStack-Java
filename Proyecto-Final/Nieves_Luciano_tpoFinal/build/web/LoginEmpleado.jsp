<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Lato:wght@300&display=swap" rel="stylesheet">

        <link rel="stylesheet" href="css/DEFAULT_CSS.css" type="text/css" />
        <link rel="stylesheet" href="css/login_empleado.css" type="text/css" />

        <title>Login</title>
    </head>
    <body>
        
        <main class="card">
            <h1>Iniciar Sesión</h1>

            <form action="SvLoginEmpleado" method="POST">

                <div class="inputs">
                    <p>Usuario: <input class="input__field" type="text" name="usuario" required /></p>
                    <p>Contraseña: <input class="input__field" type="password" name="password" required /></p>
                </div>

                <div class="buttons">
                    <a class="btn btn__back" href="index.jsp">Cancelar</a>
                    <input class="btn btn__login" type="submit" value="Entrar" />
                </div>

            </form>
        </main>
        
    </body>
</html>
