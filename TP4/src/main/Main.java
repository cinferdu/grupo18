package main;

import java.io.IOException;

import grafo.Datos;
import grafo.GrafoNDNP;
import grafo.Resultado;
import grafo.generadores.aleatorio.GeneradorAleatorioConPorcentaje;
import grafo.generadores.regular.GeneradorRegularConPorcentaje;

public class Main {
	
	public static final String IN_1 = "grafo1.in";
	public static final String IN_2 = "grafo2.in";
	public static final String IN_3 = "grafo3.in";
	public static final String IN_4 = "grafo4.in";
	public static final String IN_5 = "grafo5.in";
	
	public static final String OUT_1_COLOR = "coloreado1.out";
	public static final String OUT_2_COLOR = "coloreado2.out";
	public static final String OUT_3_COLOR = "coloreado3.out";
	public static final String OUT_4_COLOR = "coloreado4.out";
	public static final String OUT_5_COLOR = "coloreado5.out";
	
	public static final String OUT_1_STADISTIC = "muestra1.out";
	public static final String OUT_2_STADISTIC = "muestra2.out";
	public static final String OUT_3_STADISTIC = "muestra3.out";
	public static final String OUT_4_STADISTIC = "muestra4.out";
	public static final String OUT_5_STADISTIC = "muestra5.out";
	
	

	public static void main(String[] args) throws IOException {

		GeneradorAleatorioConPorcentaje.generar(600, 40).generarArchivoGrafo("grafo1.in");
		GeneradorAleatorioConPorcentaje.generar(600, 60).generarArchivoGrafo("grafo2.in");
		GeneradorAleatorioConPorcentaje.generar(600, 90).generarArchivoGrafo("grafo3.in");
		GeneradorRegularConPorcentaje.generar(1000, 50).generarArchivoGrafo("grafo4.in");
		GeneradorRegularConPorcentaje.generar(1000, 75).generarArchivoGrafo("grafo5.in");

		GrafoNDNP grafo1 = new GrafoNDNP("grafo1.in");
		GrafoNDNP grafo2 = new GrafoNDNP("grafo2.in");
		GrafoNDNP grafo3 = new GrafoNDNP("grafo3.in");
		GrafoNDNP grafo4 = new GrafoNDNP("grafo4.in");
		GrafoNDNP grafo5 = new GrafoNDNP("grafo5.in");
		
		Resultado resultado1 = new Resultado(1000, null);
		Resultado resultado2 = new Resultado(1000, null);
		Resultado resultado3 = new Resultado(1000, null);
		Resultado resultado4 = new Resultado(1000, null);
		Resultado resultado5 = new Resultado(1000, null);
		
		Datos secuencial1  = resultado1.secuencialAleatorio(grafo1);
		Datos welsh1 = resultado1.welshPowell(grafo1);
		Datos matula1  = resultado1.matula(grafo1);
		//resultado1.grabarMuestra(OUT_1_STADISTIC);//ejecutar despues de los 3 tipos
		
		Datos secuencial2  = resultado2.secuencialAleatorio(grafo2);
		Datos welsh2  = resultado2.welshPowell(grafo2);
		Datos matula2  = resultado2.matula(grafo2);
		resultado2.grabarMuestra(OUT_2_STADISTIC);//ejecutar despues de los 3 tipos
		
		Datos secuencial3  = resultado3.secuencialAleatorio(grafo3);
		Datos welsh3  = resultado3.welshPowell(grafo3);
		Datos matula3  = resultado3.matula(grafo3);
		resultado3.grabarMuestra(OUT_3_STADISTIC);//ejecutar despues de los 3 tipos
		
		Datos secuencial4  = resultado4.secuencialAleatorio(grafo4);
		Datos welsh4  = resultado4.welshPowell(grafo4);
		Datos matula4  = resultado4.matula(grafo4);
		resultado4.grabarMuestra(OUT_4_STADISTIC);//ejecutar despues de los 3 tipos
		
		Datos secuencial5  = resultado5.secuencialAleatorio(grafo5);
		Datos welsh5  = resultado5.welshPowell(grafo5);
		Datos matula5  = resultado5.matula(grafo5);
		resultado5.grabarMuestra(OUT_5_STADISTIC);//ejecutar despues de los 3 tipos

		System.out.println("Resultados Caso 1 Secuencial Aleatorio");
		System.out.println(secuencial1.getCantColores() + " " + secuencial1.getRepeticion());
		
		System.out.println("Resultados Caso 1 Welsh Powell");
		System.out.println(welsh1.getCantColores() + " " + welsh1.getRepeticion());

		System.out.println("Resultados Caso 1 Matula");
		System.out.println(matula1.getCantColores() + " " + matula1.getRepeticion());
		
		System.out.println("Resultados Caso 2 Secuencial Aleatorio");
		System.out.println(secuencial2.getCantColores() + " " + secuencial2.getRepeticion());
		
		System.out.println("Resultados Caso 2 Welsh Powell");
		System.out.println(welsh2.getCantColores() + " " + welsh2.getRepeticion());

		System.out.println("Resultados Caso 2 Matula");
		System.out.println(matula2.getCantColores() + " " + matula2.getRepeticion());

		System.out.println("Resultados Caso 3 Secuencial Aleatorio");
		System.out.println(secuencial3.getCantColores() + " " + secuencial3.getRepeticion());
		
		System.out.println("Resultados Caso 3 Welsh Powell");
		System.out.println(welsh3.getCantColores() + " " + welsh3.getRepeticion());

		System.out.println("Resultados Caso 3 Matula");
		System.out.println(matula3.getCantColores() + " " + matula3.getRepeticion());

		System.out.println("Resultados Caso 4 Secuencial Aleatorio");
		System.out.println(secuencial4.getCantColores() + " " + secuencial4.getRepeticion());
		
		System.out.println("Resultados Caso 4 Welsh Powell");
		System.out.println(welsh4.getCantColores() + " " + welsh4.getRepeticion());

		System.out.println("Resultados Caso 4 Matula");
		System.out.println(matula4.getCantColores() + " " + matula4.getRepeticion());

		System.out.println("Resultados Caso 5 Secuencial Aleatorio");
		System.out.println(secuencial5.getCantColores() + " " + secuencial5.getRepeticion());
		
		System.out.println("Resultados Caso 5 Welsh Powell");
		System.out.println(welsh5.getCantColores() + " " + welsh5.getRepeticion());

		System.out.println("Resultados Caso 5 Matula");
		System.out.println(matula5.getCantColores() + " " + matula5.getRepeticion());
	}

}
