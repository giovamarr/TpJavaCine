package data;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Reserva;
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
				reserva.setFechaCompra(rs.getDate("fechaCompra"));
				reserva.setHoraCompra(rs.getInt("horaCompra"));
				reserva.setIdReserva(rs.getInt("idReserva"));
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
		Reserva reserva = new Reserva();
		String consulta = "select * from reserva where idReserva=?";		
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			pst = getConn().prepareStatement(consulta);
			pst.setInt(1, id);
			rs=pst.executeQuery();	
			if(rs.next()) 
		{
				reserva.setFechaCompra(rs.getDate("fechaCompra"));
				reserva.setHoraCompra(rs.getInt("horaCompra"));
				reserva.setIdReserva(rs.getInt("idReserva"));
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
		
		return reserva;
		
	}
	

	public void Delete(Reserva res) {
		
		
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			String consulta = "DELETE FROM reserva where idReserva==?";
			pst =Conexion.getInstancia().getConn().prepareStatement(consulta);	
			pst.setInt(1, res.getIdReserva());
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
	
	

public void Update(Reserva res) {
		/*
				funcion.setIdFuncion(rs.getInt("idFuncion"));
				funcion.setDiaFuncion(rs.getDate("diafuncion"));
				funcion.setHoraFuncion(rs.getInt("horaFuncion"));*/
		
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			String consulta = "Update funcion set fechaCompra=?,horaCompra=? where idReserva==?";

			pst =Conexion.getInstancia().getConn().prepareStatement(consulta);	
			//pst.setDate(1, res.getFechaCompra());
			pst.setInt(2,res.getHoraCompra());
			pst.setInt(3, res.getIdReserva());	

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
		String consulta = "insert into funcion (fechaCompra, horaCommpra)values (?,?)";
		pst = getConn().prepareStatement(consulta);	
		//pst.setDate(1, res.getFechaCompra());
		pst.setInt(2,res.getHoraCompra());	
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
