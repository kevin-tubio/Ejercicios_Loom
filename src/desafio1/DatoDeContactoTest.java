package desafio1;

import org.junit.Assert;
import org.junit.Test;

public class DatoDeContactoTest {

	private DatoDeContacto dato;

	@Test
	public void telefonoFijoMostrarData() {
		dato = new TelefonoFijo("123456789");

		Assert.assertEquals("Numero de Linea: 123456789", dato.toString());
	}

	@Test
	public void celularMostrarData() {
		dato = new TelefonoCelular("123456789");

		Assert.assertEquals("Numero de Celular: 123456789", dato.toString());
	}

	@Test
	public void telefonoLaboralMostrarData() {
		dato = new TelefonoDeTrabajo("123456789");

		Assert.assertEquals("Linea de Trabajo: 123456789", dato.toString());
	}

	@Test
	public void correoPersonalMostrarData() {
		dato = new CorreoPersonal("nombre.apellido@empresa.com");

		Assert.assertEquals("Direccion de correo personal: nombre.apellido@empresa.com", dato.toString());
	}

	@Test
	public void correoLaboralMostrarData() {
		dato = new CorreoLaboral("nombre.apellido@empresa.com");

		Assert.assertEquals("Direccion de correo laboral: nombre.apellido@empresa.com", dato.toString());
	}

	@Test
	public void direccionBasicaMostrarDireccion() {
		dato = new Direccion("calle", 1234, "localidad", "provincia", "pais");

		String data = "Direccion: calle 1234" + ",\n" +
				"Piso: 0" + ", " + "Depto: 0" + ",\n" +
				"Partido: " + ", " + "Localidad: localidad" + ",\n" + 
				"Provincia: provincia" + ", " + "Pais: pais";

		Assert.assertEquals(data, dato.toString());
	}
}
