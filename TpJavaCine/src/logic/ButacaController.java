package logic;

import java.util.ArrayList;

//import java.util.ArrayList;

import data.DataButaca;
import entities.Butaca;
//import entities.Butaca;
public class ButacaController {

	
	
	public void RegistraOcupado(int nrobut, int sala) {
		DataButaca DButaca=new DataButaca();
		DButaca.RegistraOcupado(nrobut,sala);
	}
	
	public ArrayList<Butaca> ButacasVacias(int a){
		DataButaca DButaca=new DataButaca();
		ArrayList<Butaca> b=new ArrayList<Butaca>();
		return b=DButaca.ButacasVacias(a);	
		
	}
	public void upd(Butaca sal) {
		DataButaca DButaca=new DataButaca();
		DButaca.upd(sal);;
	}
	public void VaciarButacas() {
		DataButaca DButaca=new DataButaca();
		DButaca.VaciarButacas();
	}
	public Butaca GetOne(int id, int idsala) {
		DataButaca DButaca=new DataButaca();
		Butaca but = new Butaca();
		but = DButaca.GetOne(id, idsala);
		return but;
	}
	public void Insert(int id, int idsala) {
		DataButaca DButaca=new DataButaca();
		DButaca.AltaButacas(id, idsala);
		}
		
	}

	
	

