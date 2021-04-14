package desafio1;

import org.junit.Assert;
import org.junit.Test;

public class AgendaTest {

	private Agenda agenda;

	private String datosDelContacto = "Nombre: nombre apellido" + ",\n" + 
			"Cumpleaños: " + ",\n" +
			"Empresa: " + ",\n" +
			"Numero de Linea: 12345678" + ",\n" + 
			"Linea de Trabajo: " + ",\n" +
			"Numero de Celular: " + ",\n" +
			"Linea de Casa: " + ",\n" +
			"Direccion de correo personal: " + ",\n" +
			"Direccion de correo laboral: " + ",\n" +
			"Direccion: calle 1234" + ",\n" +
			"Piso: 0" + ", " + "Depto: 0" + ",\n" +
			"Partido: " + ", " + "Localidad: localidad" + ",\n" + 
			"Provincia: provincia" + ", " + "Pais: pais" + ",\n";


	@Test(expected = Error.class)
	public void agendaConCeroContactos() {
		new Agenda(0);
	}

	@Test(expected = Error.class)
	public void agendaConNegativoNumeroDeContactos() {
		new Agenda(-10);
	}

	@Test(expected = Error.class)
	public void consultarDatosDeContactoNulo() {
		agenda = new Agenda();

		agenda.mostrarDatosDelContacto(1);
	}

	@Test(expected = Error.class)
	public void consultarDatosDeContactoNoAgendado() {
		agenda = new Agenda();

		agenda.agendarContacto("nombre", "apellido");

		agenda.mostrarDatosDelContacto(2);
	}

	@Test
	public void agregarNumeroDeTelefonoAlContacto3() {
		agenda = new Agenda();

		agenda.agendarContacto("primer", "contacto");
		agenda.agendarContacto("segundo", "contacto");
		agenda.agendarContacto("tercer", "contacto");

		datosDelContacto = "Nombre: tercer contacto" + ",\n" + 
				"Cumpleaños: " + ",\n" +
				"Empresa: " + ",\n";

		Assert.assertEquals(datosDelContacto, agenda.mostrarDatosDelContacto(3));

		agenda.editarTelefonoDelContacto(3, new TelefonoFijo("12345678"));

		datosDelContacto = "Nombre: tercer contacto" + ",\n" + 
				"Cumpleaños: " + ",\n" +
				"Empresa: " + ",\n" +
				"Numero de Linea: 12345678" + ",\n";

		Assert.assertEquals(datosDelContacto, agenda.mostrarDatosDelContacto(3));
	}

	@Test(expected = Error.class)
	public void eliminarContacto2YMostrarSuData() {
		agenda = new Agenda();

		agenda.agendarContacto("primer", "contacto");
		agenda.agendarContacto("segundo", "contacto");
		agenda.agendarContacto("tercer", "contacto");

		datosDelContacto = "Nombre: segundo contacto" + ",\n" + 
				"Cumpleaños: " + ",\n" +
				"Empresa: " + ",\n";

		Assert.assertEquals(datosDelContacto, agenda.mostrarDatosDelContacto(2));

		agenda.borrarContacto(2);

		Assert.assertEquals(datosDelContacto, agenda.mostrarDatosDelContacto(2));
	}

	@Test
	public void editarDatoAdicionalContacto1() {
		agenda = new Agenda();

		agenda.agendarContacto("primer", "contacto");
		agenda.agendarContacto("segundo", "contacto");
		agenda.agendarContacto("tercer", "contacto");

		agenda.editarDireccionDelContacto(1, new Direccion("calle", 1234, "localidad", "provincia", "pais"));

		String datosDelContacto1 = "Nombre: primer contacto" + ",\n" + 
				"Cumpleaños: " + ",\n" +
				"Empresa: " + ",\n" +
				"Direccion: calle 1234" + ",\n" +
				"Piso: 0" + ", " + "Depto: 0" + ",\n" +
				"Partido: " + ", " + "Localidad: localidad" + ",\n" + 
				"Provincia: provincia" + ", " + "Pais: pais" + ",\n";

		Assert.assertEquals(datosDelContacto1, agenda.mostrarDatosDelContacto(1));

		agenda.editarDireccionDelContacto(1, new Direccion("avenida", 4567, "localidad", "provincia", "pais"));

		datosDelContacto1 = "Nombre: primer contacto" + ",\n" + 
				"Cumpleaños: " + ",\n" +
				"Empresa: " + ",\n" +
				"Direccion: avenida 4567" + ",\n" +
				"Piso: 0" + ", " + "Depto: 0" + ",\n" +
				"Partido: " + ", " + "Localidad: localidad" + ",\n" + 
				"Provincia: provincia" + ", " + "Pais: pais" + ",\n";

		Assert.assertEquals(datosDelContacto1, agenda.mostrarDatosDelContacto(1));
	}

	@Test
	public void editarDatoAdicionalContacto1NoAfectaContacto2() {
		agenda = new Agenda();

		agenda.agendarContacto("primer", "contacto");
		agenda.agendarContacto("segundo", "contacto");
		agenda.agendarContacto("tercer", "contacto");

		agenda.editarTelefonoDelContacto(2, new TelefonoFijo("12345678"));

		agenda.editarDireccionDelContacto(1, new Direccion("calle", 1234, "localidad", "provincia", "pais"));


		String datosDelContacto2 = "Nombre: segundo contacto" + ",\n" + 
				"Cumpleaños: " + ",\n" +
				"Empresa: " + ",\n" + 
				"Numero de Linea: 12345678" + ",\n";

		Assert.assertEquals(datosDelContacto2, agenda.mostrarDatosDelContacto(2));

		agenda.editarDireccionDelContacto(1, new Direccion("avenida", 4567, "localidad", "provincia", "pais"));

		Assert.assertEquals(datosDelContacto2, agenda.mostrarDatosDelContacto(2));
	}
}
