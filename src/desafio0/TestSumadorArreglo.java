package desafio0;

import org.junit.Test;
import org.junit.Assert;

public class TestSumadorArreglo {

	private SumadorArreglo sumador = new SumadorArreglo();

	@Test
	public void sumarArregloVacioDevuelveCero() {

		//Prepación
		int[] arregloTest = {};

		//operaciónn
		int resultado = sumador.sumarPosicionesPares(arregloTest);

		//verficación
		Assert.assertEquals(0, resultado);
	}

	@Test(expected = Error.class)
	public void sumarArregloNuloDevuelveError() {

		//Prepación
		int[] arregloTest = null;

		//operaciónn
		sumador.sumarPosicionesPares(arregloTest);
	}

	@Test
	public void sumarArregloDeTamanoPar() {

		//Prepación
		int[] arregloTest = {1, 2, 13 ,4, 8, 6};

		//operaciónn
		int resultado = sumador.sumarPosicionesPares(arregloTest);

		//verficación
		Assert.assertEquals(22, resultado);
	}

	@Test
	public void sumarArregloDeTamanoParImpar() {

		//Prepación
		int[] arregloTest = {1, 2, 13 ,4, 8, 6, -22};

		//operaciónn
		int resultado = sumador.sumarPosicionesPares(arregloTest);

		//verficación
		Assert.assertEquals(0, resultado);
	}
}