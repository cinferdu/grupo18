package grafo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Grafo {

	private MatrizSimetrica aristas;
	
	public Grafo(int cantidadNodos) {
		aristas = new MatrizSimetrica(cantidadNodos);
	}

	public void addArista(int n1, int n2) {
		aristas.setValor(n1, n2,true);
	}

	@Override
	public String toString() {
		return "Grafo [distancias=" + aristas + "]";
	}

	public int getMaximaCantidadAristas() {
		return aristas.getSize();
	}

	public boolean hayArista(int n1, int n2) {
		return aristas.getValor(n1, n2);
	}
	
	public int getCantidadDeNodos(){
		return aristas.getOrden();
	}
	
	public int getCantidadDeAristas(){
		int nroAristas = 0;
		int cantidadDeNodos = getCantidadDeNodos();
		for(int i=0; i<cantidadDeNodos; i++)
			for(int j = i+1; j < cantidadDeNodos; j++)
				if(hayArista(i, j))
					nroAristas++;	
		return nroAristas;
	}
	
	public int getGradoMin() {
		int gradoMin = Integer.MAX_VALUE;
		int cantidadDeNodos = getCantidadDeNodos();
		
		for (int i = 0; i < cantidadDeNodos; i++) {
			int g = 0;
			for(int j = 0; j < cantidadDeNodos; j++)
				if(i != j && hayArista(i,j))
					g++;
			if(g<gradoMin)
				gradoMin = g;
		}
		
		return gradoMin;
	}

	public int getGradoMax() {
		int gradoMax=0;
		int cantidadDeNodos = getCantidadDeNodos();
		
		for (int i = 0; i < cantidadDeNodos; i++) {
			int g=0;
			for(int j = 0; j < cantidadDeNodos; j++)
				if(i!= j && hayArista(i,j))
					g++;
			if(g>gradoMax)
				gradoMax = g;
		}
		
		return gradoMax;
	}

	public void generarArchivoGrafo(String path) throws IOException {
		FileWriter archivo = new FileWriter(path);
		PrintWriter fichero = new PrintWriter(archivo);
		int cantidadDeAristas = getCantidadDeAristas() ;
		fichero.println(getCantidadDeNodos() + " " + cantidadDeAristas + " " + (double)cantidadDeAristas/getMaximaCantidadAristas() + " " + getGradoMax() + " " + getGradoMin());
		for (int i = 0; i < getCantidadDeNodos(); i++)
			for (int j = i; j < getCantidadDeNodos(); j++)
				if (i != j && hayArista(i, j) == true)
					fichero.println(i + " " + j);					
		archivo.close();
	}

	
}
