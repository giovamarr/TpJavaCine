package entities;


import java.util.*;

public class Tarjeta {
private int idTarjeta;
private String empresa;
private Date fechaVto;
private int id_cliente;


public int getIdTarjeta() {
return idTarjeta;
}
public void setIdTarjeta(int idTarjeta) {
this.idTarjeta = idTarjeta;
}
public String getEmpresa() {
return empresa;
}
public void setEmpresa(String empresa) {
this.empresa = empresa;
}
public Date getFechaVto() {
return fechaVto;
}
public void setFechaVto(Date fechaVto) {
this.fechaVto = fechaVto;
}
public int getId_cliente() {
	return id_cliente;
}
public void setId_cliente(int id_cliente) {
	this.id_cliente = id_cliente;
}


}