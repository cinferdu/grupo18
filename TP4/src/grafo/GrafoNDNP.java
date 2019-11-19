package grafo;
import java.io.File;
import java.io.FileNotFoundException;
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
	private final int COLOR_DEFAULT = -1;
	
	public GrafoNDNP(String path) {
		
		Scanner in = null;
		try {
			int origen;
			int destino;

			in = new Scanner(new File(path));
			in.useLocale(Locale.US);
			
			this.cantidadNodos = in.nextInt();
			this.matriz = new MatrizSimetrica(cantidadNodos);
			this.cantidadAristas = in.nextInt();
			this.porcentajeAdyacencia = in.nextDouble();
			this.gradoMaximo = in.nextInt();
			this.gradoMinimo = in.nextInt();
			this.nodos = new ArrayList<Nodo>();
			
			for(int i = 0; i < cantidadNodos ; i++ )
				this.nodos.add(new Nodo(i,COLOR_DEFAULT));
			
			for(int i = 0; i < cantidadAristas; i++){
				origen = in.nextInt();
				destino = in.nextInt();
				this.nodos.get(origen).aumentarGrado();
				this.nodos.get(destino).aumentarGrado();
				this.matriz.setValor(origen, destino, true);
			}
			
			cantidadDeColores = cantidadNodos > 0 ? 1 : 0;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(in != null)
				in.close();
		}
	}
	
	public void reordenarNodos() {
		Collections.shuffle(nodos);
	}
	
	public void reiniciarColoreo() {
		cantidadDeColores = 1;
		for(Nodo n : nodos){
			n.setColor(COLOR_DEFAULT);
		}
	}
	
	private int colorear() {
		int color = 1; 
		int nodoAuxiliar;
		
		nodos.get(0).setColor(color);
		
		for (int i = 1; i < cantidadNodos; i++) {
			nodos.get(i).setColor(color);

			nodoAuxiliar = 0;
			
			while (nodoAuxiliar < cantidadNodos) {
					if(	nodos.get(i).getNumero() != nodos.get(nodoAuxiliar).getNumero() &&
					matriz.getValor(nodos.get(i).getNumero(), nodos.get(nodoAuxiliar).getNumero())  &&
					nodos.get(i).getColor() == nodos.get(nodoAuxiliar).getColor()) {
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
	
	private void ordenarPorGradoDESC() {
		Collections.sort(nodos, new Comparator<Nodo>(){
			@Override
			public int compare(Nodo n1, Nodo n2) {
				return n2.getGrado() - n1.getGrado();
			}
		});
	}	

	
	public int colorearSecuencialmente() {
		return colorear();
	}


	public int matula() {
		this.ordenarPorGradoASC();
		return colorear();
	}
	
	public int WelshPowell() {
		this.ordenarPorGradoDESC();
		return colorear();
	}
	
	
	public void grabarColoreo(String archivoSalida, int cantColores) {
		
		PrintWriter out = null;
		try {
			out = new PrintWriter(new File(archivoSalida));
			String ady = String.valueOf(porcentajeAdyacencia);
			
			out.println(cantidadNodos + " " + cantColores + " " + cantidadAristas + " " + ady.replace('.', ',') + " " + gradoMaximo + " " + gradoMinimo);
			
			for(int i=0; i<cantidadNodos; i++)
				out.println(nodos.get(i).getNumero() + " "+ nodos.get(i).getGrado()+ " "+ nodos.get(i).getColor());
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(out != null)
				out.close();
		}
	}
}
