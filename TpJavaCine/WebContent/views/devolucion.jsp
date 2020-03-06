<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Borrar Reserva</title>
</head>
<body>

<form action="../Devolucion" method ="post">
     <h1>Borrar Reserva</h1>	
     <label>Codigo de la Reserva</label>
       <input type="number" name="nrores"required/><br><br>       
       <input type="submit" value="Guardar">
        <br><br><br>
<a href="menu.jsp">Volver</a>
</form>
</body>
</html>