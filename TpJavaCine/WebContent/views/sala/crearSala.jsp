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
     
      <label>Nro de Sala</label>
       <input type="number" name="nroSala" ><br><br>
    <label>Cantidad de Butacas</label>
   <input type="number" name="nrobutacas"/><br><br>
       <input type="submit" value="Guardar">
        <br><br><br>
<a href="../sala/menuSala.jsp">Volver</a>
</form>

</body>
</html>  