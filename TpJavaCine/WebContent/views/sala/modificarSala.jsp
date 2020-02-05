<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modificar Sala</title>
</head>
<body>

<form action="../../SalaServlet" method ="post">
  <input type="hidden" name="opcion" value="modificar">
     <h1>Ingrese el numero de la sala que desea editar:</h1>
       <input type="number" name="nroSala">
       <input type="submit" value="Buscar">
</form>

</body>
</html>