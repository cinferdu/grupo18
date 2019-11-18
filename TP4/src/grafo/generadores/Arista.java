package grafo.generadores;

public class Arista{

	private int origen;
	private int destino;
	
	public Arista(int origen, int destino) {
		
		this.origen = origen;
		this.destino = destino;
	}

	public int getOrigen() {
		return origen;
	}

	public int getDestino() {
		return destino;
	}
}
