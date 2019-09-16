package tpcc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class PolinimioTest {

	@Test
	void testSucesivo() {
		double[] coef = {5,4,3,2};
		Polinomio p1 = new Polinomio(3,coef);
		Assert.assertEquals(64,p1.evaluarMSucesivas(2),0.00);
	}
	
	
	@Test
	void testRecursivo() {
		double[] coef = {5,4,3,2};
		Polinomio p1 = new Polinomio(3,coef);
		Assert.assertEquals(64,p1.evaluarRecursiva(2),0.00);
	}
	
	@Test
	void testProgramacionDinamica() {
		double[] coef = {5,4,3,2};
		Polinomio p1 = new Polinomio(3,coef);
		Assert.assertEquals(64,p1.evaluarProgDinamica(2),0.00);
	}
}
