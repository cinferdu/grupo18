package tpcc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class PolinimioTest {

	private final double[] POL_1_COEF = {8,9,48,-96,-5,4,3,2};
	private final int POL_1_GRADO = 7;
	private final int POL_1_VAL_X = 5;
	private final double POL_1_RESULTADO = 855117;

	@Test
	void testSucesivo() {
		Polinomio p1 = new Polinomio(POL_1_GRADO,POL_1_COEF);
		Assert.assertEquals(POL_1_RESULTADO,p1.evaluarMSucesivas(POL_1_VAL_X),0.00);
	}


	@Test
	void testRecursivo() {
		Polinomio p1 = new Polinomio(POL_1_GRADO,POL_1_COEF);
		Assert.assertEquals(POL_1_RESULTADO,p1.evaluarRecursiva(POL_1_VAL_X),0.00);
	}
	
	@Test
	void testRecursivoPar() {
		Polinomio p1 = new Polinomio(POL_1_GRADO,POL_1_COEF);
		Assert.assertEquals(POL_1_RESULTADO,p1.evaluarRecursivaPar(POL_1_VAL_X),0.00);
	}

	@Test
	void evaluarProgDinamicaTest() {
		Polinomio p1 = new Polinomio(POL_1_GRADO,POL_1_COEF);
		Assert.assertEquals(POL_1_RESULTADO,p1.evaluarProgDinamica(POL_1_VAL_X),0.00);
	}
	
	@Test
	void evaluarMejoradaTest() {
		Polinomio p1 = new Polinomio(POL_1_GRADO,POL_1_COEF);
		Assert.assertEquals(POL_1_RESULTADO,p1.evaluarMejorada(POL_1_VAL_X),0.00);
	}
	
	@Test
	void evaluarPowTest() {
		Polinomio p1 = new Polinomio(POL_1_GRADO,POL_1_COEF);
		Assert.assertEquals(POL_1_RESULTADO,p1.evaluarPow(POL_1_VAL_X),0.00);
	}
	
	@Test
	void evaluarHornerTest() {
		Polinomio p1 = new Polinomio(POL_1_GRADO,POL_1_COEF);
		Assert.assertEquals(POL_1_RESULTADO,p1.evaluarHorner(POL_1_VAL_X),0.00);
	}
}
