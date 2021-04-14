package desafio0;

import org.junit.Test;
import org.junit.Assert;

public class TestSumadorArreglo {

	private SumadorArreglo sumador = new SumadorArreglo();

	@Test
	public void sumarArregloVacioDevuelveCero() {

		//Prepaci�n
		int[] arregloTest = {};

		//operaci�nn
		int resultado = sumador.sumarPosicionesPares(arregloTest);

		//verficaci�n
		Assert.assertEquals(0, resultado);
	}

	@Test(expected = Error.class)
	public void sumarArregloNuloDevuelveError() {

		//Prepaci�n
		int[] arregloTest = null;

		//operaci�nn
		sumador.sumarPosicionesPares(arregloTest);
	}

	@Test
	public void sumarArregloDeTamanoPar() {

		//Prepaci�n
		int[] arregloTest = {1, 2, 13 ,4, 8, 6};

		//operaci�nn
		int resultado = sumador.sumarPosicionesPares(arregloTest);

		//verficaci�n
		Assert.assertEquals(22, resultado);
	}

	@Test
	public void sumarArregloDeTamanoParImpar() {

		//Prepaci�n
		int[] arregloTest = {1, 2, 13 ,4, 8, 6, -22};

		//operaci�nn
		int resultado = sumador.sumarPosicionesPares(arregloTest);

		//verficaci�n
		Assert.assertEquals(0, resultado);
	}
}