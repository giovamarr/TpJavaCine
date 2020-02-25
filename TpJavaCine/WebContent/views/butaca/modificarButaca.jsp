<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modificar Butaca</title>
</head>
<body>

<form action="../../ButacaServlet" method ="post">
  <input type="hidden" name="opcion" value="modificar">
     <h3>Ingrese el numero de sala a la que le desea modificar una butaca:</h3>
   <input type="number" name= "nrosala"><br>
     <h3>Ingrese el numero de la butaca que desea editar:</h3>
       <input type="number" name="nroButaca"><br><br><br>
       <input type="submit" value="Buscar">
       
         <br><br><br>
<a href="../butaca/menuButaca.jsp">Volver</a>
</form>

</body>
</html>


