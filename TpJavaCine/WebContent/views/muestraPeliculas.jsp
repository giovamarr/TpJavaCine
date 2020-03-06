<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="java.util.ArrayList" %>
    <%@page import="entities.Funcion" %>
    
    <% ArrayList<Funcion> funciones = (ArrayList<Funcion>)request.getAttribute("funcionesparapeli"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
     <table>
     		<thead>
     				<tr>
     					<th>Id Funcion</th>
     					<th>Date</th>
     					<th>Time</th>
     				</tr>
     		</thead>
    
					<% for (int i=0; i<funciones.size(); i++) { %> 
					<tr>
						<% Funcion func = (Funcion)funciones.get(i); %>
						<td> <%=func.getIdFuncion() %></td>
						<td> <%=func.getDiaFuncion() %> </td>
						<td> <%=func.getHoraFuncion() %> </td>	
					</tr>
					<% } %>    
 		</table>
 		<form action="../../CrearReservaServlet" method="post">
 		<label>Ingrese id de funcion </label><br>
 		<input type ="number" name = "idfunc" /><br>
 		<input type ="submit" value ="Aceptar"/>
 		</form>
 		
 		
 		
 		
    <br><br><a href="menu.jsp">Volver</a>
</body>
</html>