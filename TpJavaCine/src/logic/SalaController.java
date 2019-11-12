package logic;

import java.util.ArrayList;

import data.DataSala;
import entities.Sala;

public class SalaController {
	
	public ArrayList<Sala> GetAllSalasDisp(){
		DataSala ds=new DataSala();
		return ds.GetAllSalasDisp();
	} 
	
	public ArrayList<Sala> GetAllSalasenMantenimiento(){
		DataSala ds=new DataSala();
		return ds.GetAllSalasenMantenimiento();
	}


	public Sala GetOne(int id) {
		DataSala ds=new DataSala();
		return ds.GetOne(id);
	}

public void SalaenMantenimiento(Sala sal) {
	DataSala ds=new DataSala();
	ds.SalaenMantenimiento(sal);}

public void PonerSalaDisp(Sala sal) {
	DataSala ds=new DataSala();
ds.PonerSalaDisp(sal);
}
		
}
