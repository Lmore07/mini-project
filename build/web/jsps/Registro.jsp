<%-- 
    Document   : Usuarios
    Created on : 29-dic-2021, 17:50:06
    Author     : luism
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <TITLe>FORMULARIO DE REGISTRO USUARIO</TITLe>
        <link rel="stylesheet" href="../css/form.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <script src="../js/jquery.min.js"></script>
        <style>
            input[type=number]::-webkit-inner-spin-button,
            input[type=number]::-webkit-outer-spin-button {
                -webkit-appearance: none;
                margin: 0;
            }

            input[type=number] {
                -moz-appearance:textfield;
            }
        </style>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row justify-content-center mt-1 pt-1">
                <div>
                    <h1 class="display-4">Formulario de Registro</h1>
                    <hr class="bg-info">
                    <p class="pb-0 mb-0">Bienvenido, ingresa tus datos</p>
                    <p class="text-danger small pt-0 mt-0">*Todos los campos son obligatorios</p>
                    <form action="/mini-project/users" method="POST">
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="nombres" class="col-form-label">Nombres:</label>
                                <input type="text" name="nombre" value="" id="nombre" class="form-control" placeholder="Ingrese sus nombres" required>
                            </div>
                            <div class="form-group col-md-6">
                                <label for="apellidos" class="col-form-label">Apellidos:</label>
                                <input type="text" name="apellidos" value="" id="apellidos" class="form-control" placeholder="Ingrese sus apellidos" required>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="direccion" class="col-form-label">Dirección:</label>
                                <input type="text" name="direccion" value="" id="direccion" class="form-control" placeholder="Ingrese su direccion" required>
                            </div>
                            <div class="form-group col-md-3">
                                <label for="celular" class="col-form-label">Celular:</label>
                                <input type="number" name="celular" value="" id="celular" class="form-control" placeholder="0xxxxxxxxx" required>
                            </div>
                            <div class="form-group col-md-3">
                                <label for="genero" class="col-form-label">Género</label>
                                <select class="form-control" id="genero" name="genero">
                                    <option selected>ELEGIR</option>
                                    <option>MASCULINO</option>
                                    <option>FEMENINO</option>
                                    <option>OTRO</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="correo" class="col-form-label">Correo:</label>
                            <input type="text" name="correo" value="" id="correo" class="form-control"  placeholder="email@example.com" required>
                        </div>
                        <div class="form-group">
                            <label for="password" class="col-form-label">Contraseña:</label>
                            <div class="input-group">
                                <input ID="password" name="password" type="Password" Class="form-control" minlength="6" maxlength="15" aria-describedby="passwordHelpBlock" placeholder="********">
                                <div class="input-group-append">
                                    <button id="show_password" class="btn btn-primary" type="button"> <span class="fa fa-eye-slash icon"></span> </button>
                                </div>
                            </div>
                            <small id="passwordHelpBlock" class="form-text text-muted">
                                Debe tener entre 6-15 caracteres de largo.
                            </small>
                        </div>
                        <div class="form-group" style="display: grid">
                            <button type="submit" id="registrar" class="btn btn-primary">Registrarse</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <SCript src="../js/jquery.js"></SCript>
        <SCript src="../js/registro_user.js"></SCript>
        <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    </body>
</html>
