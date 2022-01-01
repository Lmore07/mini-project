<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="../css/inicio_ses.css" />
        <link rel="stylesheet" href="../css/index.css" />
        <style>
            #texto{
                color: white;
                font-size: 3vw;
            }
        </style>
    </head>
    <body>
        <!--Barra de navegación superior-->
        <div id="barra_superior" class="container-fluid">
            <header id="encabezado">
                <nav class="navbar navbar-expand-lg navbar-dark bg-danger fixed-top">
                    <a class="navbar-brand" href="index.jsp"><img src="../imagenes/logo.png" alt="Logo"
                                                                   class="d-inline-block align-text-top img-fluid" href="index.html"></a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="collapsibleNavbar">
                        <ul class="navbar-nav mr-auto">
                            <li class="nav-item " id="log">
                                <a class="nav-link" href="login.jsp" >Iniciar sesión </a>
                            </li>
                        </ul>
                    </div>
                </nav>
            </header>
        </div>
        <br><br>
        <br><br>
        <br><br>
        <!--Actividades-->
        <div class="row justify-content-center">
            
            <div class="jumbotron col-8 justify-content-center" style="background-color: black;height: 500">
                <h1 class="display-4" style="text-align: center; color: white;">¡BIENVENIDO!</h1>
                <p class="lead" style="text-align: center;color: white;">"¡Pon a prueba tu conocimiento y juega ahora!"</p>
                <hr class="my-4">
                <a class="btn btn-outline-danger btn-lg" style="display: grid" href="login.jsp" role="button">JUGAR</a>
            </div>
        </div>
        <script src="../js/jquery.js"></script>
        <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <script src="../js/bootstrap.js"></script>
        <script src="../js/log.js"></script>
    </body>
</html>