<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Borrar Funcion</title>
</head>
<body>

<form action="../../FuncionServlet" method ="post">
  <input type="hidden" name="opcion" value="borrar">
     <h1>Ingrese el numero de la funcion que desea borrar:</h1>
       <input type="number" name="nrofuncion">
       <input type="submit" value="Buscar">
</form>

</body>
</html>