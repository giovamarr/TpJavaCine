package logic;
import java.util.ArrayList;

import data.DataFuncion;
import entities.Funcion;

public class FuncionController {

public ArrayList<Funcion> GetAll(){ 
	DataFuncion DF=new DataFuncion();
	return DF.GetAll();
	
}

public Funcion GetOne(int id) {

	DataFuncion DF=new DataFuncion();
	return DF.GetOne(id);
}
public ArrayList<Funcion> GetAllforPeli(int a){ 
	DataFuncion DF=new DataFuncion();
	return DF.GetAllforPeli(a);

}



public void Delete(Funcion func) {
	DataFuncion DF=new DataFuncion();
	DF.Delete(func);
}


public void Update(Funcion func) {
	DataFuncion DF=new DataFuncion();
	DF.Update(func);
}


public void Insert(Funcion func) {
	DataFuncion DF=new DataFuncion();
	DF.Insert(func);
}

public ArrayList<Funcion> BuscaFunciones(int idpeli){
	DataFuncion DF=new DataFuncion();
	return DF.GetFuncionesxPeli(idpeli);
}


}