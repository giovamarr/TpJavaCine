package data;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//import entities.Butaca;
//import entities.Funcion;
import entities.Pelicula;
//import entities.Usuario;
import entities.Sala;

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
					a.setDescripcionPelicula(rs.getString("descripcionPelicula"));
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
	
	

	

public Pelicula GetOne(int id) {
	Pelicula sal=null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	try {
		stmt=Conexion.getInstancia().getConn().prepareStatement(
				"select * from peliculas where codPelicula=?"
				);
		stmt.setInt(1, id);		
		rs=stmt.executeQuery();
		if(rs!=null && rs.next()) {
			sal=new Pelicula();
			sal.setDescripcionPelicula(rs.getString("descripcionPelicula"));
			sal.setNombrePelicula(rs.getString("nombrePelicula"));
			sal.setCodPelicula(rs.getInt("codPelicula"));
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
	
	return sal;
}

	/*
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
				peli.setDescripcionPelicula(rs.getString("descripcionPelicula"));
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
	*/

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
				peli.setDescripcionPelicula(rs.getString("descripcionPelicula"));
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
	public boolean IngresarPelicula (int codPelicula,String descripcionPelicula, String nombrePelicula) {
		
		PreparedStatement pst = null;
		
		try 
		{
			String consulta = "insert into peliculas (codPelicula,descripcionPelicula,nombrePelicula) VALUES (?,?,?) ";
			pst = Conexion.getInstancia().getConn().prepareStatement(consulta);
			pst.setInt(1, codPelicula);
			pst.setString(2, descripcionPelicula);
			pst.setString(3, nombrePelicula);
		    pst.executeUpdate();
		    
		    if(pst.executeUpdate() ==1) {
				return true;
				}
			
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
		
		return false;
	}
	
	/*public void Delete(Pelicula peli) {
		
		
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
	}*/
	public void Delete(Pelicula per) {
	
		PreparedStatement stmt=null;
		try {
			stmt=Conexion.getInstancia().getConn().prepareStatement(
					"delete from peliculas where codPelicula=?"
					);
			stmt.setInt(1, per.getCodPelicula());
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
	public void Update(Pelicula peli) {
		PreparedStatement stmt= null;
		try {
			stmt=Conexion.getInstancia().getConn().
					prepareStatement(
							"update peliculas set descripcionPelicula=?,nombrePelicula=? where codPelicula=?");
			stmt.setString(1, peli.getDescripcionPelicula());
			stmt.setString(2, peli.getNombrePelicula());
			stmt.setInt(3, peli.getCodPelicula());
			stmt.executeUpdate();
		} catch (SQLException e) {
            e.printStackTrace();
		} finally {
            try {
                if(stmt!=null)stmt.close();
                Conexion.getInstancia().releaseConn();
            } catch (SQLException e) {
            	e.printStackTrace();
            }
		}
	}
	

	
	
	
	
		
	
  

}
