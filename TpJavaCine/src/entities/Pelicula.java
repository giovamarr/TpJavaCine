package entities;

public class Pelicula {
    private int codPelicula;
   private String nombrePelicula;
   private String descripcionPelicula;

public int getCodPelicula() {
	return codPelicula;
}
public void setCodPelicula(int codPelicula) {
	this.codPelicula = codPelicula;
}
public String getNombrePelicula() {
	return nombrePelicula;
}
public void setNombrePelicula(String nombrePelicula) {
	this.nombrePelicula = nombrePelicula;
}
public String getDescripcionPelicula() {
	return descripcionPelicula;
}
public void setDescripcionPelicula(String descPelicula) {
	this.descripcionPelicula = descPelicula;
}
}