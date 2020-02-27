<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Iniciar sesion</title>
</head>
<body>
    <h1>Iniciar sesion</h1>
    <form action="InicioSesion" method="post" ><br>
    <label>Email</label>
    <input type="text" name="email"required/><br><br>
    <label>Password</label>
    <input type="password" name="pass"required/><br><br>
    <input type="submit" value="Iniciar sesion" />
    </form>
    
    Registrarme <a href="registro.jsp">click aca</a>
</body>
</html> 