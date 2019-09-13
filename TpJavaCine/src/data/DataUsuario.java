package data;

import java.sql.*;
import entities.*;

public class DataUsuario {
	

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
	
	
	public static void main(String[] args) {
		DataUsuario usu=  new DataUsuario();
		System.out.println(usu.registrarUsuario("email", "apellido", "nombre", "pass"));
	}
}
