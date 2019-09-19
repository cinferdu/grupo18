package tpcc;

public class BinomioDeNewton {
	
	private double a, b;
	private int n;
	
	public double CalcUltTermino ()
	{		
		return Math.pow(this.a, this.n);
	}
	
	public double[] ObtenerTerminosIterativo()
	{
		double resultado = 0;
		double[] terminos = new double[this.n + 1];
		
		for(int k=0; k <= this.n; k++)
		{
			long combinatoria = (FactorialIterativo(this.n)/FactorialIterativo(k));
			terminos [k] = combinatoria*Math.pow(this.a, k) * Math.pow(this.b, (this.n)-k);
		
		}
		return terminos;
		
	}
	
	public double[] ObtenerTerminosRecusivo()
	{
		double resultado = 0;
		double[] terminos = new double[this.n + 1];
		
		for(int k=0; k <= this.n; k++)
		{
			long combinatoria = (FactorialRecursivo(this.n)/FactorialRecursivo(k));
			terminos [k] = combinatoria*Math.pow(this.a, k) * Math.pow(this.b, (this.n)-k);
		
		}
		return terminos;
		
	}
	
	private long FactorialIterativo (int n)
	{
		long factorial = 1;
		for (int i=1; i<=n ; i++)
		{
			factorial *= i;
		}
		return factorial;
	}

	private long FactorialRecursivo (int n)
	{
		if (n == 1)
			return 1;
		return n*FactorialRecursivo(n-1);
	}
}
