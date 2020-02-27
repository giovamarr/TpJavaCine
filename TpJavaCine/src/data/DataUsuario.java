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

	public boolean registrarUsuario(String email, String apellido, String nombre, String pass) {
	
		PreparedStatement pst = null;
		try {
			String consulta = "insert into usuarios (email, apellido, nombre, pass)values (?,?,?,?)";
			pst =Conexion.getInstancia().getConn().prepareStatement(consulta);
			pst.setString(1, email);
			pst.setString(2, apellido);
			pst.setString(3, nombre);
			pst.setString(4, pass);
			//pst.setInt(5, id);
			//pst.setInt(6, estado);
			//pst.setInt(7, rol);
			
			
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
		PreparedStatement stmt=null;
		ResultSet rs=null;
		boolean a=false;
		try {Class.forName(driver);
			String consulta="select * from usuarios where email=? and pass=?";
		
			//Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/cine", "root", "lalo123");
			
			stmt=Conexion.getInstancia().getConn().prepareStatement(
					"select * from usuarios where email=? and pass=?");
					
			//Statement stmt = conn.createStatement();
			//stmt = Conexion.getInstancia().getConn().prepareStatement(consulta);
			stmt.setString(1, email);
			stmt.setString(2, pass);
			rs=stmt.executeQuery();
			rs= stmt.executeQuery(consulta);

			
			if(rs.next()) {a= true;}
			
		}catch(Exception e) {
			System.err.println("Error "+e);
		}finally {
			
			
			//if(Conexion.getInstancia().getConn()!= null) Conexion.getInstancia().getConn().close();
			//if(pst!=null)pst.close();
			//if(rs!=null)
			
			
			}
		if(a) {return true;}else {return false;}
			
		
		
	}

	public Usuario getByEmail(String email) {
		Usuario usuario = null;
		
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			String consulta = "select * from usuarios where email=?";
			pst = Conexion.getInstancia().getConn().prepareStatement(consulta);
			pst.setString(1, email);
			rs=pst.executeQuery();	
			
			if(rs!=null && rs.next()) 
		{
				usuario = new Usuario();	
			//	usuario.setId(rs.getInt("id"));
				usuario.setEmail(rs.getString("email"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setApellido(rs.getString("apellido"));
				usuario.setPass(rs.getString("pass"));
				usuario.setId_cliente(rs.getInt("id"));
				//usuario.setEstado(rs.getString("estado"));
			//	usuario.setRol(rs.getString("rol"));
				
				
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
			usuario.setPass(rs.getString("pass"));
			usuario.setNombre(rs.getString("nombre"));
			usuario.setApellido(rs.getString("apellido"));
			usuario.setRol(rs.getString("rol"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usuario;
		
	}
	*/
	public void IngresarUsuario (Usuario usu) {
		
		PreparedStatement pst = null;
		
		try 
		{
			String consulta = "insert into usuarios (email,pass,nombre, apellido) VALUES (?,?,?,?) ";
			pst = Conexion.getInstancia().getConn().prepareStatement(consulta);
			pst.setString(1, usu.getEmail());
			pst.setString(2, usu.getPass());
			pst.setString(3, usu.getNombre());
			pst.setString(4, usu.getApellido());
			//pst.setString(5, "cliente");
			//pst.setString(6, "activo");
			
		    pst.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(Conexion.getInstancia().getConn()!= null) Conexion.getInstancia().getConn().close();
				if(pst!=null)pst.close();
				}
				catch(Exception e) {
					System.err.println("Error "+e);
				}
		}
		
		
	}

	}

