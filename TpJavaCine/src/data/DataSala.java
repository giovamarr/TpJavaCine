package data;

import entities.Sala;
import java.sql.*;

public class DataSala {

	
	public void getAllSala(){
		Statement stmt=null;
		ResultSet rs=null;
		
		
		try {
			stmt= FactoryConexion.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select * from salas");
			if(rs!=null) {
				while(rs.next()) {
					Sala s=new Sala();
					s.setNroSala(rs.getInt("id"));
					//Sala.add(s);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}
}
