package entities;

import java.util.*;
public class Reserva {
	
	private int idReserva;
private java.sql.Date fechaCompra;
private int horaCompra;  //hay que ver el tipo time que no se la liberia
private int id_cliente;
private int idbutaca;
private int idFuncion;



public Reserva() {};


public int getHoraCompra() {
	return horaCompra;
}
public void setHoraCompra(int horaCompra) {
	this.horaCompra = horaCompra;
}

public int getIdReserva() {
	return idReserva;
}
public void setIdReserva(int idReserva) {
	this.idReserva = idReserva;
}
public int getId_cliente() {
	return id_cliente;
}
public void setId_cliente(int id_cliente) {
	this.id_cliente = id_cliente;
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


public java.sql.Date getFechaCompra() {
	return fechaCompra;
}


public void setFechaCompra(java.sql.Date fechaCompra) {
	this.fechaCompra = fechaCompra;
}
}