<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Crear Sala</title>
</head>
<body>

<form action="../../SalaServlet" method ="post">
   <input type="hidden" name="opcion" value="guardar">
     <h1>Nueva Sala</h1>
     
      <label>Ingrese el numero de la Sala a crear:</label>
       <input type="number" name="nroSala"required/><br><br>
       <input type="submit" value="Aceptar">
        <br><br><br>
        
<a href="../sala/menuSala.jsp">Volver</a>
</form>

</body>
</html>  