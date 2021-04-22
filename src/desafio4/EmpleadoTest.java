package desafio4;

import org.junit.Assert;

import org.junit.Test;

public class EmpleadoTest {

	private Empleado empleadoDePrueba;
	
	@Test
	public void gerenteSinFamiliaY2EmpleadosACargoFactura5000() {
		empleadoDePrueba = new Gerente("Pedro", "Perez", false, 0, 0, 2);	
		Assert.assertEquals(5000, empleadoDePrueba.calcularSueldo(), 0.01);
	}

	@Test
	public void gerenteDe15AñosCasadoCon3HijosY5EmpleadosACargoFactura13200() {
		empleadoDePrueba = new Gerente("Pedro", "Perez", true, 3, 15, 5);
		
		Assert.assertEquals(13200, empleadoDePrueba.calcularSueldo(), 0.01);
	}
	
	@Test
	public void gerenteDe30AñosCasadoCon3HijosY5EmpleadosACargoFactura13700() {
		empleadoDePrueba = new Gerente("Pedro", "Perez", true, 3, 30, 5);
		
		Assert.assertEquals(13700, empleadoDePrueba.calcularSueldo(), 0.01);
	}
	
	@Test
	public void gerenteDe30AñosCasadoCon3HijosY5EmpleadosACargoFactura2055000ConUR150() {
		empleadoDePrueba = new Gerente("Pedro", "Perez", true, 3, 30, 5);
		Empleado.actualizarUR(150);
		
		Assert.assertEquals(2055000, empleadoDePrueba.calcularSueldo(), 0.01);
		Empleado.actualizarUR(1);
	}
	
	@Test
	public void EmpleadoSinFamiliaNiAntiguedadDePlantaPermanateATiempoCompletoFactura1000() {
		empleadoDePrueba = new PermanenteDeTiempoCompleto("Pedro", "Perez");
		
		Assert.assertEquals(1000, empleadoDePrueba.calcularSueldo(), 0.01);
	}
	
	@Test
	public void EmpleadoCasadoSinHijosSinAntiguedadDePlantaPermanateATiempoCompletoFactura1100() {
		empleadoDePrueba = new PermanenteDeTiempoCompleto("Pedro", "Perez", true, 0 , 0);
		
		Assert.assertEquals(1100, empleadoDePrueba.calcularSueldo(), 0.01);
	}
	
	@Test
	public void EmpleadoCasadoSinHijosSinAntiguedadDePlantaPermanateATiempoParcialSinHorasTrebajadasFactura433Punto3() {
		empleadoDePrueba = new PermanenteDeTiempoParcial("Pedro", "Perez", true, 0, 0, 0);
		
		Assert.assertEquals((int)(1000/3.0 + 100), empleadoDePrueba.calcularSueldo(), 0.01);
	}
	
	@Test
	public void EmpleadoCasado5HijosSinAntiguedadDePlantaPermanateATiempoParcialFactura1433Punto3() {
		empleadoDePrueba = new PermanenteDeTiempoParcial("Pedro", "Perez", true, 5, 0, 0);
		
		Assert.assertEquals((int)(1000/3.0 + 1100) , empleadoDePrueba.calcularSueldo(), 0.01);
	}
	
	@Test
	public void EmpleadoCasad0Antiguedad8DePlantaPermanateATiempoParcialFactura1233Punto3() {
		empleadoDePrueba = new PermanenteDeTiempoParcial("Pedro", "Perez", true, 0, 8, 0);
		
		Assert.assertEquals((int)(1000/3.0 + 900) , empleadoDePrueba.calcularSueldo(), 0.01);
	}
	
	@Test
	public void EmpleadoCasad0Antiguedad8DePlantaPermanateATiempoParcialCon58HorasTrabajadasFactura1233Punto3() {
		empleadoDePrueba = new PermanenteDeTiempoParcial("Pedro", "Perez", true, 0, 8, 58);
		
		Assert.assertEquals((int)(1000/3.0 + 900 + 10 * 58), empleadoDePrueba.calcularSueldo(), 0.01);
	}
	
	@Test
	public void EmpleadoCasad0Antiguedad8DePlantaPermanateATiempoParcialCon258HorasTrabajadasFactura1233Punto3() {
		empleadoDePrueba = new PermanenteDeTiempoParcial("Pedro", "Perez", true, 0, 8, 258);
		
		Assert.assertEquals(1000 + 900, empleadoDePrueba.calcularSueldo(), 0.01);
	}
}
