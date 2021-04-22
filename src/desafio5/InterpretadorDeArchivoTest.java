package desafio5;

import static org.junit.Assert.*;
import org.junit.Test;

public class InterpretadorDeArchivoTest {

	@Test(expected = ArchivoPerdidoEx.class)
	public void rutaOArchivoNulo() throws ArchivoPerdidoEx {			
		new InterpretadorDeArchivo().obtenerLista(null);
	}

	@Test
	public void contactoObtenidoConExito() throws Exception {		
		InterpretadorDeArchivo interpretador = new InterpretadorDeArchivo();
		String direccion = "archivo/AgendaDefault.txt";
		
		assertEquals(interpretador.obtenerLista(direccion).get(0), new Contacto("Fabian", "Lagorio", "falago@gmail.com"));
	}
	
	@Test
	public void segundoEnListaDefectuosaEsAndresYNoLeonardo() throws Exception {
		InterpretadorDeArchivo interpretador = new InterpretadorDeArchivo();
		String direccion = "archivo/exported.txt";
		
		assertEquals(interpretador.obtenerLista(direccion).get(1), new Contacto("Andres", "Juarez", "ajuarez@untref.edu.ar"));
	}
}
