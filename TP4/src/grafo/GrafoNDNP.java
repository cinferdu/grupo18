package grafo;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;
import java.util.Scanner;

public class GrafoNDNP {

	MatrizSimetrica matriz;
	private double porcentajeAdyacencia;
	private int gradoMaximo;
	private int gradoMinimo;
	private int cantidadAristas;
	private int cantidadNodos;
	private ArrayList<Nodo> nodos;
	private int cantidadDeColores;
	
	public GrafoNDNP(String path) throws IOException {
		
		Scanner scanner = new Scanner(new File(path)).useLocale(Locale.US);
		int n1,n2;
		cantidadNodos = scanner.nextInt();
		matriz = new MatrizSimetrica(cantidadNodos);
		cantidadAristas = scanner.nextInt();
		porcentajeAdyacencia = scanner.nextDouble();
		gradoMaximo = scanner.nextInt();
		gradoMinimo = scanner.nextInt();
		nodos = new ArrayList<Nodo>();
		for(int i=0;i<cantidadNodos;i++)
			nodos.add(new Nodo(i,-1));
		
		for(int i=0; i<cantidadAristas; i++){
			n1=scanner.nextInt();
			n2=scanner.nextInt();
			nodos.get(n1).aumentarGrado();
			nodos.get(n2).aumentarGrado();
			matriz.setValor(n1, n2,true);
		}	
	
		cantidadDeColores = cantidadNodos > 0 ? 1 : 0;
				
		scanner.close();
	}
	
	public void reordenarNodos()
	{
		Collections.shuffle(nodos);
	}
	public void reiniciarColoreo(){
		cantidadDeColores = 1;
		for(Nodo n : nodos){
			n.setColor(-1);
		}
	}
	
	private int colorear() {
		int color = 1; 
		int nodoAuxiliar;
		
		nodos.get(0).setColor(color);
		
		for (int i = 1; i < cantidadNodos; i++)
		{
			nodos.get(i).setColor(color);

			nodoAuxiliar = 0;
			
			while ( nodoAuxiliar < cantidadNodos)
				{
					if(	nodos.get(i).getNumero() != nodos.get(nodoAuxiliar).getNumero() &&
					matriz.getValor(nodos.get(i).getNumero(), nodos.get(nodoAuxiliar).getNumero())  &&
					nodos.get(i).getColor() == nodos.get(nodoAuxiliar).getColor()
				){
					color++;
					if(color > cantidadDeColores)
						cantidadDeColores = color; 
					else
						nodoAuxiliar= -1;
					nodos.get(i).setColor(color);
				}
				nodoAuxiliar++;
			}
			color = 1;
		}
		return cantidadDeColores;
	}
	
	private void ordenarPorGradoASC() {
			Collections.sort(nodos, new Comparator<Nodo>(){
				@Override
				public int compare(Nodo n1, Nodo n2) {
					return n1.getGrado() - n2.getGrado();
				}
			});	
	}
	
	private void ordenarPorGradoADESC() {
			Collections.sort(nodos, new Comparator<Nodo>(){
				@Override
				public int compare(Nodo n1, Nodo n2) {
					return n2.getGrado() - n1.getGrado();
				}
			});
	}	

	
	public int colorearSecuencialmente(){
		return colorear();
	}


	public int matula(){
		this.ordenarPorGradoASC();
		return colorear();
	}
	
	public int WelshPowell(){
		this.ordenarPorGradoADESC();
		return colorear();
	}
	
	
	public void grabarArchivoSalida(String archivoSalida, int cantColores) throws FileNotFoundException{
		
		PrintWriter salida = new PrintWriter(new File(archivoSalida));
		String ady = String.valueOf(porcentajeAdyacencia);
		
		salida.println(cantidadNodos + " " + cantColores + " " + cantidadAristas + " " + ady.replace('.', ',') + " " + gradoMaximo + " " + gradoMinimo);
		
		for(int i=0; i<cantidadNodos; i++)
			salida.println(nodos.get(i).getNumero() + " "+ nodos.get(i).getGrado()+ " "+ nodos.get(i).getColor());
		
		salida.close();
	}
}
