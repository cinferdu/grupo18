package tpcc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class PolinimioTest {

	private final double[] POL_1_COEF = {5,4,3,2};
	private final int POL_1_GRADO = 3;
	private final double POL_1_RESULTADO = 64;

	@Test
	void testSucesivo() {
		Polinomio p1 = new Polinomio(POL_1_GRADO,POL_1_COEF);
		Assert.assertEquals(POL_1_RESULTADO,p1.evaluarMSucesivas(2),0.00);
	}


	@Test
	void testRecursivo() {
		Polinomio p1 = new Polinomio(POL_1_GRADO,POL_1_COEF);
		Assert.assertEquals(POL_1_RESULTADO,p1.evaluarRecursiva(2),0.00);
	}
	
	@Test
	void testRecursivoPar() {
		Polinomio p1 = new Polinomio(POL_1_GRADO,POL_1_COEF);
		Assert.assertEquals(POL_1_RESULTADO,p1.evaluarRecursivaPar(2),0.00);
	}

	@Test
	void evaluarProgDinamicaTest() {
		Polinomio p1 = new Polinomio(POL_1_GRADO,POL_1_COEF);
		Assert.assertEquals(POL_1_RESULTADO,p1.evaluarProgDinamica(2),0.00);
	}
	
	@Test
	void evaluarMejoradaTest() {
		Polinomio p1 = new Polinomio(POL_1_GRADO,POL_1_COEF);
		Assert.assertEquals(POL_1_RESULTADO,p1.evaluarMejorada(2),0.00);
	}
	
	@Test
	void evaluarPowTest() {
		Polinomio p1 = new Polinomio(POL_1_GRADO,POL_1_COEF);
		Assert.assertEquals(POL_1_RESULTADO,p1.evaluarPow(2),0.00);
	}
	
	@Test
	void evaluarHornerTest() {
		Polinomio p1 = new Polinomio(POL_1_GRADO,POL_1_COEF);
		Assert.assertEquals(POL_1_RESULTADO,p1.evaluarHorner(2),0.00);
	}
}
