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
	
	public ArrayList<Butaca> ButacasVacias(){
		DataButaca DButaca=new DataButaca();
		ArrayList<Butaca> b=new ArrayList<Butaca>();
		return b=DButaca.ButacasVacias();	
		
	}

	public void VaciarButacas() {
		DataButaca DButaca=new DataButaca();
		DButaca.VaciarButacas();
	}
	
	
}
