package conexionBd;
import java.sql.*;

public class conexion {

	public static void main(String[] args) {
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/cine", "root", "lalo123");
		System.out.println("conexion exitosa");
		Statement stmt = conn.createStatement();
		ResultSet rs= stmt.executeQuery("select * from cine.salas");
		while(rs.next()) {
			System.out.println("Numero de Sala");
			System.out.println(rs.getString("nroSala"));
			
		}
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}

}}
