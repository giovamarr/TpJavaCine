package logic;

import entities.Tarjeta;
import data.DataTarjeta;

public class TarjetaController {
	public Tarjeta GetOne(int id) {
		DataTarjeta dt=new DataTarjeta();
		return dt.GetOne(id);
	}
	
}
