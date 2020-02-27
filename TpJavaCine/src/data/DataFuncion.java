package data;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//import  java.sql.Date;

import entities.Funcion;
import entities.Pelicula;
public class DataFuncion extends Conexion{

public ArrayList<Funcion> GetAll(){ 
		
		ArrayList<Funcion> funciones=new ArrayList<Funcion>();
		String consulta = "select * from funcion";		
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			pst = getConn().prepareStatement(consulta);
			rs=pst.executeQuery();	
			
			while(rs.next()) 
		{			
				Funcion funcion = new Funcion();
				funcion.setIdFuncion(rs.getInt("idFuncion"));
				funcion.setId_nrosala(rs.getInt("id_nrosala"));
				funcion.setId_codPelicula(rs.getInt("id_codPelicula"));
				funcion.setDiaFuncion(rs.getString("diaFuncion"));
				funcion.setHoraFuncion(rs.getInt("horaFuncion"));
				funciones.add(funcion);
										
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
		return funciones;
	}	
	
	

public Funcion GetOne(int id) {
	Funcion sal=null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	try {
		stmt=Conexion.getInstancia().getConn().prepareStatement(
				"select * from funcion where idFuncion=?"
				);
		stmt.setInt(1, id);		
		rs=stmt.executeQuery();
		if(rs!=null && rs.next()) {
			sal=new Funcion();
			sal.setIdFuncion(rs.getInt("idFuncion"));
			sal.setId_nrosala(rs.getInt("id_nrosala"));
			sal.setId_codPelicula(rs.getInt("id_codPelicula"));
			sal.setDiaFuncion(rs.getString("diaFuncion"));
			sal.setHoraFuncion(rs.getInt("horaFuncion"));
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



public ArrayList<Funcion> GetFuncionesxPeli(int idpeli){ 
	
	ArrayList<Funcion> funciones=new ArrayList<Funcion>();
	PreparedStatement stmt=null;
	ResultSet rs=null;
	String consulta = "select * from funcion where id_codPelicula = ? and diaFuncion >= current_date()";

	try {
		stmt = Conexion.getInstancia().getConn().prepareStatement(consulta);
		stmt.setInt(1, idpeli);
		rs=stmt.executeQuery();	
		
		while(rs.next()) 
	{			
			Funcion funcion = new Funcion();
			funcion.setIdFuncion(rs.getInt("idFuncion"));
			funcion.setId_nrosala(rs.getInt("id_nrosala"));
			funcion.setId_codPelicula(rs.getInt("id_codPelicula"));
			funcion.setDiaFuncion(rs.getString("diaFuncion"));
			funcion.setHoraFuncion(rs.getInt("horaFuncion"));
			funciones.add(funcion);
									
			}								
			
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		try {
			if(getConn()!= null) getConn().close();
			if(stmt!=null)stmt.close();
			if(rs!=null)rs.close();
			}
			catch(Exception e) {
				System.err.println("Error "+e);
			}
	}
	return funciones;
}
	

	public void Delete(Funcion per) {
		
		PreparedStatement stmt=null;
		try {
			stmt=Conexion.getInstancia().getConn().prepareStatement(
					"delete from funcion where idFuncion=?"
					);
			stmt.setInt(1, per.getIdFuncion());
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


public void Update(Funcion func) {
	
		
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			String consulta = "Update funcion set diaFuncion=?,horaFuncion=?,id_nrosala=?,id_codPelicula=? where idFuncion=?";

			pst =Conexion.getInstancia().getConn().prepareStatement(consulta);	
			pst.setString(1, func.getDiaFuncion());
			pst.setInt(2,func.getHoraFuncion());			
			pst.setInt(3,func.getId_nrosala());
			pst.setInt(4,func.getId_codPelicula());
			pst.setInt(5, func.getIdFuncion());	
			

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
public void Insert(Funcion func) {
	PreparedStatement stmt= null;
	ResultSet keyResultSet=null;
	try {
		stmt=Conexion.getInstancia().getConn().
				prepareStatement("insert into persona(diaFuncion, horaFuncion,id_nrosala,id_codPelicula,idFuncion) values(?,?,?,?,?)");
		//stmt.setDate(1, func.getDiaFuncion());
		stmt.setString(1, func.getDiaFuncion());
		stmt.setInt(2,func.getHoraFuncion());			
		stmt.setInt(3,func.getId_nrosala());
		stmt.setInt(4,func.getId_codPelicula());
		stmt.setInt(5,func.getIdFuncion());
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
        
	

	



/*
public void Insert(Funcion func) {

	PreparedStatement pst = null;
	try {
		String consulta = "insert into funcion (diaFuncion, horaFuncion,id_nrosala,id_codPelicula,idFuncion)values (?,?,?,?,?)";
		pst = getConn().prepareStatement(consulta);
		pst.setDate(1, func.getDiaFuncion());
		pst.setInt(2,func.getHoraFuncion());			
		pst.setInt(3,func.getId_nrosala());
		pst.setInt(4,func.getId_codPelicula());
		pst.setInt(4,func.getIdFuncion());
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
	
}*/



}

