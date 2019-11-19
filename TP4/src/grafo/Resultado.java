package grafo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Resultado {
 
	private int repeticiones;
	private String pathColor;
	private List<Integer> listCantColoresAleatorio = new ArrayList<Integer>();
	private List<Integer> listCantColoresWelsh = new ArrayList<Integer>();
	private List<Integer> listCantColoresMatula = new ArrayList<Integer>();
	
	public Resultado(int repeticiones) {
		this.repeticiones = repeticiones;
	}
	
	public Resultado(int repeticiones, String pathColor) {
		this.repeticiones = repeticiones;
		this.pathColor = pathColor;
	}
	
	public Datos secuencialAleatorio(GrafoNDNP grafo) {
		
		int cantColoresMin;
		int cantColores;
		int rep=0;

		grafo.reordenarNodos();
		cantColoresMin = grafo.colorearSecuencialmente();
		listCantColoresAleatorio.add(cantColoresMin);
		
		if(pathColor != null)
			grafo.grabarColoreo(pathColor, cantColoresMin);

		for (int i = 0; i < repeticiones; i++) {

			grafo.reordenarNodos();
			grafo.reiniciarColoreo();

			cantColores = grafo.colorearSecuencialmente();
			listCantColoresAleatorio.add(cantColores);
			
			if (cantColores< cantColoresMin) {
				cantColoresMin = cantColores;
				if(pathColor != null)
					grafo.grabarColoreo(pathColor, cantColoresMin);
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
		listCantColoresWelsh.add(cantColoresMin);
		
		if(pathColor != null)
			grafo.grabarColoreo(pathColor, cantColoresMin);
		
		for (int i = 0; i < repeticiones; i++) {

			grafo.reordenarNodos();
			grafo.reiniciarColoreo();
			
			cantColores = grafo.WelshPowell();
			listCantColoresWelsh.add(cantColores);

			if (cantColores < cantColoresMin) {
				cantColoresMin = cantColores;
				
				if(pathColor != null)
					grafo.grabarColoreo(pathColor, cantColoresMin);
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
		listCantColoresMatula.add(cantColoresMin);
		
		if(pathColor != null)
			grafo.grabarColoreo(pathColor, cantColoresMin);

		for (int i = 0; i < repeticiones; i++) {

			grafo.reordenarNodos();
			grafo.reiniciarColoreo();
			
			cantColores = grafo.matula();
			listCantColoresMatula.add(cantColores);

			if (cantColores < cantColoresMin) {
				cantColoresMin = cantColores;
				
				if(pathColor != null)
					grafo.grabarColoreo(pathColor, cantColoresMin);
				
				rep = i;
			}
		}
		Datos dat = new Datos(cantColoresMin, rep);

		return dat;
	}
	
	public void grabarMuestra(String archivoSalida) {
		
		PrintWriter out = null;
		try {
			out = new PrintWriter(new File(archivoSalida));
			out.println("Aleatorio WelshPowell Matula");
			for (int i = 0; i < repeticiones; i++) {
				out.println( listCantColoresAleatorio.get(i) + " " + listCantColoresWelsh.get(i) + " " + listCantColoresMatula.get(i));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(out != null)
				out.close();
		}
	}
}
