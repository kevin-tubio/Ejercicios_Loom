package desafio7;

import static org.junit.Assert.*;

import org.junit.Test;

public class ContadorDeRotacionTest {

	ContadorDeRotaciones arregloCircular = new ContadorDeRotaciones();

	@Test
	public void arregloDe1Numero() {
		int[] arreglo = { 20 };
		assertEquals(0, (arregloCircular.contarRotaciones(arreglo)));
	}

	@Test
	public void arregloDe2NumerosConsecutivosInicioPosicion0() {
		int[] arreglo = { 1, 2 };
		assertEquals(0, (arregloCircular.contarRotaciones(arreglo)));
	}

	@Test
	public void arregloDe2NumerosConsecutivosInicioPosicion1() {
		int[] arreglo = { 2, 1 };
		assertEquals(-1, (arregloCircular.contarRotaciones(arreglo)));
	}

	@Test
	public void arregloDe6NumerosNaturalesConsecutivosInicioPosicion0() {
		int[] arreglo = { 1, 2, 3, 4, 5, 6 };
		assertEquals(0, (arregloCircular.contarRotaciones(arreglo)));
	}

	@Test
	public void arregloDe6NumerosNaturalesConsecutivosInicioPosicion1() {
		int[] arreglo = { 6, 1, 2, 3, 4, 5 };
		assertEquals(-1, (arregloCircular.contarRotaciones(arreglo)));
	}

	@Test
	public void arregloDe6NumerosNaturalesConsecutivosInicioPosicion2() {
		int[] arreglo = { 5, 6, 1, 2, 3, 4 };
		assertEquals(-2, (arregloCircular.contarRotaciones(arreglo)));
	}

	@Test
	public void arregloDe6NumerosNaturalesConsecutivosInicioPosicion3() {
		int[] arreglo = { 4, 5, 6, 1, 2, 3 };
		assertEquals(-3, (arregloCircular.contarRotaciones(arreglo)));
	}

	@Test
	public void arregloDe6NumerosNaturalesConsecutivosInicioPosicion4() {
		int[] arreglo = { 3, 4, 5, 6, 1, 2 };
		assertEquals(2, (arregloCircular.contarRotaciones(arreglo)));
	}

	@Test
	public void arregloDe6NumerosNaturalesConsecutivosInicioPosicion5() {
		int[] arreglo = { 2, 3, 4, 5, 6, 1 };
		assertEquals(1, (arregloCircular.contarRotaciones(arreglo)));
	}

	@Test
	public void arregloDe11NumerosNaturalesConsecutivosInicioPosicion3() {
		int[] arreglo = { 9, 10, 11, 1, 2, 3, 4, 5, 6, 7, 8 };
		assertEquals(-3, (arregloCircular.contarRotaciones(arreglo)));
	}

	@Test
	public void arregloDe17NumerosNaturalesConsecutivosInicioPosicion10() {
		int[] arreglo = { 9, 10, 11, 12, 13, 14, 15, 16, 17, 1, 2, 3, 4, 5, 6, 7, 8 };
		assertEquals(8, (arregloCircular.contarRotaciones(arreglo)));
	}

	@Test
	public void arregloDe33NumerosNaturalesConsecutivosInicioPosicion29() {
		int[] arreglo = { 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29,
				30, 31, 32, 33, 1, 2, 3, 4 };
		assertEquals(4, (arregloCircular.contarRotaciones(arreglo)));
	}

