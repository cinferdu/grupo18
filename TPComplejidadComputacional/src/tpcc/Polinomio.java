package tpcc;

public class Polinomio {
	private int grado;
	private double[] coeficientes;

	public Polinomio(int grado, double[] coeficientes) {
		this.coeficientes = coeficientes;
		this.grado = grado;
	}

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

	
	public double evaluarRecursivaPar(double x) {
		double resultado = 0;
		
		return resultado;
	}

	public double evaluarProgDinamica(double x) {
		double resultado = 0;

		return resultado;
	}

	public double evaluarMejorada(double x) {
		double resultado = 0;

		return resultado;
	}

	public double evaluarPow(double x) {
		double resultado = 0;

		return resultado;
	}

	public double evaluarHorner(double x) {
		double resultado = 0;

		return resultado;
	}

}
