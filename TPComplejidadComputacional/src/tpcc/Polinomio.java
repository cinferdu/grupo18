package tpcc;

public class Polinomio {
	private int grado;
	private double[] coeficientes;
	

	public Polinomio(int grado, double[] coeficientes) {
		this.coeficientes = coeficientes;
		this.grado = grado;
	}
	
	//----------------------- 1 -----------------------
	
	/*Escribir evaluarMSucesivas utilizando calculo de potencia por multiplicaciones sucesivas*/
	
	public double evaluarMSucesivas(double x) {
		double resultado = 0;
		double pow = 1;

		for (int i = this.grado; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				pow *= x;
			}
			resultado += pow * coeficientes[grado - i];
			pow = 1;
		}
		return resultado + this.coeficientes[this.grado];
	}
	
	//----------------------- 2 -----------------------
	
	/*Escribir evaluarRecursiva utilizando el siguiente calculo de potencia recursiva: 
			a) Sin considerar si el exponente es par o impar: potencia(x,n)=x∗ potencia(x,n−1) */
	
	public double evaluarRecursiva(double x) {
		double resultado = 0;
		for (int i = 0; i <= this.grado; i++)
			resultado += this.pow(this.grado-i, x) * coeficientes[i];
		return resultado;
	}

	private double pow(int grado, double x) {
		if (grado == 0)
			return 1;
		return x * this.pow(grado - 1, x);
	}

	//----------------------- 3 -----------------------
	
	/* Escribir evaluarRecursiva utilizando el siguiente calculo de potencia recursiva: 
	  		b) Considerando si el exponente es par o impar: 
					Si n es par: potencia(x,n)=potencia(x∗x,n/2) 
					Si n es impar potencia(x,n)=x∗ potencia(x,n−1) */
	
	public double evaluarRecursivaPar(double x) {
		double resultado = 0;
		
		return resultado;
	}
	
	//----------------------- 4 -----------------------
	
	/*Escribir evaluarProgDinamica, almacenando las potencias de X ya calculadas.*/
	
	public double evaluarProgDinamica(double x) {
		double resultado = 0;
		double [] storage = new double[this.grado + 1];

		storage[0] = 1;
		
		for (int i = 1; i <= this.grado ; i++) {
			storage[i] = storage[i-1] * x;
		}

		for (int i = this.grado; i >= 0; i--) {
			resultado += coeficientes[i]*storage[this.grado - i];
		}
		
		return resultado;
	}
	
	//----------------------- 5 -----------------------
	
	/*Escribir evaluarMejorada, con un algoritmo de igual complejidad computacional que el anterior, 
      pero que ejecute en un tiempo menor.*/
	
	public double evaluarMejorada(double x) {
		double resultado = 0;

		return resultado;
	}
	
	
	//----------------------- 6 -----------------------
	
	/*Escribir evaluarPow, valiéndose del método Math.pow(x,n) provisto por el lenguaje Java. 
	  Se debe incluir dentro de alguno de los métodos anteriores donde se considere que es apropiado. 
	  Investigue la CC de Math.pow. */
	
	public double evaluarPow(double x) {
		double resultado = 0;

		return resultado;
	}
	
	
	//----------------------- 7 -----------------------
	
	/*Escribir evaluarHorner, aplicando el algoritmo de Horner de análisis numérico. (Investigar).*/
	
	public double evaluarHorner(double x) {
		double resultado = 0;

		for (int i = 0; i < coeficientes.length; i++) {
			resultado = resultado * x + coeficientes[i];
		}
		
		return resultado;
	}
}
