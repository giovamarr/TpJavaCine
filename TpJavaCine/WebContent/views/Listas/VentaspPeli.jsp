
<!DOCTYPE html>
<%@page import="java.sql.*" %>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
Connection con;
 String driver="com.mysql.jdbc.Driver";
 String host="localhost";
 String port="3306";
 String user="root";
 String password="lalo123";
 String db="cine";
 Class.forName(driver);
 con=DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+db, user, password);
PreparedStatement ps;
ResultSet rs;
ps=con.prepareStatement("select p.codPelicula,p.nombrePelicula,count(r.idReserva) from peliculas p inner join funcion f on f.id_codPelicula=p.codPelicula inner join reserva r on r.idFuncion=f.idFuncion group by 1");
rs=ps.executeQuery();
%>
<div>
<h2>Listado de ventas por película</h2>
<table>
<tr>
<th>Cod. Película</th>
<th>Nombre</th>
<th>Reserva</th>
</tr>
<%
while(rs.next()){
%>
<tr>
 <td>
 <%=rs.getInt("p.codPelicula")%></td>
<td><%=rs.getInt("p.nombrePelicula")%></td>		        
<td><%=rs.getInt("count(r.idReserva)")%></td>
</tr>
<% } %>
</table>


</div>

</body>
</html>