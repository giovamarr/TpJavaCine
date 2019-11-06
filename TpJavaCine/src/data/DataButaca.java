package data;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Butaca;

public class DataButaca extends Conexion{
	
	
	public void RegistraOcupado(int nrobut) {
		
		PreparedStatement pst = null;
		try {
			String consulta = "Update butacas set estadoButaca=? where nrobutaca==?";
			pst = getConn().prepareStatement(consulta);
			/*0-Vacia  1-Ocupada*/
			pst.setInt(2, nrobut );
			pst.setInt(1,1);	
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
	
	
	
	

}
