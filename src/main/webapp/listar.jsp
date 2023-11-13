<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Times</title>
</head>
<body>
    <h1>Lista de Times</h1>
    
    <table border="1">
        <tr>
            <th>Código</th>
            <th>Nome</th>
            <th>Data de Nascimento</th>
            <th>Técnico</th>
        </tr>
        <c:forEach var="time" items="${listaTimes}">
            <tr>
                <td>${time.codigo}</td>
                <td>${time.nome}</td>
                <td>${time.dataNascimento}</td>
                <td>${time.tecnico}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
