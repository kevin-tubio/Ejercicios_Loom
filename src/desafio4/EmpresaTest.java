package desafio4;

import org.junit.Assert;
import org.junit.Test;

public class EmpresaTest {

	private Empresa amd;
	
	 @Test(expected = Error.class)
     public void crearEmpresaConMenos10Empleados() {
		amd = new Empresa(-10);
		}

	@Test(expected = Error.class)
	public void crearEmpresaCon0Empleados() {
		amd = new Empresa(0);	
	}
	
	@Test(expected = Error.class)
	public void listaLLenaLanzaError() {
		amd = new Empresa();
		
		for(int i = 0; i < 15; i++) {
			amd.agregarEmpleado(new PermanenteDeTiempoCompleto("Nombre", "Apellido"));
		}
		
		amd.agregarEmpleado(new Gerente("Nombre", "Apellido"));
	}

	@Test
	public void toStringDeGerenteEjecutaMetodoPropio() {
		amd = new Empresa();
		amd.agregarEmpleado(new Gerente("Nombre", "Apellido"));
		Assert.assertEquals("Nombre Apellido: gerente. Planta Permanente.\n", amd.listarEmpleados());
	}
	
	@Test
	public void toStringDeEmpleadoPermanenteDeTiempoCompletoEjecutaMetodoPropio() {
		amd = new Empresa();
		amd.agregarEmpleado(new PermanenteDeTiempoCompleto("Nombre", "Apellido"));
		Assert.assertEquals("Nombre Apellido: empleado/a a tiempo completo. Planta Permanente.\n", amd.listarEmpleados());
	}
	
	@Test
	public void toStringDeEmpleadoPermanenteDeTiempoParcialEjecutaMetodoPropio() {
		amd = new Empresa();
		amd.agregarEmpleado(new PermanenteDeTiempoParcial("Nombre", "Apellido"));
		Assert.assertEquals("Nombre Apellido: empleado/a a tiempo parcial. Planta Permanente.\n", amd.listarEmpleados());
	}
	
	@Test
	public void toStringDeEmpleadoTransitorioDeTiempoCompletoEjecutaMetodoPropio() {
		amd = new Empresa();
		amd.agregarEmpleado(new TransitorioDeTiempoCompleto("Nombre", "Apellido"));
		Assert.assertEquals("Nombre Apellido: empleado/a a tiempo completo. Planta Transitoria.\n", amd.listarEmpleados());
	}
	
	@Test
	public void toStringDeEmpleadoTransitorioDeTiempoParcialEjecutaMetodoPropio() {
		amd = new Empresa();
		amd.agregarEmpleado(new TransitorioDeTiempoParcial("Nombre", "Apellido"));
		Assert.assertEquals("Nombre Apellido: empleado/a a tiempo parcial. Planta Transitoria.\n", amd.listarEmpleados());
	}
}
