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
     <h1>Datos:</h1>
     Numero de Sala<br><br>
       <input type="number" name="nroSala"><br><br>
       Estado<br><br>
       <input type="number" name="estado">(0-En Mantenimiento  1-Disponible)
       <br><br>
       <input type="submit" value="Aceptar">
</form>
 <br><br><br>
<a href="../sala/menuSala.jsp">Volver</a>

</body>
</html>