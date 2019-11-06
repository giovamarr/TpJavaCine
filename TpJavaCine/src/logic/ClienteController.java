package logic;
import java.util.ArrayList;

import data.DataCliente;
import entities.Cliente;
public class ClienteController {

	public ArrayList<Cliente> GetAll(){

		DataCliente DCliente=new DataCliente();
		return DCliente.GetAll() ;}
	
	public Cliente GetOne(int id) { 

		DataCliente DCliente=new DataCliente();
		return  DCliente.GetOne(id);
	}
	public void Delete(Cliente cli) {

		DataCliente DCliente=new DataCliente();
		DCliente.Delete(cli);
		
	}
	public void Update(Cliente cli) {
		DataCliente DCliente=new DataCliente();
		DCliente.Update(cli);
	}

public void Insert(Cliente cli) {
	DataCliente DCliente=new DataCliente();
	DCliente.Insert(cli);
	
}
	
	
	
	}
	
	
	

