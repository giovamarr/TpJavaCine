package data;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entities.Tarjeta;
public class DataTarjeta extends Conexion{


	public Tarjeta GetOne(int id) {
		Tarjeta tarj = new Tarjeta();
		String consulta = "select * from tarjetas where idTarjeta=?";		
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			pst = getConn().prepareStatement(consulta);
			pst.setInt(1, id);
			rs=pst.executeQuery();	
			if(rs.next()) 
		{
				tarj.setIdTarjeta(rs.getInt("idTarjeta"));
				tarj.setEmpresa(rs.getString("empresa"));
				tarj.setFechaVto(rs.getDate("fechaVto"));
				tarj.setId_cliente(rs.getInt("id_cliente"));
		}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(getConn()!= null) getConn().close();
				if(pst!=null)pst.close();
				if(rs!=null)rs.close();
				}
				catch(Exception e) {
					System.err.println("Error "+e);
				}
		}
		
		return tarj;
		
	}
}
