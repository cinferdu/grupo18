package grafo;

public class Datos {
	private int cantColores;
	private int repeticion;
	
	public Datos(int cantColores, int repeticion) {
		this.cantColores = cantColores;
		this.repeticion = repeticion;
	}
	
	public Datos() {}
	
	public int getCantColores() {
		return cantColores;
	}
	public void setCantColores(int cantColores) {
		this.cantColores = cantColores;
	}
	public int getRepeticion() {
		return repeticion;
	}
	public void setRepeticion(int repeticion) {
		this.repeticion = repeticion;
	}

}
