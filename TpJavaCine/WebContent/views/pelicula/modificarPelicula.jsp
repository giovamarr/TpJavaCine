<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modificar Pelicula</title>
</head>
<body>

<form action="../../PeliculaServlet" method ="post">
  <input type="hidden" name="opcion" value="modificar">
     <h1>Datos:</h1>
      <label>Codigo</label>
       <input type="number" name="codPelicula"><br><br>
       <label>Nombre</label>
    <input type="text" name="nombrePelicula"/><br><br>
    <label>Descripcion</label>
    <input type="text" name="descripcionPelicula"/><br><br>
    <input type="submit" name="button" value="Aceptar">
       
        <br><br><br>
<a href="../pelicula/menuPelicula.jsp">Volver</a>
 
	</form>
	
	
</body>
</html>
