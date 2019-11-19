package grafo.generadores.partito;

import java.util.Random;

import grafo.Grafo;

public class GeneradorGrafoNPartitos {

	public static Grafo generar(int cantidadDeNodos, int nParticiones){
		Grafo grafo = new Grafo(cantidadDeNodos);
		int [] particion = new int[cantidadDeNodos];
		int i;
		
		for(i= 0; i < cantidadDeNodos; i++)
			particion[i] = new Random().nextInt(nParticiones);
		
		for(i=0; i< cantidadDeNodos; i++ )
			for(int j = 0; j < cantidadDeNodos; j++)
				if(particion[i] != particion[j] && !grafo.hayArista(i,j))
					grafo.addArista(i,j);
		
		return grafo;
	}

}
