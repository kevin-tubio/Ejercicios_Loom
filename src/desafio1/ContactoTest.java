package desafio1;

import org.junit.Assert;
import org.junit.Test;

public class ContactoTest {

	private Contacto contacto;

	@Test
	public void crearContactoSinSegundoNombre() {
		contacto = new Contacto("nombre", "apellido");

		String dataDelContacto = "Nombre: nombre apellido" + ",\n" + 
				"Cumpleaños: " + ",\n" +
				"Empresa: " + ",\n";

		Assert.assertEquals(dataDelContacto, contacto.toString());
	}

	@Test
	public void nombreCompletoConSegundoNombre() {
		contacto = new Contacto("nombre", "segundoNombre","apellido");

		String dataDelContacto = "Nombre: nombre segundoNombre apellido" + ",\n" + 
				"Cumpleaños: " + ",\n" +
				"Empresa: " + ",\n";

		Assert.assertEquals(dataDelContacto, contacto.toString());
	}

	@Test
	public void cambiarNombreYApellido() {
		contacto = new Contacto("nombre", "segundoNombre","apellido");

		contacto.editarNombre("nuevoNombre", "", "nuevoApellido");

		String dataDelContacto = "Nombre: nuevoNombre nuevoApellido" + ",\n" + 
				"Cumpleaños: " + ",\n" +
				"Empresa: " + ",\n";

		Assert.assertEquals(dataDelContacto, contacto.toString());
	}

	@Test
	public void cambiarNombreCompletoYAgregarEmpresa() {
		contacto = new Contacto("nombre", "segundoNombre","apellido");

		contacto.editarNombre("nuevoNombre", "", "nuevoApellido");
		contacto.editarEmpresaDeTrabajo("Nasa");

		String dataDelContacto = "Nombre: nuevoNombre nuevoApellido" + ",\n" + 
				"Cumpleaños: " + ",\n" +
				"Empresa: Nasa" + ",\n";

		Assert.assertEquals(dataDelContacto, contacto.toString());
	}

	@Test
	public void formatoDeFechaDeCumpleaños() {
		contacto = new Contacto("nombre", "apellido");

		contacto.editarCumpleaños(3, 1);

		String dataDelContacto = "Nombre: nombre apellido" + ",\n" + 
				"Cumpleaños: 3/1" + ",\n" +
				"Empresa: " + ",\n";

		Assert.assertEquals(dataDelContacto, contacto.toString());
	}

	@Test
	public void agregarTelefonoCelular() {
		contacto = new Contacto("nombre", "apellido");

		contacto.editarTelefono(new TelefonoCelular("12345678"));

		String dataDelContacto = "Nombre: nombre apellido" + ",\n" + 
				"Cumpleaños: " + ",\n" +
				"Empresa: " + ",\n" + 
				"Numero de Celular: 12345678" + ",\n";

		Assert.assertEquals(dataDelContacto, contacto.toString());
	}

	@Test
	public void agregarCorreoLaboral() {
		contacto = new Contacto("nombre", "apellido");

		contacto.editarCorreoElectronico(new CorreoLaboral("nombre.apellido@empresa.com"));

		String dataDelContacto = "Nombre: nombre apellido" + ",\n" + 
				"Cumpleaños: " + ",\n" +
				"Empresa: " + ",\n" + 
				"Direccion de correo laboral: nombre.apellido@empresa.com" + ",\n";

		Assert.assertEquals(dataDelContacto, contacto.toString());
	}

	@Test
	public void agregarDireccion() {
		contacto = new Contacto("nombre", "apellido");

		contacto.editarCorreoElectronico(new CorreoLaboral("nombre.apellido@empresa.com"));
		contacto.editarTelefono(new TelefonoCelular("12345678"));
		contacto.editarDireccion(new Direccion("calle", 1234, "localidad", "provincia", "pais"));

		String dataDelContacto = "Nombre: nombre apellido" + ",\n" + 
				"Cumpleaños: " + ",\n" +
				"Empresa: " + ",\n" + 
				"Numero de Celular: 12345678" + ",\n" +
				"Direccion de correo laboral: nombre.apellido@empresa.com" + ",\n" +
				"Direccion: calle 1234" + ",\n" +
				"Piso: 0" + ", " + "Depto: 0" + ",\n" +
				"Partido: " + ", " + "Localidad: localidad" + ",\n" + 
				"Provincia: provincia" + ", " + "Pais: pais" + ",\n";

		Assert.assertEquals(dataDelContacto, contacto.toString());
	}
}
