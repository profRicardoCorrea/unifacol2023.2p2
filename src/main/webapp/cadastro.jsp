<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cadastro de Time</title>
</head>
<body>
    <h1>Cadastro de Time</h1>
    
    <form action="AdicionarTimeServlet" method="post">
        <label for="nome">Nome do Time:</label>
        <input type="text" id="nome" name="nome" required><br><br>
        
        <label for="dataNascimento">Data de Nascimento:</label>
        <input type="date" id="dataNascimento" name="dataNascimento"><br><br>
        
        <label for="tecnico">Técnico:</label>
        <input type="text" id="tecnico" name="tecnico"><br><br>
        
        <input type="submit" value="Cadastrar">
    </form>
</body>
</html>