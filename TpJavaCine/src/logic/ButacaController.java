package logic;

//import java.util.ArrayList;

import data.DataButaca;
//import entities.Butaca;
public class ButacaController {

	
	
	public void RegistraOcupado(int nrobut) {
		DataButaca DButaca=new DataButaca();
		DButaca.RegistraOcupado(nrobut);
	}
	
	/*public ArrayList<Butaca> ButacasVacias(){
		DataButaca DButaca=new DataButaca();
		ArrayList<Butaca> b=new ArrayList<Butaca>();
		return b=DButaca.ButacasVacias();	
		
	}*/

	public void VaciarButacas() {
		DataButaca DButaca=new DataButaca();
		DButaca.VaciarButacas();
	}
	
	
}
