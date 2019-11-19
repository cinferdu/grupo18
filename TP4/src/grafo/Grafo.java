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


	public int getMaxAristas() {
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

	public void generarArchivoGrafo(String path) {
		PrintWriter fichero = null;
		int cantidadDeAristas;
		
		try {
			fichero = new PrintWriter(new FileWriter(path));
			cantidadDeAristas = getCantidadDeAristas() ;
			fichero.println(getCantidadDeNodos() + " " 
							+ cantidadDeAristas + " " 
							+ (double)cantidadDeAristas/getMaxAristas() 
							+ " " + getGradoMax() + " " + getGradoMin());
			
			for (int origen = 0; origen < getCantidadDeNodos(); origen++)
				for (int destino = origen; destino < getCantidadDeNodos(); destino++)
					if (origen != destino && hayArista(origen, destino) == true)
						fichero.println(origen + " " + destino);					
		
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fichero != null)
				fichero.close();
		}
	}

	@Override
	public String toString() {
		return "Grafo [distancias=" + aristas + "]";
	}
	
}
