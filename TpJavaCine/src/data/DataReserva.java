package data;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Funcion;
import entities.Reserva;
import entities.Sala;
public class DataReserva extends Conexion{

public ArrayList<Reserva> GetAll(){ 
		
		ArrayList<Reserva> reservas=new ArrayList<Reserva>();
		String consulta = "select * from reserva";		
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			pst = getConn().prepareStatement(consulta);
			rs=pst.executeQuery();	
			
			while(rs.next()) 
		{			
				Reserva reserva = new Reserva();
				//reserva.setId_cliente(rs.getInt("id_cliente"));
				reserva.setFechaHoraCompra(rs.getString("fechaCompra"));
				reserva.setIdReserva(rs.getInt("idReserva"));
				reserva.setIdbutaca(rs.getInt("idbutaca"));
				reserva.setIdFuncion(rs.getInt("idFuncion"));
				reservas.add(reserva);										
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
		return reservas;
	}	
	
public Reserva GetOne(int id) {
	Reserva reserva=null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	try {
		stmt=Conexion.getInstancia().getConn().prepareStatement(
				"select * from reserva where idReserva=?"
				);
		stmt.setInt(1, id);		
		rs=stmt.executeQuery();
		if(rs!=null && rs.next()) {
			reserva=new Reserva();
			reserva.setFechaHoraCompra(rs.getString("fechaCompra"));
			reserva.setIdReserva(rs.getInt("idReserva"));
				reserva.setIdbutaca(rs.getInt("idbutaca"));
				reserva.setIdFuncion(rs.getInt("idFuncion"));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		try {
			if(rs!=null) {rs.close();}
			if(stmt!=null) {stmt.close();}
			Conexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	return reserva;
}
public void Delete(Reserva res) {
	PreparedStatement stmt=null;
	try {
		stmt=Conexion.getInstancia().getConn().prepareStatement("DELETE FROM reserva where idReserva=?");
		stmt.setInt(1, res.getIdReserva());
		stmt.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		try {
			if(stmt!=null) {stmt.close();}
			Conexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
	

	

public void Update(Reserva res) {
		/*
				funcion.setIdFuncion(rs.getInt("idFuncion"));
				funcion.setDiaFuncion(rs.getDate("diafuncion"));
				funcion.setHoraFuncion(rs.getInt("horaFuncion"));*/
		
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			String consulta = "Update funcion set fechaHoraCompra=?,,idUsuario=?,idButaca=?,idFuncion=? where idReserva==?";

			pst =Conexion.getInstancia().getConn().prepareStatement(consulta);	
			pst.setString(1, res.getFechaHoraCompra());
			//pst.setInt(3,res.getIdUsuario());
			pst.setInt(4,res.getIdbutaca());
			pst.setInt(5,res.getIdFuncion());
			
			pst.setInt(6, res.getIdReserva());
			

			pst.executeUpdate();
		
			
		}catch(Exception e) {
			System.err.println("Error "+e);
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
	}
	

public void Insert(Reserva res) {

	PreparedStatement pst = null;
	try {
	//	String consulta = "insert into reserva (fechaCompra,idbutaca,idFuncion)values (?,?,?)";
		pst = Conexion.getInstancia().getConn().prepareStatement( "insert into reserva (fechaCompra,idbutaca,idFuncion)values (?,?,?)");	
		pst.setString(1,res.getFechaHoraCompra());		
		//pst.setInt(3,res.getIdUsuario());		
		pst.setInt(2,res.getIdbutaca());	
		
		pst.setInt(3,res.getIdFuncion());
		pst.executeUpdate();
		
	}
	catch (Exception ex){
		System.out.println("error"+ ex);
	}finally {
		try {
			if(Conexion.getInstancia().getConn()!= null)Conexion.getInstancia().getConn().close();
			if(pst!= null)pst.close();
		}
		
		catch(Exception e) {
		System.out.println("error"+ e);
	}}
	
}

}
