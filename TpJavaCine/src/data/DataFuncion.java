package data;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//import  java.sql.Date;

import entities.Funcion;
public class DataFuncion extends Conexion{

public ArrayList<Funcion> GetAll(){ 
		
		ArrayList<Funcion> funciones=new ArrayList<Funcion>();
		String consulta = "select * from funcion";		
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			pst = getConn().prepareStatement(consulta);
			rs=pst.executeQuery();	
			
			while(rs.next()) 
		{			
				Funcion funcion = new Funcion();
				funcion.setIdFuncion(rs.getInt("idFuncion"));
				funcion.setDiaFuncion(rs.getDate("diafuncion"));
				funcion.setHoraFuncion(rs.getInt("horaFuncion"));
				funciones.add(funcion);
										
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
		return funciones;
	}	
	
	
	public Funcion GetOne(int id) {
		Funcion funcion = new Funcion();
		String consulta = "select * from funcion where idFuncion=?";		
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			pst = getConn().prepareStatement(consulta);
			pst.setInt(1, id);
			rs=pst.executeQuery();	
			if(rs.next()) 
		{
				funcion.setIdFuncion(rs.getInt("idFuncion"));
				funcion.setDiaFuncion(rs.getDate("diafuncion"));
				funcion.setHoraFuncion(rs.getInt("horaFuncion"));
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
		
		return funcion;
		
	}
	

	public void Delete(Funcion func) {
		
		
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			String consulta = "DELETE FROM funcion where idFuncion==?";
			pst =Conexion.getInstancia().getConn().prepareStatement(consulta);	
			pst.setInt(1, func.getIdFuncion());
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
	
	

public void Update(Funcion func) {
		/*
				funcion.setIdFuncion(rs.getInt("idFuncion"));
				funcion.setDiaFuncion(rs.getDate("diafuncion"));
				funcion.setHoraFuncion(rs.getInt("horaFuncion"));*/
		
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			String consulta = "Update funcion set diaFuncion=?,horaFuncion=? where idFuncion==?";

			pst =Conexion.getInstancia().getConn().prepareStatement(consulta);	
			pst.setDate(1, func.getDiaFuncion());
			pst.setInt(2,func.getHoraFuncion());
			pst.setInt(3, func.getIdFuncion());	

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
	

public void Insert(Funcion func) {

	PreparedStatement pst = null;
	try {
		String consulta = "insert into funcion (diaFuncion, horaFuncion)values (?,?)";
		pst = getConn().prepareStatement(consulta);
		pst.setDate(1, func.getDiaFuncion());
		pst.setInt(2,func.getHoraFuncion());
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
