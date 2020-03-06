package entities;

//import java.util.*;
public class Reserva {
	
	private int idReserva;
private String fechaHoraCompra;  //hay que ver el tipo time que no se la liberia
private int idUsuario;
private int idbutaca;
private int idFuncion;



public Reserva() {};

public int getIdReserva() {
	return idReserva;
}
public void setIdReserva(int idReserva) {
	this.idReserva = idReserva;
}
public int getIdUsuario() {
	return idUsuario;
}
public void setId_cliente(int id) {
	this.idUsuario = id;
}
public int getIdbutaca() {
	return idbutaca;
}
public void setIdbutaca(int idbutaca) {
	this.idbutaca = idbutaca;
}
public int getIdFuncion() {
	return idFuncion;
}
public void setIdFuncion(int idFuncion) {
	this.idFuncion = idFuncion;
}
/*

public java.sql.Date getFechaHoraCompra() {
	return fechaHoraCompra;
}


public void setFechaHoraCompra(java.sql.Date fechaCompra) {
	this.fechaHoraCompra = fechaCompra;
}*/

public String getFechaHoraCompra() {
	return fechaHoraCompra;
}

public void setFechaHoraCompra(String fechaHoraCompra) {
	this.fechaHoraCompra = fechaHoraCompra;
}

}