package desafio5;

import java.util.LinkedList;
import java.util.Iterator;

public class Agenda {

	private LinkedList<Contacto> lista = new LinkedList<Contacto>();

	/**
	 * Carga todos los contactos que puede en la agenda.
	 * El formato del archivo de entrada es el siguiente:
	 * Una línea por cada contacto, y en cada linea separado por coma
	 * y etiquetados los datos del contacto. Ej
	 * nombre: Juan, apellido: Perez, mail: jperez@gmail.com
	 * @param pArchivo nombre del archivo (path absoluto o
	 * relativo a la carpeta src del proyecto)
	 */
	public void cargarArchivo(String pArchivo) {
		InterpretadorDeArchivo interpretador = new InterpretadorDeArchivo();
		
		try { lista.addAll(interpretador.obtenerLista(pArchivo)); } 		
		
		catch (ArchivoPerdidoEx e) { System.out.println(e.getMessage()); }
	}
	
	/**
	 * Guarda la agenda completa en disco, en el archivo especificado como parámetro.
	 * Cada línea del archivo corresponda a una Persona.
	 * Los datos están separados por coma (,) y cada uno de los datos están etiquetados de la forma "etiqueta: valor"
	 * Ejemplo: "nombre: Juan, apellido: Perez, mail: jperez@gmail.com"
	 * @param pArchivo nombre del archivo (path absoluto o 
	 * relativo a la carpeta src del proyecto)
	 */
	public void guardarAgenda(String pArchivo) {
		EscritorDeArchivo escritor = new EscritorDeArchivo(pArchivo);
	
		Iterator<Contacto> iterador = lista.iterator();
		while(iterador.hasNext()) {
			escritor.escribirLineaEnArchivo(iterador.next().toString());   
		}
	}
	
	/**
	 * pre : 'contacto' es distinto de null.
	 * post: Agrega el contacto a la lista.
	 * @param contacto
	 * @throws ContactoEx Si no se cumple la precondicion.
	 */
	public Contacto agregarContacto(Contacto contacto) throws ContactoEx {
		if(contacto == null) 
			throw new ContactoInexistenteEx("No se ha podrido agregar el contacto.");
		lista.add(contacto);
		return contacto;
	}
	
	/**
	 * pre : 'contacto' es distinto de null y pertenece a la lista.
	 * post: Elimina el contacto de la lista.
	 * @param contacto
	 * @throws ContactoEx Si no se cumple la precondicion.
	 */
	public Contacto borrarContacto(Contacto contacto) throws ContactoEx {
		if(!lista.remove(contacto)) 
			throw new ContactoInexistenteEx("El contacto que intenta borrar no existe");
		return contacto;
	}
	
	/**
	 * pre : 'contacto' no debe ser nulo.
	 * post: Imprime en pantalla si el contacto se encuentra en la lista.
	 * @param contacto
	 * @throws ContactoEx Si el contacto no se encuentra en la lista.
	 */
	public Contacto buscarContacto(Contacto contacto) throws ContactoEx {
		if(contacto == null)
			throw new ContactoInexistenteEx("El contacto a buscar no puede ser nulo");
		
		if(!lista.contains(contacto))  
			throw new ContactoInexistenteEx("El contacto no se encuentra en la lista");
		
		return lista.get(lista.indexOf(contacto));
	}
	
	/**
	 * post: Devuelve por consola una representacion de la lista de contactos.
	 */
	public void mostrarContactos() {
		Iterator<Contacto> iterador = lista.iterator();
		
		while(iterador.hasNext()) {
			System.out.println(iterador.next().toString());
		}
	}
}
