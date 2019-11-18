package grafo;

import java.util.Arrays;

public class MatrizSimetrica {
	private boolean[] vector;
	private int orden;
	
	public MatrizSimetrica(int cantNodos){
		this.vector = new boolean[ordenVector(cantNodos)];
		this.orden = cantNodos;
	}

	public boolean getValor(int n1, int n2){
		if(n1 == n2)
			return false;
		
		if(n1 > n2)
			return this.vector[convertir(n2, n1)];
		
		return this.vector[convertir(n1, n2)];
	}
	
	public void setValor(int fila, int columna, boolean valor){
		if(fila == columna)
			return;
		
		if(fila > columna)
			this.vector[convertir(columna, fila)] = valor;
		
		this.vector[convertir(fila, columna)] = valor;
	}
	
	private int convertir(int n1, int n2) {
		return (int) (n1+(--n2*--n2)*0.5);
	}
	
	public int getOrden() {
		return orden;
	}

	private static int ordenVector(int cantNodos) {
		return cantNodos*(cantNodos-1)/2;
	}

	@Override
	public String toString() {
		return "MatrizSimetrica [vec=" + Arrays.toString(vector) + "]";
	}

	public int getSize() {
		// TODO Auto-generated method stub
		return vector.length;
	}
	
	
}
