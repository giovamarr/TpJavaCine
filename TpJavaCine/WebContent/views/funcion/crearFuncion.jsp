<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Crear Funcion</title>
</head>
<body>

<form action="../../FuncionServlet" method ="post">
   <input type="hidden" name="opcion" value="guardar">
     <h1>Nueva Funcion</h1>
     <label>Nro de Funcion</label>
       <input type="number" name="nrofuncion" ><br><br>
        <label>Nro de Sala</label>
    <input type="text" name="nrosala"/><br><br>
    <label>Codigo de Pelicula</label>
    <input type="text" name="codpeli"/><br><br>
   <label>Hora de Funciom</label>
    <input type="time" name="horafuncion"/><br><br>
    <label>Dia de Funcion</label>
    <input type="date" name="diafuncion"/><br><br>
       <input type="submit" value="Guardar">
</form>

</body>
</html>