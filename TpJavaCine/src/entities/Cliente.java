package entities;

public class Cliente {
private int nroCliente;
private String dni;
private String telefono;


public String getTelefono() {
	return telefono;
}
public void setTelefono(String telefono) {
	this.telefono = telefono;
}
public int getNroCliente() {
	return nroCliente;
}
public void setNroCliente(int nroCliente) {
	this.nroCliente = nroCliente;
}
public String getDni() {
	return dni;
}
public void setDni(String dni) {
	this.dni = dni;
}
}