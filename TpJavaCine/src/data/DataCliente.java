package data;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Cliente;
public class DataCliente extends Conexion{


public ArrayList<Cliente> GetAll(){ 
		
		ArrayList<Cliente> clientes=new ArrayList<Cliente>();
		String consulta = "select * from clientes";		
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			pst = getConn().prepareStatement(consulta);
			rs=pst.executeQuery();	
			
			while(rs.next()) 
		{			
				Cliente clien = new Cliente();
				clien.setDni(rs.getString("dni"));
				clien.setNroCliente(rs.getInt("idCliente"));
				clien.setTelefono(rs.getString("telefono"));
				clientes.add(clien);
										
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
		return clientes;
	}	
	
	
	public Cliente GetOne(int id) {
		Cliente clien = new Cliente();
		String consulta = "select * from clientes where nroCliente=?";		
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			pst = getConn().prepareStatement(consulta);
			pst.setInt(1, id);
			rs=pst.executeQuery();	
			if(rs.next()) 
		{
				clien.setDni(rs.getString("dni"));
				clien.setNroCliente(rs.getInt("idCliente"));
				clien.setTelefono(rs.getString("telefono"));
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
		
		return clien;
		
	}
	

	public void Delete(Cliente cli) {
		
		
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			String consulta = "DELETE FROM clientes where nroCliente==?";
			pst = getConn().prepareStatement(consulta);
			pst.setInt(1, cli.getNroCliente());
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
	
	

public void Update(Cliente cli) {
		
		
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			String consulta = "Update clientes set dni=?,telefono=? where nroCliente==?";
			pst = getConn().prepareStatement(consulta);
		
			pst.setString(1,cli.getDni());
			pst.setString(2, cli.getTelefono());

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
	

public void Insert(Cliente cli) {

	PreparedStatement pst = null;
	try {
		String consulta = "insert into cliente (dni, telefono)values (?,?)";
		pst =Conexion.getInstancia().getConn().prepareStatement(consulta);
	
		pst.setString(1,cli.getDni());
		pst.setString(2, cli.getTelefono());
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
