package data;
import entities.Usuario;

import java.sql.*;

public class DataUsuario {
	

	public boolean registrarUsuario(String email, String apellido, String nombre, String pass) {
	
		PreparedStatement pst = null;
		try {
			String consulta = "insert into usuarios (email, apellido, nombre, pass)values (?,?,?,?)";
			pst =Conexion.getInstancia().getConn().prepareStatement(consulta);
			pst.setString(1, email);
			pst.setString(2, apellido);
			pst.setString(3, nombre);
			pst.setString(4, pass);
			if(pst.executeUpdate() ==1) {
				return true;
			}
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
		
	return false;
	}
	
	public boolean validarUsuario(String email, String pass) {
		PreparedStatement pst=null;
		ResultSet rs=null;
		
		try {
			String consulta="select * from usuarios where email=? and pass=?";
			pst = Conexion.getInstancia().getConn().prepareStatement(consulta);
			pst.setString(1, email);
			pst.setString(2, pass);
			rs=pst.executeQuery();
			
			if(rs.absolute(1)) {return true;}
		}catch(Exception e) {
			System.err.println("Error "+e);
		}finally {
			try {
			if(Conexion.getInstancia().getConn()!= null) Conexion.getInstancia().getConn().close();
			if(pst!=null)pst.close();
			if(rs!=null)rs.close();
			}
			catch(Exception e) {
				System.err.println("Error "+e);
			}
		}
		return false;
	}

	public Usuario getByEmail(String email) {
		Usuario usuario = null;
		
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			String consulta = "select email,nombre,apellido,pass from usuarios where email=?";
			pst = Conexion.getInstancia().getConn().prepareStatement(consulta);
			pst.setString(1, email);
			rs=pst.executeQuery();	
			
			if(rs!=null && rs.next()) 
		{
				usuario = new Usuario();	
				usuario.setEmail(rs.getString("email"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setApellido(rs.getString("apellido"));
				usuario.setPass(rs.getString("pass"));
				
				
		}else {	System.out.println("no existe usuario");	}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(Conexion.getInstancia().getConn()!= null) Conexion.getInstancia().getConn().close();
				if(pst!=null)pst.close();
				if(rs!=null)rs.close();
				}
				catch(Exception e) {
					System.err.println("Error "+e);
				}
		}
		
		return usuario;
	}
		
	
	/*private Usuario setUsuario(ResultSet rs)
	{
		Usuario usuario = new Usuario();
		try {
			usuario.setEmail(rs.getString("email"));
			usuario.setNombre(rs.getString("nombre"));
			usuario.setApellido(rs.getString("apellido"));
			usuario.setRol(rs.getString("rol"));
			usuario.setPass(rs.getString("pass"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usuario;
		
	}*/
	
	

	}

