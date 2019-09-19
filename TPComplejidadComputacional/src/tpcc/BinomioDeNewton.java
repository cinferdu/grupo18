package tpcc;

public class BinomioDeNewton {
	
	private double a, b;
	private int n;
	
	public BinomioDeNewton (double a, double b, int n)
	{
		this.a = a;
		this.b = b;
		this.n = n;
	}
	
	public double calcUltTermino (double x)
	{		
		return Math.pow(this.a*x, this.n);
	}
	
	public double obtenerTerminosIterativo(double x)
	{
		double resultado = 0;
				
		for(int k=0; k <= this.n; k++)
		{
			long combinatoria = (factorialIterativo(this.n)/factorialIterativo(k));
			resultado += combinatoria * Math.pow(this.a*x, k) * Math.pow(this.b, this.n-k);
		
		}
		return resultado;
		
	}
	
	public double obtenerTerminosRecusivo(double x)
	{
		double resultado = 0;
		
		for(int k=0; k <= this.n; k++)
		{
			long combinatoria = (factorialRecursivo(this.n)/factorialRecursivo(k));
			resultado += combinatoria * Math.pow(this.a*x, k) * Math.pow(this.b, this.n-k);
		
		}
		return resultado;
		
	}
	
	private long factorialIterativo (int n)
	{
		long factorial = 1;
		if (n <= 1)
			return 1;
		for (int i=1; i<=n ; i++)
		{
			factorial *= i;
		}
		return factorial;
	}

	private long factorialRecursivo (int n)
	{
		if (n == 1)
			return 1;
		return n*factorialRecursivo(n-1);
	}
}
