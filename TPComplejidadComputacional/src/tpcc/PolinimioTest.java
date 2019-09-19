package tpcc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;

class PolinimioTest {
	private final int POL_1_GRADO = 10000000;
	private final int I = POL_1_GRADO + 1;
	private final int POL_1_VAL_X = 0;
	private final double POL_1_RESULTADO = 0;
	private double[] coef = new double[I];

	@Before
	void crearPrueba() {
		for (int i = 0; i < I; i++) {
			coef[i] = 0;
		}
	}

	@Test
	void testSucesivo() {
		Polinomio p1 = new Polinomio(POL_1_GRADO, coef);
		Assert.assertEquals(POL_1_RESULTADO, p1.evaluarMSucesivas(POL_1_VAL_X), 0.00);
	}

	@Test
	void testRecursivo() {
		Polinomio p1 = new Polinomio(POL_1_GRADO, coef);
		Assert.assertEquals(POL_1_RESULTADO, p1.evaluarRecursiva(POL_1_VAL_X), 0.00);
	}

	@Test
	void testRecursivoPar() {
		double[] coef = new double[I];

		for (int i = 0; i < I; i++) {
			coef[i] = 0;
		}

		Polinomio p1 = new Polinomio(POL_1_GRADO, coef);
		Assert.assertEquals(POL_1_RESULTADO, p1.evaluarRecursivaPar(POL_1_VAL_X), 0.00);
	}

	@Test
	void evaluarProgDinamicaTest() {
		Polinomio p1 = new Polinomio(POL_1_GRADO, coef);
		Assert.assertEquals(POL_1_RESULTADO, p1.evaluarProgDinamica(POL_1_VAL_X), 0.00);
	}

	@Test
	void evaluarMejoradaTest() {
		Polinomio p1 = new Polinomio(POL_1_GRADO, coef);
		Assert.assertEquals(POL_1_RESULTADO, p1.evaluarMejorada(POL_1_VAL_X), 0.00);
	}

	@Test
	void evaluarPowTest() {
		Polinomio p1 = new Polinomio(POL_1_GRADO, coef);
		Assert.assertEquals(POL_1_RESULTADO, p1.evaluarPow(POL_1_VAL_X), 0.00);
	}

	@Test
	void evaluarHornerTest() {
		Polinomio p1 = new Polinomio(POL_1_GRADO, coef);
		Assert.assertEquals(POL_1_RESULTADO, p1.evaluarHorner(POL_1_VAL_X), 0.00);
	}
}
