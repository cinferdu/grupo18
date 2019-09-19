package tpcc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class BinomioDeNewtonTest {

	
	@Test
	void binomioIterativo() {
		BinomioDeNewton prueba1 = new BinomioDeNewton(1, -3, 3);
		Assert.assertEquals(-82,prueba1.obtenerTerminosIterativo(2),0.00);
		Assert.assertEquals(8,prueba1.calcUltTermino(2),0.00);
	}
	
	@Test
	void binomioRecursivo() {
		BinomioDeNewton prueba1 = new BinomioDeNewton(1, -3, 3);
		Assert.assertEquals(-82,prueba1.obtenerTerminosRecusivo(2),0.00);
		Assert.assertEquals(8,prueba1.calcUltTermino(2),0.00);
	}

}
