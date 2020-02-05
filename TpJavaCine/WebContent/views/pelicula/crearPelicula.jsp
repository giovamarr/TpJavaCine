<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Crear Pelicula</title>
</head>
<body>

<form action="../../PeliculaServlet" method ="post">
   <input type="hidden" name="opcion" value="guardar">
     <h1>Nueva Pelicula</h1>
     <label>Nro de Pelicula</label>
       <input type="number" name="nropeli" ><br><br>
        <label>Nombre de la Pelicula</label>
       <input type="number" name="nombrepeli" ><br><br>
    <label>Descripcion</label>
   <input type="number" name="descpeli"/><br><br>
       <input type="submit" value="Guardar">
</form>

</body>
</html>