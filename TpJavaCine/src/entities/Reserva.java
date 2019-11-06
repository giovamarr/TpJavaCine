package entities;

import java.util.*;
public class Reserva {
	private int idReserva;
private Date fechaCompra;
private int horaCompra;  //hay que ver el tipo time que no se la liberia
public Date getFechaCompra() {
	return fechaCompra;
}
public Reserva() {};
public Reserva(Date fechaCompra, int horaCompra) {
	super();
	this.fechaCompra = fechaCompra;
	this.horaCompra = horaCompra;
}
public void setFechaCompra(Date fechaCompra) {
	this.fechaCompra = fechaCompra;
}
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
}