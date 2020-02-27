<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Venta De Entradas</title>
</head>
<body>
 <h1>Venta de Entradas</h1>
    <form action="../ReservaServlet" method="post" ><br>
    <label>Que pelicula desea ver?</label>
    <input type="text" name="pelicula"required/><br><br>
        <input type="submit" value="Aceptar" />     
    </form>

</body>
</html>