package entities;

import java.util.Date;

public class Funcion {
	private int idFuncion;
private int horaFuncion;    //hay que ver el tipo time que no se la liberia
private  java.sql.Date diaFuncion;
public int getIdFuncion() {
	return idFuncion;
}
public void setIdFuncion(int idFuncion) {
	this.idFuncion = idFuncion;
}

public int getHoraFuncion() {
	return horaFuncion;
}
public void setHoraFuncion(int horaFuncion) {
	this.horaFuncion = horaFuncion;
}
public java.sql.Date getDiaFuncion() {
	return diaFuncion;
}
public void setDiaFuncion( java.sql.Date diaFuncion) {
	this.diaFuncion = diaFuncion;
}
}