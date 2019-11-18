package grafo;

import grafo.GrafoNDNP;

public class Resultados {
 
	int repeticiones;
	
	public Resultados(int repeticiones) {
		this.repeticiones = repeticiones;
	}
	
	public Datos secuencialAleatorio(GrafoNDNP grafo) {
		
		int cantColoresMin;
		int cantColores;
		int rep=0;

		grafo.reordenarNodos();
		cantColoresMin = grafo.colorearSecuencialmente();

		for (int i = 0; i < repeticiones; i++) {

			grafo.reordenarNodos();
			grafo.reiniciarColoreo();

			cantColores=grafo.colorearSecuencialmente();
			if (cantColores< cantColoresMin) {
				cantColoresMin = cantColores;
				rep = i;
			}
		}
		Datos datos = new Datos(cantColoresMin, rep);

		return datos;
	}

	public Datos welshPowell(GrafoNDNP grafo) {

		int cantColoresMin;
		int cantColores;
		int rep=0;

		grafo.reordenarNodos();
		cantColoresMin = grafo.WelshPowell();

		for (int i = 0; i < repeticiones; i++) {

			grafo.reordenarNodos();
			grafo.reiniciarColoreo();

			if ((cantColores=grafo.WelshPowell())< cantColoresMin) {
				cantColoresMin = cantColores;
				rep = i;
			}
		}
		Datos dat = new Datos(cantColoresMin, rep);

		return dat;
	}

	public Datos matula(GrafoNDNP grafo) {

		int cantColoresMin;
		int cantColores;
		int rep=0;

		grafo.reordenarNodos();
		cantColoresMin = grafo.matula();

		for (int i = 0; i < repeticiones; i++) {

			grafo.reordenarNodos();
			grafo.reiniciarColoreo();

			if ((cantColores=grafo.matula())< cantColoresMin) {
				cantColoresMin = cantColores;
				rep = i;
			}
		}
		Datos dat = new Datos(cantColoresMin, rep);

		return dat;
	}
}
