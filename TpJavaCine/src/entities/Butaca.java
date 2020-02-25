package entities;
public class Butaca {
private	int nroButaca;
private	int estadoButaca;/*0-Vacia  1-Ocupada 2-Reparacion*/
private	int id_sala;

public int getNroButaca() {
	return nroButaca;
}

public void setNroButaca(int nroButaca) {
	this.nroButaca = nroButaca;
}
public int getEstadoButaca() {
	return estadoButaca;
}
public void setEstadoButaca(int estadoButaca) {
	this.estadoButaca = estadoButaca;
}

public int getId_sala() {
	return id_sala;
}

public void setId_sala(int id_sala) {
	this.id_sala = id_sala;
}
}