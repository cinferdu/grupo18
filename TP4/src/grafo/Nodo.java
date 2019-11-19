package grafo;

public class Nodo  {
	private int numero;
	private int color;
	private int grado;
	
	public Nodo() {}

	public Nodo(int numero, int color) {
		super();
		this.numero = numero;
		this.color = color;
	}

	public void aumentarGrado(){
		this.setGrado(this.getGrado() + 1);
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public int getColor() {
		return color;
	}
	
	public void setColor(int color) {
		this.color = color;
	}
	
	public int getGrado() {
		return grado;
	}
	
	public void setGrado(int grado) {
		this.grado = grado;
	}
	
	@Override
	public String toString() {
		return "Nodo [numero=" + numero + ", color=" + color + "]";
	}
}
