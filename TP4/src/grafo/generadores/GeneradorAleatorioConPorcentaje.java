package grafo.generadores;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import grafo.Grafo;

public class GeneradorAleatorioConPorcentaje {
	public static Grafo generar(int cantidadDeNodos, double porcentajeAdy)
	{
		Grafo grafo = new Grafo(cantidadDeNodos);
		int maxCantArista = grafo.getMaximaCantidadAristas();
		List<Arista> aristas = new ArrayList<Arista>(maxCantArista);
		
		for(int fila=0 ;fila<cantidadDeNodos; fila++)
			for(int columna=fila+1; columna<cantidadDeNodos; columna++)
				aristas.add(new Arista(fila, columna));
		Collections.shuffle(aristas);
		
		int cantAristasTomar = (int)(porcentajeAdy*maxCantArista/100);
		for(int i=0; i<cantAristasTomar; i++)
			grafo.addArista( aristas.get(i).getOrigen(), aristas.get(i).getDestino());
		
		return grafo;
	}
}
