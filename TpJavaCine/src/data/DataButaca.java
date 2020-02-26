package data;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Butaca;
import entities.Pelicula;

public class DataButaca extends Conexion{
	
	
	public void RegistraOcupado(int nrobut, int sala) {
		
		PreparedStatement pst = null;
		try {
			String consulta = "Update butacas set estadoButaca=? where nrobutaca==?  and id_sala=?";
			pst = getConn().prepareStatement(consulta);
			/*0-Vacia  1-Ocupada*/
			pst.setInt(2, nrobut );
			pst.setInt(1,1);	
			pst.setInt(3,sala);	
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
	public void ActualizaEstado(int nrobut, int sala, int estado) {
		
		PreparedStatement pst = null;
		try {
			String consulta = "Update butacas set estadoButaca=? where nrobutaca==?  and id_sala=?";
			pst = getConn().prepareStatement(consulta);
			/*0-Vacia  1-Ocupada*/
			pst.setInt(2, nrobut );
			pst.setInt(1,estado);	
			pst.setInt(3,sala);	
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
	
	
	
	public ArrayList<Butaca> ButacasVacias(){
		
		ArrayList<Butaca> butacas=new ArrayList<Butaca>();
		String consulta = "select * from butacas where estadobutaca=0";		
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			pst = getConn().prepareStatement(consulta);
			rs=pst.executeQuery();	
			
			while(rs.next()) 
		{			
					Butaca a = new Butaca();
					a.setEstadoButaca(rs.getInt("estadobutaca"));
					a.setNroButaca(rs.getInt("nrobutaca"));
					a.setId_sala(rs.getInt("id_sala"));
					butacas.add(a);
										
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
		
		return butacas;
	}
	
	
	
	public void VaciarButacas() {
		PreparedStatement pst = null;
	try {
		String consulta = "Update butacas set estadoButaca=0 where estadoButaca==1";
		pst =Conexion.getInstancia().getConn().prepareStatement(consulta);		
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
	
	public Butaca GetOne(int nrobut, int sala) {
		Butaca but=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=Conexion.getInstancia().getConn().prepareStatement("SELECT * FROM butacas where nrobutaca==?  and id_sala=?");
			stmt.setInt(1, nrobut);
			stmt.setInt(2,sala);	
			rs = stmt.executeQuery();
			if(rs!=null && rs.next()) {
				but = new Butaca();
				but.setNroButaca(rs.getInt("nrobutaca"));
				but.setId_sala(rs.getInt("id_sala"));
				but.setEstadoButaca(rs.getInt("estadoButaca"));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				Conexion.getInstancia().releaseConn();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return but;
	}
	//Alta (de a una) de las butacas de una sala nueva (depsues lo manejamos con un for)
	public boolean AltaButacas(int id, int idsala) {
		PreparedStatement pst = null;
			
		try {
			String consulta = "insert into butacas (nrobutaca, estadoButaca, id_sala) VALUES (?,?,?)";
			pst = Conexion.getInstancia().getConn().prepareStatement(consulta);
			pst.setInt(1, id);
			pst.setInt(2, 0);
			pst.setInt(3, idsala);
		    pst.executeUpdate();
			
		    if(pst.executeUpdate() ==1) {
				return true;
				}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
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

	
	
	
	
	
}
