package grafo.generadores.aleatorio;

import java.util.Random;
import grafo.Grafo;

public class GeneradorAleatorioProbabilistico {

	public static Grafo generar(int cantidadNodos, double probabilidad){
		Random random = new Random();
		Grafo grafo = new Grafo(cantidadNodos);
		for(int origen = 0 ; origen < cantidadNodos; origen++) //recorro cada nodo origen
			for(int destino = (origen + 1); destino < cantidadNodos; destino++) // por cada origen probabilidad de agregar un destino
				if((100 * random.nextDouble()) < probabilidad)
					grafo.addArista( origen, destino);
		return grafo;
	}
}
