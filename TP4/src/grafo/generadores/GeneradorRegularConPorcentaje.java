package grafo.generadores;

import grafo.Grafo;

public class GeneradorRegularConPorcentaje {
	public static Grafo generar(int cantidadDeNodos, double porcentaje) {

			int grado = (int) Math.round(porcentaje*(cantidadDeNodos-1)*0.01);

		
		return GeneradorRegularConGrado.generar(cantidadDeNodos, grado);
	}

}
