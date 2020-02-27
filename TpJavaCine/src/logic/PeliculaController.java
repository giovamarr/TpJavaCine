package logic;

import java.util.ArrayList;
import data.DataPelicula;

import entities.Pelicula;


public class PeliculaController {
	public ArrayList<Pelicula> GetAll(){ 
		DataPelicula dp=new DataPelicula();
		return dp.GetAll();
		
	}
	public Pelicula setPelicula (int codPelicula,String nombrePelicula, String descripcionPelicula) {
		
		DataPelicula dpelicula = new DataPelicula();
		Pelicula pelicula = new Pelicula();

	    
		pelicula.setCodPelicula(codPelicula);
		pelicula.setNombrePelicula(nombrePelicula);
		pelicula.setDescripcionPelicula(descripcionPelicula);
	    

		dpelicula.IngresarPelicula(codPelicula, nombrePelicula, descripcionPelicula);
		
		return pelicula;
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
