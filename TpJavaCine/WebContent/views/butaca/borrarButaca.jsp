<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Borrar Butaca</title>
</head>
<body>

<form action="../../ButacaServlet" method ="post">
  <input type="hidden" name="opcion" value="borrar">
     <h1>Ingrese el numero de la butaca que desea borrar:</h1>
       <input type="number" name="nroButaca"required/>
       <input type="submit" value="Buscar">
       <br><br><br>
<a href="../butaca/menuButaca.jsp">Volver</a>
</form>

</body>
</html>