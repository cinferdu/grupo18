package grafo.generadores;

import java.util.Random;
import grafo.Grafo;

public class GeneradorAleatorioProbabilistico {

	public static Grafo generar(int cantidadNodos, double probabilidad){
		Random random = new Random();
		Grafo grafo = new Grafo(cantidadNodos);
		for(int nodoOrigen=0 ; nodoOrigen< cantidadNodos; nodoOrigen++)
			for(int nodoDestino=nodoOrigen+1; nodoDestino<cantidadNodos; nodoDestino++)
				if((100 * random.nextDouble()) < probabilidad)
					grafo.addArista(nodoOrigen, nodoDestino);
		return grafo;
	}
}
