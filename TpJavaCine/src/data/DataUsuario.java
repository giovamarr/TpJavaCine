package data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entities.Usuario;

public class DataUsuario {
	private static String driver="com.mysql.jdbc.Driver";

	public boolean registrarUsuario(String email, String apellido, String nombre, String pass,int idcli,String estad,String rol) {
	
		PreparedStatement pst = null;
		try {
			String consulta = "insert into usuarios (emailUsuario, apellidoUsuario, nombreUsuario, passUsuario,id_cliente,estado,rol)values (?,?,?,?,?,?,?)";
			pst =Conexion.getInstancia().getConn().prepareStatement(consulta);
			pst.setString(1, email);
			pst.setString(2, apellido);
			pst.setString(3, nombre);
			pst.setString(4, pass);
			pst.setInt(5, idcli);
			pst.setString(6, estad);
			pst.setString(7, rol);
			
			
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
		//PreparedStatement pst=null;
		ResultSet rs=null;
		boolean a=false;
		try {Class.forName(driver);
			String consulta="select * from usuarios where emailUsuario=" + "\""
					+ email + "\" and passUsuario=" + "\"" + pass + "\";";
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/cine", "root", "lalo123");
		
			Statement stmt = conn.createStatement();
			//pst = Conexion.getInstancia().getConn().prepareStatement(consulta);
			/*pst.setString(1, email);
			pst.setString(2, pass);*/
			//rs=pst.executeQuery();
			rs= stmt.executeQuery(consulta);

			
			if(rs.next()) {a= true;}
			
		}catch(Exception e) {
			System.err.println("Error "+e);
		}finally {
			
			/*
			//if(Conexion.getInstancia().getConn()!= null) Conexion.getInstancia().getConn().close();
			//if(pst!=null)pst.close();
			//if(rs!=null)
			
				*/
			}
		if(a) {return true;}else {return false;}
			
		
		
	}

	public Usuario getByEmail(String email) {
		Usuario usuario = null;
		
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			String consulta = "select * from usuarios where emailUsuario=?";
			pst = Conexion.getInstancia().getConn().prepareStatement(consulta);
			pst.setString(1, email);
			rs=pst.executeQuery();	
			
			if(rs!=null && rs.next()) 
		{
				usuario = new Usuario();	
				usuario.setIdUsuario(rs.getInt("idUsuario"));
				usuario.setEmail(rs.getString("emailUsuario"));
				usuario.setNombre(rs.getString("nombreUsuario"));
				usuario.setApellido(rs.getString("apellidoUsuario"));
				usuario.setPass(rs.getString("passUsuario"));
				usuario.setId_cliente(rs.getInt("id_cliente"));
				usuario.setEstado(rs.getString("estado"));
				usuario.setRol(rs.getString("rol"));
				
				
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

