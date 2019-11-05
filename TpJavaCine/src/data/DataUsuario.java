package data;
import entities.Usuario;

import java.sql.*;

public class DataUsuario extends Conexion{
	

	public boolean registrarUsuario(String email, String apellidoUsuario, String nombreUsuario, String pass) {
	
		PreparedStatement pst = null;
		try {
			String consulta = "insert into usuarios (email, apellidoUsuario, nombreUsuario, pass)values (?,?,?,?)";
			pst =Conexion.getInstancia().getConn().prepareStatement(consulta);
			pst.setString(1, email);
			pst.setString(2, apellidoUsuario);
			pst.setString(3, nombreUsuario);
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
			pst = getConn().prepareStatement(consulta);
			pst.setString(1, email);
			pst.setString(2, pass);
			rs=pst.executeQuery();
			
			if(rs.absolute(1)) {return true;}
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
		return false;
	}

	public Usuario getByEmail(String email) {
		Usuario usuario = null;
		String consulta = "select * from usuarios where usuario=?";
		
		
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			pst = getConn().prepareStatement(consulta);
			pst.setString(1, email);
			rs=pst.executeQuery();	
			
			if(rs!=null && rs.next()) 
		{
				System.out.println("no existe usuario");;							
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
		
		return usuario;
	}
	
	
	/*public static void main(String[] args) {
		DataUsuario usu=  new DataUsuario();
		//System.out.println(usu.registrarUsuario("email", "apellido", "nombre", "pass"));
	
		System.out.println(usu.validarUsuario("email1", "pass1"));
		
		//SOLO FALTARIA Q EL FORMULARIO MANDE DATOS Y USAR ESTOS METODOS PARA REGISTRAR Y VALIDAR
		
	}*/
}
