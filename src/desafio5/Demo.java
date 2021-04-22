package desafio5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo {

	private static Agenda agenda;
	private static BufferedReader buffer;

	public static void main(String[] args) {
		try {
			agenda = new Agenda();
			buffer = new BufferedReader(new InputStreamReader(System.in));
			boolean ejecutando = true;
			String rutaDelArchivo;
			
			agenda.cargarArchivo("archivo/AgendaDefault.txt");
			
			while (ejecutando) {
				try {
					imprimirOpcionesMenu();
					int opcion = Integer.parseInt(buffer.readLine());

					switch (opcion) {
					case 1:
						presentarOpcion(opcion, "");
						agenda.mostrarContactos();
						esperarEnter();
						break;

					case 2:
						presentarOpcion(opcion, "Escriba la ruta y/o nombre del archivo");
						rutaDelArchivo = buffer.readLine();
						if(rutaDelArchivo == null || rutaDelArchivo.length() == 0) 
							throw new ArchivoPerdidoEx("La ruta del archivo no es valida");
						agenda.cargarArchivo(rutaDelArchivo);
						print("", "Contactos cargados:");
						agenda.mostrarContactos();
						agenda.guardarAgenda("archivo/AgendaDefault.txt");
						esperarEnter();
						break;

					case 3: 
						presentarOpcion(opcion, "Escriba la ruta y/o nombre del archivo");
						rutaDelArchivo = buffer.readLine();
						if(rutaDelArchivo == null || rutaDelArchivo.length() == 0) 
							throw new ArchivoPerdidoEx("La ruta del archivo no es valida");
						agenda.guardarAgenda(rutaDelArchivo);
						print("", "Archivo guardado exitosamente.");
						esperarEnter();
							
						break;

					case 4:
						presentarOpcion(opcion, "");
						print("Contacto agregado:", agenda.agregarContacto(recuperarContacto()).toString(), "");
						agenda.mostrarContactos();
						agenda.guardarAgenda("archivo/AgendaDefault.txt");
						esperarEnter();
						break;

					case 5:
						presentarOpcion(opcion, "");
						print("Contacto encontrado", agenda.buscarContacto(recuperarContactoSinMail()).toString());
						esperarEnter();
						break;

					case 6:
						presentarOpcion(opcion, "");
						Contacto aBorrar = agenda.buscarContacto(recuperarContactoSinMail());
						print("Contacto eliminado", agenda.borrarContacto(aBorrar).toString(), "");
						agenda.mostrarContactos();
						agenda.guardarAgenda("archivo/AgendaDefault.txt");
						esperarEnter();
						break;

					case 7:
						presentarOpcion(opcion, "Progama Terminado.");
						ejecutando = false;
						print("------------------------------------------------------------");
						break;

					default:
						throw new Exception("Opcion invalida, ingrese un numero");
					}

					
				}
				
				catch (ContactoEx e) {
					System.out.println(e.getMessage());
					esperarEnter();
				}

				catch (ArchivoPerdidoEx e) {
					System.out.println(e.getMessage());
					esperarEnter();
				}
				
				catch (NumberFormatException e) {
					System.out.println("Debe ingresar un numero");
					esperarEnter();
				}

				catch (Exception e) {
					System.out.println(e.getMessage());
					esperarEnter();
				}
			}

			buffer.close();

		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

	private static void esperarEnter() throws IOException {
		esperarEnter("------------------------------------------------------------");
	}

	private static void esperarEnter(String mensaje) throws IOException {
		print(mensaje, "Pulse enter para continuar");
		buffer.readLine();
	}

	private static void print(String... mensaje) {
		for (String msg : mensaje) {
			System.out.println(msg);
		}
	}

	private static Contacto recuperarContactoSinMail() throws IOException, ContactoEx {
		String nombre, apellido;
		
		print("", "Escriba el nombre del contacto", "--------------------------------------");
		nombre = buffer.readLine().strip();
				
		print("", "Escriba el apellido del contacto", "--------------------------------------");
		apellido = buffer.readLine().strip();
		
		print("");

		return new Contacto(nombre, apellido, "@");
	}
	
	private static Contacto recuperarContacto() throws IOException, ContactoEx {
		String nombre, apellido, mail;

		print("", "Escriba el nombre del contacto", "--------------------------------------");
		nombre = buffer.readLine().strip();
		
		print("", "Escriba el apellido del contacto", "--------------------------------------");
		apellido = buffer.readLine().strip();
		
		print("", "Escriba el mail del contacto", "--------------------------------------");
		mail = buffer.readLine().strip();
		
		print("");

		return new Contacto(nombre, apellido, mail);
	}

	private static void imprimirOpcionesMenu() {
		print("|***********************************************************|");
		print("|-----------Elija una opcion ingresando un entero-----------|");
		print("|                                                           |");
		print("| (1) Mostrar Agenda                                        |");
		print("| (2) Cargar  Archivo                                       |");
		print("| (3) Guardar Agenda                                        |");
		print("| (4) Agregar Contacto                                      |");
		print("| (5) Buscar  Contacto                                      |");
		print("| (6) Borrar  Contacto                                      |");
		print("| (7) Salir                                                 |");
		print("|___________________________________________________________|");
	}

	private static void presentarOpcion(int numeroDeOpcion, String mensaje) {
		print("*************************************************************", ("Opcion: " + numeroDeOpcion),
				"-------------", "");
		if (mensaje.length() > 0) {
			print(mensaje, "--------------------------------------");
		}
	}
}