	@Test
	public void arregloDe33NumerosNaturalesConsecutivosInicioPosicion0() {
		int[] arreglo = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26,
				27, 28, 29, 30, 31, 32, 33 };
		assertEquals(0, (arregloCircular.contarRotaciones(arreglo)));
	}

	@Test
	public void arregloDe33NumerosNaturalesConsecutivosInicioPosicion32() {
		int[] arreglo = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26,
				27, 28, 29, 30, 31, 32, 33, 1 };
		assertEquals(1, (arregloCircular.contarRotaciones(arreglo)));
	}

	@Test
	public void arregloDe8NumerosNegativosNoConsecutivosInicioPosicion2() {
		int[] arreglo = { -3, -2, -20, -15, -10, -5, -4 };
		assertEquals(-2, (arregloCircular.contarRotaciones(arreglo)));
	}

	@Test
	public void arregloDe6NumerosNaturalesNoConsecutivosInicioPosicion4() {
		int[] arreglo = { 8, 9, 10, 2, 4, 6 };
		assertEquals(-3, (arregloCircular.contarRotaciones(arreglo)));
	}

	@Test
	public void arregloDe12NumerosNaturalesNoConsecutivosInicioPosicion3() {
		int[] arreglo = { 17, 21, 23, 1, 3, 5, 7, 8, 9, 11, 13 };
		assertEquals(-3, (arregloCircular.contarRotaciones(arreglo)));
	}

	@Test
	public void arregloDe6NumerosEnterosNoConsecutivosInicioPosicion5() {
		int[] arreglo = { 2, 3, 4, 5, 6, -6, -5, 1 };
		assertEquals(3, (arregloCircular.contarRotaciones(arreglo)));
	}

	@Test
	public void arregloDe8NumerosNegativosConsecutivosInicioPosicion3() {
		int[] arreglo = { -3, -2, -1, -8, -7, -6, -5, -4 };
		assertEquals(-3, (arregloCircular.contarRotaciones(arreglo)));
	}

	@Test
	public void arregloRotadoUnaSolaVezDevuelve1() {
		ContadorDeRotaciones contador = new ContadorDeRotaciones();
		int[] a = { 2, 3, 4, 5, 6, 1 };
		
		int resultado = contador.contarRotaciones(a);
		
		assertEquals(1, resultado);
	}
	
	@Test
	public void arregloRotadoALaMitadDevuelveMenosMitad() {
		ContadorDeRotaciones contador = new ContadorDeRotaciones();
		int[] a = { 8, 9, 10, 2, 4, 6 };
		
		int resultado = contador.contarRotaciones(a);
		
		assertEquals(-3, resultado);
	}
	
	@Test
	public void arregloNoRotadoDevuelve0() {
		ContadorDeRotaciones contador = new ContadorDeRotaciones();
		int[] a = { 1, 2, 3, 4, 5, 6 };
		
		int resultado = contador.contarRotaciones(a);
		
		assertEquals(0, resultado);
	}
	
	@Test
	public void arregloDeSeisElementosRotado5VecesDevuelveMenos1() {
		ContadorDeRotaciones contador = new ContadorDeRotaciones();
		int[] a = { 6, 1, 2, 3, 4, 5 };
		
		int resultado = contador.contarRotaciones(a);
		
		assertEquals(-1, resultado);
	}
	
	@Test
	public void arregloElementosNegativosDevuelve0() {
		ContadorDeRotaciones contador = new ContadorDeRotaciones();
		int[] a = { -32, -15, -12, -1, 1, 5 };
		
		int resultado = contador.contarRotaciones(a);
		
		assertEquals(0, resultado);
	}
	
	@Test
	public void arregloElementosNegativosDevuelveMenos2() {
		ContadorDeRotaciones contador = new ContadorDeRotaciones();
		int[] a = { 1, 5, -32, -15, -12, -1 };
		
		int resultado = contador.contarRotaciones(a);
		
		assertEquals(-2, resultado);
	}
	
	@Test
	public void arregloDevuelveMenos1() {
		ContadorDeRotaciones contador = new ContadorDeRotaciones();
		int[] a = { 5, 1, 2 };
		
		int resultado = contador.contarRotaciones(a);
		
		assertEquals(-1, resultado);
	}
	
	@Test
	public void arregloChicoDevuelveMenos1() {
		ContadorDeRotaciones contador = new ContadorDeRotaciones();
		int[] a = { 5, 1};
		
		int resultado = contador.contarRotaciones(a);
		
		assertEquals(-1, resultado);
	}
	
	@Test
	public void arregloChicoDevuelve0() {
		ContadorDeRotaciones contador = new ContadorDeRotaciones();
		int[] a = { 1, 6 };
		
		int resultado = contador.contarRotaciones(a);
		
		assertEquals(0, resultado);
	}
	
	@Test
	public void arregloGrandeDevuelve3() {
		ContadorDeRotaciones contador = new ContadorDeRotaciones();
		int[] a = { 5, 6, 7, 11, 15, 18, 20, 0, 1, 3 };
		
		int resultado = contador.contarRotaciones(a);
		
		assertEquals(3, resultado);
	}
}
