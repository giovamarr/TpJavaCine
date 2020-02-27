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
     <h3>Datos:</h3>
     Numero Sala<br><br>
   <input type="number" name= "nrosala"required/><br>
     Numero de la butaca <br><br>
       <input type="number" name="nroButaca"required/><br><br>
 Estado <br><br>
       <input type="number" name="estado"required/>
       0-Vacia  1-Ocupada<br><br>
       <input type="submit" value="Buscar">
       
         <br><br><br>
<a href="../butaca/menuButaca.jsp">Volver</a>
</form>

</body>
</html>


