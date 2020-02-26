<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Datos Pelicula</title>
</head>
<body>
<h1>Datos</h1>
 <form action="../../ModPelicula" method ="post"><br>
   
    <label>Nombre</label>
    <input type="text" name="nombrepeli"/><br><br>
    <label>Descripcion</label>
    <input type="text" name="descpeli"/><br><br>

    
    <input type="submit" value="Aceptar"/>
     <br><br><br>
<a href="../pelicula/menuPelicula.jsp">Volver</a>
    </form>
</body>
</html>
	