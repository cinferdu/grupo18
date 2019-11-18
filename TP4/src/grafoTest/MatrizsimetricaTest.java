package grafoTest;

import static org.junit.Assert.*;

import org.junit.Test;

import grafo.MatrizSimetrica;

public class MatrizsimetricaTest {

	@Test
	public void test() {
		MatrizSimetrica ms = new MatrizSimetrica(8);
		assertEquals(ms.getOrden(), 8);
		ms.setValor(0, 2, true);
		ms.setValor(1, 2, true);
		ms.setValor(0, 3, true);
		ms.setValor(1, 4, true);
		ms.setValor(0, 5, true);
		ms.setValor(1, 6, true);
		ms.setValor(3, 2, true);
		ms.setValor(4, 3, true);
		assertEquals(ms.getValor(0, 2), true);
		assertEquals(ms.getValor(1, 2), true);
		assertEquals(ms.getValor(0, 3), true);
		assertEquals(ms.getValor(1, 4), true);
		assertEquals(ms.getValor(0, 5), true);
		assertEquals(ms.getValor(1, 6), true);
		assertEquals(ms.getValor(3, 2), true);
		assertEquals(ms.getValor(3, 4), true);
	}

}
