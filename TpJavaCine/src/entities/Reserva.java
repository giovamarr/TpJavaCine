package entities;

import java.util.*;
public class Reserva {
private Date fechaCompra;
private int horaCompra;  //hay que ver el tipo time que no se la liberia
public Date getFechaCompra() {
	return fechaCompra;
}
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
}