<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Time</title>
</head>
<body>
    <h1>Editar Time</h1>
    
    <form action="AtualizarTimeServlet" method="post">
        <input type="hidden" name="codigo" value="${time.codigo}">
        
        <label for="nome">Nome do Time:</label>
        <input type="text" id="nome" name="nome" value="${time.nome}" required><br><br>
        
        <label for="dataNascimento">Data de Nascimento:</label>
        <input type="date" id="dataNascimento" name="dataNascimento" value="${time.dataNascimento}"><br><br>
        
        <label for="tecnico">Técnico:</label>
        <input type="text" id="tecnico" name="tecnico" value="${time.tecnico}"><br><br>
        
        <input type="submit" value="Salvar Alterações">
    </form>
</body>
</html>
