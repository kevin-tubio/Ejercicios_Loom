package desafio5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class InterpretadorDeArchivo {

	private LinkedList<Contacto> lista;

	/**
	 * post: Interpreta la informacion de un archivo en una lista de contactos.
	 * @param pArchivo
	 * @return
	 * @throws ArchivoPerdidoEx
	 */
	public LinkedList<Contacto> obtenerLista(String pArchivo) throws ArchivoPerdidoEx {
		try {
			BufferedReader lector = new BufferedReader(new FileReader(pArchivo));
			lista = new LinkedList<Contacto>();
			
			try { prepararLista(lector); } 
			
			finally { lector.close(); }
		
		} catch (FileNotFoundException e) {
			throw new ArchivoPerdidoEx("No se encontro el archivo en: " + pArchivo);
		
		} catch (NullPointerException e) {
			throw new ArchivoPerdidoEx("Debe especificar una ruta y/o nombre de archivo");
		
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		return lista;
	}

	/**
	 * post: Lee el archivo y separa cada linea del mismo en data mas manejable para la creacion de contactos.
	 * 		 Si logra crear un contacto, lo agrega a la lista de contactos. 
	 * @param lector -El lector usado para leer el archivo.
	 * @throws IOException
	 */
	private void prepararLista(BufferedReader lector) throws IOException {
		String contactoAInterpretar = lector.readLine();
		int lineaActual = 1;
		
		while (contactoAInterpretar != null) {
			if (!contactoAInterpretar.strip().isEmpty()) {
				
				Contacto nuevoContacto = interpretarContacto(contactoAInterpretar.split(","), lineaActual);
					
				if (nuevoContacto != null) 
					lista.add(nuevoContacto);
			}

			contactoAInterpretar = lector.readLine();
			lineaActual++;
		}
	}

	/**
	 * post: Trata de crear un contacto con la data del archivo.
	 * @param datos
	 * @return
	 * @throws Exception
	 */
	private Contacto interpretarContacto(String[] datos, int lineaDelArchivo) {		
		try {
			if ((datos.length > 3 || datos.length <= 0)) 
				throw new ContactoInvalidoEx("Cantidad de parametros invalido.");

			
			String nombre = datos[0].split("nombre:")[1].strip();
			String apellido = datos[1].split("apellido:")[1].strip();
			String mail = datos[2].split("mail:")[1].strip();
			
			return new Contacto(nombre, apellido, mail);
		}

		catch (IndexOutOfBoundsException e) {
			
			System.out.println("Linea: " + lineaDelArchivo + ". " + "Parametro mal formateado.");
			return null;
		}
		
		catch (ContactoInvalidoEx e) { 
			System.out.println("Linea: " + lineaDelArchivo + ". " + e.getMessage());
			return null; 
		}
		
		catch (Exception e) {
			System.out.println("Linea: " + lineaDelArchivo + ". " + e.getMessage());
			return null;
		}
	}
}
