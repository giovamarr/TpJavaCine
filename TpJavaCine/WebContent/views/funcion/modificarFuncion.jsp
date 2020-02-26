<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modificar Funcion</title>
</head>
<body>

<form action="../../FuncionServlet" method ="post">
  <input type="hidden" name="opcion" value="modificar">
     <h1>Datos:</h1>
      <label>Nro de Funcion</label>
       <input type="number" name="nrofuncion" ><br><br>
        <label>Nro de Sala</label>
    <input type="number" name="nrosala"/><br><br>
    <label>Codigo de Pelicula</label>
    <input type="number" name="codpeli"/><br><br>
   <label>Hora de Funciom</label>
    <input type="number" name="horafuncion"/><br><br>
    <label>Dia de Funcion</label>
    <input type="date" name="diafuncion"/><br><br>
       <input type="submit" value="Buscar">
        <br><br><br>
<a href="../funcion/menufuncion.jsp">Volver</a>
</form>

</body>
</html>