package entities;
public class Butaca {
private	int nroButaca;
private	int estadoButaca;/*0-Vacia  1-Ocupada*/
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
}