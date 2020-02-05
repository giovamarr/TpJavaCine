package logic;

import java.util.ArrayList;
import data.DataPelicula;

import entities.Pelicula;

public class PeliculaController {
	public ArrayList<Pelicula> GetAll(){ 
		DataPelicula dp=new DataPelicula();
		return dp.GetAll();
		
	}
	public boolean AgregarPeli(Pelicula peli) {
		DataPelicula dp=new DataPelicula();
		return dp.AgregarPeli(peli);
	}
	public Pelicula GetOne(int id) {
		DataPelicula dp=new DataPelicula();
		return dp.GetOne(id);
	}

	public void Delete(Pelicula peli) {
		DataPelicula dp=new DataPelicula();
		dp.Delete(peli);
	}
	
	public Pelicula GetOne(String nombre) {
		DataPelicula dp=new DataPelicula();
		return dp.GetOne(nombre);
	}

public void Update(Pelicula peli) {
	DataPelicula dp=new DataPelicula();
	dp.Update(peli);
}


}
