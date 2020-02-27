package logic;

import java.util.ArrayList;
import data.DataReserva;
import data.DataUsuario;
import entities.Reserva;
import entities.Usuario;

public class ReservaController {

public ArrayList<Reserva> GetAll(){
	DataReserva dr=new DataReserva();
return dr.GetAll();}

public Reserva GetOne(int id) {
	DataReserva dr=new DataReserva();
	return dr.GetOne(id);	
}


public void Delete(Reserva res) {
	DataReserva dr=new DataReserva();
	dr.Delete(res);
}

public void Update(Reserva res) {
	DataReserva dr=new DataReserva();
	dr.Update(res);
}

public void Insert(Reserva res) {
	DataReserva dr=new DataReserva();
	dr.Insert(res);
}

}
