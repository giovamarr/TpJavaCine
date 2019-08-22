package entities;

import java.util.Date;

public class Funcion {
private int horaFuncion;    //hay que ver el tipo time que no se la liberia
private Date diaFuncion;
public int getHoraFuncion() {
	return horaFuncion;
}
public void setHoraFuncion(int horaFuncion) {
	this.horaFuncion = horaFuncion;
}
public Date getDiaFuncion() {
	return diaFuncion;
}
public void setDiaFuncion(Date diaFuncion) {
	this.diaFuncion = diaFuncion;
}
}