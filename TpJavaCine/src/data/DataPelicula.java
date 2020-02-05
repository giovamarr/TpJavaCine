package data;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//import entities.Butaca;
//import entities.Funcion;
import entities.Pelicula;
//import entities.Usuario;

public class DataPelicula extends Conexion{
	
	
	public ArrayList<Pelicula> GetAll(){ 
		
		ArrayList<Pelicula> peliculas=new ArrayList<Pelicula>();
		String consulta = "select * from peliculas";		
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			pst = getConn().prepareStatement(consulta);
			rs=pst.executeQuery();	
			
			while(rs.next()) 
		{			
					Pelicula a = new Pelicula();
					a.setCodPelicula(rs.getInt("codPelicula"));
					a.setDescPelicula(rs.getString("descripcionPelicula"));
					a.setNombrePelicula(rs.getString("nombrePelicula"));
					peliculas.add(a);
										
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
		return peliculas;
	}
	
	

	public boolean AgregarPeli(Pelicula peli) {
	
		PreparedStatement pst = null;
		try {
			String consulta = "insert into peliculas (codPelicula, descripcionPelicula, nombrePelicula)values (?,?,?)";
			pst =Conexion.getInstancia().getConn().prepareStatement(consulta);
			pst.setInt(1, peli.getCodPelicula());
			pst.setString(2, peli.getDescPelicula());
			pst.setString(3, peli.getNombrePelicula());
			
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
		
	
	
	public Pelicula GetOne(int id) {
		Pelicula peli = new Pelicula();
		String consulta = "select * from peliculas where codPelicula=?";		
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			pst = getConn().prepareStatement(consulta);
			pst.setInt(1, id);
			rs=pst.executeQuery();	
			if(rs.next()) 
		{
				peli.setCodPelicula(rs.getInt("codPelicula"));
				peli.setDescPelicula(rs.getString("descripcionPelicula"));
				peli.setNombrePelicula(rs.getString("nombrePelicula"));							
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
		
		return peli;
		
	}
	

	public Pelicula GetOne(String nombre) {
		Pelicula peli = new Pelicula();
		String consulta = "select * from peliculas where nombrePelicula=?";		
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			pst = getConn().prepareStatement(consulta);
			pst.setString(1, nombre);
			rs=pst.executeQuery();	
			if(rs.next()) 
		{
				peli.setCodPelicula(rs.getInt("codPelicula"));
				peli.setDescPelicula(rs.getString("descripcionPelicula"));
				peli.setNombrePelicula(rs.getString("nombrePelicula"));							
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
		
		return peli;
		
	}
	
	public void Delete(Pelicula peli) {
		
		
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			String consulta = "DELETE FROM peliculas where codPelicula==?";
			pst = getConn().prepareStatement(consulta);
			pst.setInt(1, peli.getCodPelicula());
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
	
public void Update(Pelicula peli) {
		
		/*peli.setCodPelicula(rs.getInt("codPelicula"));
				peli.setDescPelicula(rs.getString("descPelicula"));
				peli.setNombrePelicula(rs.getString("nombrePelicula"));*/
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			String consulta = "Update peliculas set descripcionPelicula=?,nombrePelicula=? where codPelicula==?";
			pst = getConn().prepareStatement(consulta);
			pst.setString(1,peli.getDescPelicula());
			pst.setString(2,peli.getNombrePelicula());
			pst.setInt(3, peli.getCodPelicula());
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

	
	
	
	
		
	
  

}
