package desafio5;

import static org.junit.Assert.*;
import org.junit.Test;

public class ContactoTest {

	@Test(expected = ContactoInvalidoEx.class)
	public void pruebaValidarNombreNulo() throws ContactoInvalidoEx {
		new Contacto(null, "apellido", "mail@mail");
	}

	@Test(expected = ContactoInvalidoEx.class)
	public void pruebaValidarApellidoNulo() throws ContactoInvalidoEx {
		new Contacto("nombre", null, "mail@mail");
	}
	
	@Test(expected = ContactoInvalidoEx.class)
	public void pruebaValidarMailNulo() throws ContactoInvalidoEx {
		new Contacto("nombre", "apellido", null);
	}
	
	@Test(expected = ContactoInvalidoEx.class)
	public void pruebaValidarMailErroneo() throws ContactoInvalidoEx {
		new Contacto("nombre", "apellido", "mail");
	}
	
	@Test
	public void pruebaValidarMailCorrecto() throws ContactoInvalidoEx {
		Contacto contactoDePrueba = new Contacto("nombre", "apellido", "mail@mail.com");
		assertEquals("nombre: nombre, apellido: apellido, mail: mail@mail.com", contactoDePrueba.toString());
	}
	
	@Test
	public void CompararContactosNoConsideraElMail() throws ContactoInvalidoEx {
		Contacto contactoDePrueba = new Contacto("nombre", "apellido", "mail@mail.com");
		assertTrue(contactoDePrueba.equals(new Contacto("nombre", "apellido", "@")));
	}
}
