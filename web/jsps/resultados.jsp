<%-- 
    Document   : resultados
    Created on : 31-dic-2021, 11:36:54
    Author     : luism
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MIS RESULTADOS</title>
        <link rel="stylesheet" href="../css/form.css">
        <style>
            table td:nth-child(1) {
                width: 100px;
            }
            table td:nth-child(2) {
                width: 100px;
            }
        </style>
    </head>
    <body>
        <div id="barra_superior" class="container-fluid">
            <header id="encabezado">
                <nav class="navbar navbar-expand-lg navbar-dark bg-danger fixed-top">
                    <a class="navbar-brand" href="index.jsp"><img src="../imagenes/logo.png" alt="Logo"
                                                                   class="d-inline-block align-text-top img-fluid" href="index.html"></a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                </nav>
            </header>
        </div></br></br>
        <form action="/mini-project/resultados" method="POST">        
            </br></br>
            <div class="mb-4 ml-3 pl-4 col-5 justify-content-center" id="bb">
                <button type="submit" id="CONSULTA" name="CONSULTA" class="btn btn-primary">CONSULTAR</button>
            </div </br>
            <div class="table-responsive ml-3 pl-4 col-5 justify-content-between">
                <sql:setDataSource
                    var="db" 
                    driver="org.postgresql.Driver"
                    url="jdbc:postgresql://localhost:5432/miniproject"
                    user="postgres"
                    password="12345"
                    />
                <sql:query var="result" dataSource="${db}">
                    SELECT fecha,puntos FROM resultados where id_user= <%= request.getParameter("id_user")%>
                </sql:query>
                <table border="2">
                    <!-- column headers -->
                    <tr class="bg-warning">
                        <th scope="col">Fecha</th>
                        <th>Puntos</th>
                    </tr>

                    <!-- column data -->
                    <c:forEach var="row" items="${result.rows}">
                        <tr class="table-info">
                            <td><c:out value="${row.fecha}"/></td>
                            <td><c:out value="${row.puntos}"/></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </form>   
        <SCript src="../js/jquery.js"></SCript>
        <SCript src="../js/bootstrap.js"></SCript>
    </body>
</html>
