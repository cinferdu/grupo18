package grafo;

import java.io.IOException;

import grafo.GrafoNDNP;
import grafo.generadores.GeneradorAleatorioConPorcentaje;

public class Main {

	public static void main(String[] args) throws IOException {

		GeneradorAleatorioConPorcentaje.generar(600, 40).generarArchivoGrafo("grafo1.in");
		GeneradorAleatorioConPorcentaje.generar(600, 60).generarArchivoGrafo("grafo2.in");
		GeneradorAleatorioConPorcentaje.generar(600, 90).generarArchivoGrafo("grafo3.in");
		GeneradorAleatorioConPorcentaje.generar(1000, 50).generarArchivoGrafo("grafo4.in");
		GeneradorAleatorioConPorcentaje.generar(1000, 75).generarArchivoGrafo("grafo5.in");

		GrafoNDNP grafo1 = new GrafoNDNP("grafo1.in");
		GrafoNDNP grafo2 = new GrafoNDNP("grafo2.in");
		GrafoNDNP grafo3 = new GrafoNDNP("grafo3.in");
		GrafoNDNP grafo4 = new GrafoNDNP("grafo4.in");
		GrafoNDNP grafo5 = new GrafoNDNP("grafo5.in");
		
		Resultados resultado1 = new Resultados(10);
		Resultados resultado2 = new Resultados(10);
		Resultados resultado3 = new Resultados(10);
		Resultados resultado4 = new Resultados(10);
		Resultados resultado5 = new Resultados(10);
		
		Datos caso1_secuencial  = resultado1.secuencialAleatorio(grafo1);
		Datos caso1_welsh  = resultado1.welshPowell(grafo1);
		Datos caso1_matula  = resultado1.matula(grafo1);
		
		Datos caso2_secuencial  = resultado2.secuencialAleatorio(grafo2);
		Datos caso2_welsh  = resultado2.welshPowell(grafo2);
		Datos caso2_matula  = resultado2.matula(grafo2);
		
		Datos caso3_secuencial  = resultado3.secuencialAleatorio(grafo3);
		Datos caso3_welsh  = resultado3.welshPowell(grafo3);
		Datos caso3_matula  = resultado3.matula(grafo3);
		
		Datos caso4_secuencial  = resultado4.secuencialAleatorio(grafo4);
		Datos caso4_welsh  = resultado4.welshPowell(grafo4);
		Datos caso4_matula  = resultado4.matula(grafo4);
		
		Datos caso5_secuencial  = resultado5.secuencialAleatorio(grafo5);
		Datos caso5_welsh  = resultado5.welshPowell(grafo5);
		Datos caso5_matula  = resultado5.matula(grafo5);

		System.out.println("Resultados Caso 1 Secuencial Aleatorio");
		System.out.println(caso1_secuencial.getCantColores() + " " + caso1_secuencial.getRepeticion());
		
		System.out.println("Resultados Caso 1 Welsh Powell");
		System.out.println(caso1_welsh.getCantColores() + " " + caso1_welsh.getRepeticion());

		System.out.println("Resultados Caso 1 Matula");
		System.out.println(caso1_matula.getCantColores() + " " + caso1_matula.getRepeticion());
		
		System.out.println("Resultados Caso 2 Secuencial Aleatorio");
		System.out.println(caso2_secuencial.getCantColores() + " " + caso2_secuencial.getRepeticion());
		
		System.out.println("Resultados Caso 2 Welsh Powell");
		System.out.println(caso2_welsh.getCantColores() + " " + caso2_welsh.getRepeticion());

		System.out.println("Resultados Caso 2 Matula");
		System.out.println(caso2_matula.getCantColores() + " " + caso2_matula.getRepeticion());

		System.out.println("Resultados Caso 3 Secuencial Aleatorio");
		System.out.println(caso3_secuencial.getCantColores() + " " + caso3_secuencial.getRepeticion());
		
		System.out.println("Resultados Caso 3 Welsh Powell");
		System.out.println(caso3_welsh.getCantColores() + " " + caso3_welsh.getRepeticion());

		System.out.println("Resultados Caso 3 Matula");
		System.out.println(caso3_matula.getCantColores() + " " + caso3_matula.getRepeticion());

		System.out.println("Resultados Caso 4 Secuencial Aleatorio");
		System.out.println(caso4_secuencial.getCantColores() + " " + caso4_secuencial.getRepeticion());
		
		System.out.println("Resultados Caso 4 Welsh Powell");
		System.out.println(caso4_welsh.getCantColores() + " " + caso4_welsh.getRepeticion());

		System.out.println("Resultados Caso 4 Matula");
		System.out.println(caso4_matula.getCantColores() + " " + caso4_matula.getRepeticion());

		System.out.println("Resultados Caso 5 Secuencial Aleatorio");
		System.out.println(caso5_secuencial.getCantColores() + " " + caso5_secuencial.getRepeticion());
		
		System.out.println("Resultados Caso 5 Welsh Powell");
		System.out.println(caso5_welsh.getCantColores() + " " + caso5_welsh.getRepeticion());

		System.out.println("Resultados Caso 5 Matula");
		System.out.println(caso5_matula.getCantColores() + " " + caso5_matula.getRepeticion());


	}

}
