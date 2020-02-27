<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="java.util.ArrayList" %>
    <%@page import="entities.Funcion" %>
    
    <% ArrayList funciones = (ArrayList)request.getAttribute("funcionesparapeli"); %>
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
     					<th>Date</th>
     					<th>Time</th>
     				</tr>
     		</thead>
    
					<% for (int i=0; i<funciones.size(); i++) { %>
					<tr>
						<% Funcion func = (Funcion)funciones.get(i); %>
						<td>
							<%func.getDiaFuncion(); %>
						</td>
						<td>
							<%func.getHoraFuncion(); %>
						</td>	
					</tr>
					<% } %>    
 		</table>
    
    
</body>
</html>