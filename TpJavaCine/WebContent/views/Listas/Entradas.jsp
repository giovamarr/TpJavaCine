
<!DOCTYPE html>
<%@page import="java.sql.*" %>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Entradas por Funcion</title>
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
ps=con.prepareStatement("select f.idFuncion,count(r.idReserva) from funcion f inner join reserva r on r.idFuncion=f.idFuncion group by 1");
rs=ps.executeQuery();
%>
<div>
<h2>Entradas por Funcion</h2>
<table style='border-right-style: solid; border-bottom-color: #000000; letter-spacing: normal; vertical-align: super; border-left-color: #000000; font-size: 12px; line-height: normal; border-right-color: #000000; font-style: normal; border-top-style: solid; word-spacing: normal; border-left-style: solid; border-top-color: #000000; font-family: "Times New Roman", Serif; border-bottom-style: solid; border-top-width: thin; border-right-width: thin; border-left-width: thin; border-bottom-width: thin; text-align: left'>
<tr>
<th>Cod. Funcion</th>
<th>Cantidad de entradas</th>
</tr>
<%
while(rs.next()){
%>
<tr>
 <td>
 <%=rs.getInt("f.idFuncion")%></td>
<td><%=rs.getInt("count(r.idReserva)")%></td>	
</tr>
<% } %>
</table><br><br><a href="menu.jsp">Volver</a>


</div>

</body>
</html>