package entities;

//import java.util.Date;

public class Funcion {
	private int	 idFuncion;
	private int	 id_nrosala;
	private int id_codPelicula;
private int horaFuncion;    //hay que ver el tipo time que no se la liberia
private  String diaFuncion;


public int getHoraFuncion() {
	return horaFuncion;
}
public void setHoraFuncion(int horaFuncion) {
	this.horaFuncion = horaFuncion;
}
public String getDiaFuncion() {
	return diaFuncion;
}
public void setDiaFuncion( String a) {
	this.diaFuncion = a;
}
public int getId_nrosala() {
	return id_nrosala;
}
public void setId_nrosala(int id_nrosala) {
	this.id_nrosala = id_nrosala;
}
public int getId_codPelicula() {
	return id_codPelicula;
}
public void setId_codPelicula(int id_codPelicula) {
	this.id_codPelicula = id_codPelicula;
}
public int getIdFuncion() {
	return idFuncion;
}
public void setIdFuncion(int idFuncion) {
	this.idFuncion = idFuncion;
}
}