<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrarme</title>
</head>
<body>
<h1>Formulario de registro</h1>
 <form action="RegistroUsuario" method="post"><br>
    <label>Email</label>
    <input type="text" name="email"/><br><br>
    <label>Password</label>
    <input type="password" name="pass"/><br><br>
    <label>Nombre</label>
    <input type="text" name="nombre"/><br><br>
    <label>Apellido</label>
    <input type="text" name="apellido"/><br><br>

    
    <input type="submit" value="Registrarme"/>
    </form>
</body>
</html>
	