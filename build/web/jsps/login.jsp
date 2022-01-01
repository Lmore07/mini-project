<%-- 
    Document   : login
    Created on : 30-dic-2021, 1:47:04
    Author     : luism
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <TITLe>INICIO DE SESION</TITLe>
        <link rel="stylesheet" href="../css/form.css">
        <script src="../js/jquery.js"></script>

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <style>
            #bb {
                display: grid;
            }
        </style>
    </head>
    <body>
        <div class="container-fluid w-75 mt-3 rounded-circle">
            <div class="row align-items-stretch justify-content-lg-center justify-content-md-center justify-content-xs-center">
                <div class="col bg-white p-2 rounded-end col-md-8">
                    <div class="text-end">
                        
                    </div>
                    <h2 class="fw-bold text-center py-4 rounded">Bienvenido</h2>
                    <form action="/mini-project/login" method="POST">
                        <div class="mb-4">
                            <label for="correo" class="form-label">Correo:</label>
                            <input type="email" name="correo" value="" id="correo" class="form-control"
                                   placeholder="email@example.com" required>
                        </div>
                        <div class="mb-4">
                            <label for="password" class="col-form-label">Contraseña:</label>
                            <div class="input-group">
                                <input ID="password" name="password" type="Password" Class="form-control" placeholder="********">
                                <div class="input-group-append">
                                    <button id="show_password" class="btn btn-primary" type="button"> <span class="fa fa-eye-slash icon"></span> </button>
                                </div>
                            </div>
                        </div>
                        <div class="mb-4" id="bb">
                            <button type="submit" id="login" name="login" class="btn btn-primary">Iniciar Sesion</button>
                        </div>
                        <div class="my-3">
                            <span>¿Aún no tienes cuenta? <a href="Registro.jsp">Registrate aquí</a></span><br>
                            <span><a href="">Recuperar contraseña</a></span>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <SCript src="../js/jquery.js"></SCript>
        <SCript src="../js/bootstrap.js"></SCript>
        <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <SCript src="../js/inicio_sesion.js"></SCript>
    </body>
</html>
