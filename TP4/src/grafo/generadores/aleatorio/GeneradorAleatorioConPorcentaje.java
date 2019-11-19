package grafo.generadores.aleatorio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import grafo.Grafo;

public class GeneradorAleatorioConPorcentaje {
	
	public static Grafo generar(int cantidadDeNodos, double porcentajeAdy) {
		Grafo grafo = new Grafo(cantidadDeNodos);
		int maxCantArista = grafo.getMaxAristas();
		List<Integer []> aristas = new ArrayList<Integer []>();
		
		for(int origen = 0 ; origen < cantidadDeNodos; origen ++)
			for(int destino = (origen + 1); destino < cantidadDeNodos; destino++)
				aristas.add(new Integer[] {origen, destino});
		Collections.shuffle(aristas);
		
		int aristasTotal = (int)(porcentajeAdy*maxCantArista/100);
		for(int indice = 0; indice  < aristasTotal; indice ++)
			grafo.addArista( aristas.get(indice)[0], aristas.get(indice )[1]);
		return grafo;
	}
}
