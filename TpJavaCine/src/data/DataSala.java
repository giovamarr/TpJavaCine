package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//import entities.Reserva;
import entities.Sala;
//import entities.Usuario;

//import entities.Sala;
public class DataSala extends Conexion{

public ArrayList<Sala> GetAllSalasDisp(){ 
		
		ArrayList<Sala> salas=new ArrayList<Sala>();
		String consulta = "select * from salas whete estadoSala=1";		
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			pst = getConn().prepareStatement(consulta);
			rs=pst.executeQuery();	
			
			while(rs.next()) 
		{			
				Sala sal = new Sala();

				sal.setNroSala(rs.getInt("nroSala"));
				sal.setEstadoSala(rs.getInt("estadoSala"));
				salas.add(sal);										
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
		return salas;
	}	
	

public ArrayList<Sala> GetAllSalasenMantenimiento(){ 
		
		ArrayList<Sala> salas=new ArrayList<Sala>();
		String consulta = "select * from salas whete estadoSala=0";		
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			pst = getConn().prepareStatement(consulta);
			rs=pst.executeQuery();	
			
			while(rs.next()) 
		{			
				Sala sal = new Sala();

				sal.setNroSala(rs.getInt("nroSala"));
				sal.setEstadoSala(rs.getInt("estadoSala"));
				salas.add(sal);										
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
		return salas;
	}	

/*
	public Sala GetOne(int id) {
	
		Sala sal = new Sala();
		String consulta = "select * from salas where nroSala=?";		
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			pst = getConn().prepareStatement(consulta);
			pst.setInt(1, id);
			rs=pst.executeQuery();	
			if(rs!=null && rs.next()) 
		{
				sal.setNroSala(rs.getInt("nroSala"));
				sal.setEstadoSala(rs.getInt("estadoSala"));
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
		
		return sal;
		
	}*/
public Sala GetOne(int id) {
	Sala sal=null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	try {
		stmt=Conexion.getInstancia().getConn().prepareStatement(
				"select * from salas where nroSala=?"
				);
		stmt.setInt(1, id);		
		rs=stmt.executeQuery();
		if(rs!=null && rs.next()) {
			sal=new Sala();
			sal.setEstadoSala(rs.getInt("estadoSala"));
			sal.setNroSala(rs.getInt("nroSala"));
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
public void SalaenMantenimiento(Sala sal) {
		
		
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			String consulta = "Update salas set estadoSala=? where nroSala=?";

			pst =Conexion.getInstancia().getConn().prepareStatement(consulta);	
			pst.setInt(1,0);
			pst.setInt(3,sal.getNroSala());
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
public void SalaenMantenimiento(Sala sal) {
	PreparedStatement stmt= null;
	
	try {
		stmt=Conexion.getInstancia().getConn().
				prepareStatement(
					"Update salas set estadoSala=? where nroSala=?");
		
		stmt.setInt(1, 0);
		stmt.setInt(2, sal.getNroSala());
		stmt.executeUpdate();        

		
	}  catch (SQLException e) {
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

public void upd(Sala sal) {
	PreparedStatement stmt= null;
	
	try {
		stmt=Conexion.getInstancia().getConn().
				prepareStatement(
					"Update salas set estadoSala=? where nroSala=?");
		
		stmt.setInt(1, sal.getEstadoSala());
		stmt.setInt(2, sal.getNroSala());
		stmt.executeUpdate();        

		
	}  catch (SQLException e) {
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

public void PonerSalaDisp(Sala sal) {
	
PreparedStatement stmt= null;
	
	try {
		stmt=Conexion.getInstancia().getConn().
				prepareStatement(
					"Update salas set estadoSala=? where nroSala=?");
		
		stmt.setInt(1, 1);
		stmt.setInt(2, sal.getNroSala());
		stmt.executeUpdate();        

		
	}  catch (SQLException e) {
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

public void Delete(Sala per) {
	PreparedStatement stmt=null;
	try {
		stmt=Conexion.getInstancia().getConn().prepareStatement(
				"delete from salas where nroSala=?"
				);
		stmt.setInt(1, per.getNroSala());
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

public boolean IngresarSala (int nroSala) {
	
	PreparedStatement pst = null;
	
	try 
	{
		String consulta = "insert into salas (nroSala,estadoSala) VALUES (?,?) ";
		pst = Conexion.getInstancia().getConn().prepareStatement(consulta);
		pst.setInt(1, nroSala);
		pst.setInt(2, 1);
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

}
