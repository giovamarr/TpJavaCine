package logic;

import java.util.ArrayList;

import data.DataSala;
import data.DataUsuario;
import entities.Sala;
import entities.Usuario;

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

public Sala setSala (int nroSala) {
	
	DataSala dsala = new DataSala();
	Sala sala = new Sala();

    
	sala.setNroSala(nroSala);
	sala.setEstadoSala(1);
    

	dsala.IngresarSala(sala);
	
	return sala;
}
public void Insert (Sala s) {
	
	DataSala dsala = new DataSala();
	

	dsala.IngresarSala(s);
	
}

public void nuevaSala (int nroSala,int cantbutacas) {
	
	DataSala dsala = new DataSala();
	Sala sala = new Sala();

    
	sala.setNroSala(nroSala);
	sala.setEstadoSala(1);
    sala.setCantbutacas(cantbutacas);

	dsala.IngresarSala(sala);
	
	
}

		
}
