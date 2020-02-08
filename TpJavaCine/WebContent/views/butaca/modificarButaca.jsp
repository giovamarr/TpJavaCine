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
     <h1>Ingrese el numero de la butaca que desea editar:</h1>
       <input type="number" name="nroButaca">
       <input type="submit" value="Buscar">
       
         <br><br><br>
<a href="../butaca/menuButaca.jsp">Volver</a>
</form>

</body>
</html>


