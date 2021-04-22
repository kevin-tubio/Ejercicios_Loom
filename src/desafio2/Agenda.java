package desafio2;

public class Agenda {

	private Contacto[] contacto;
	private int indice;

	public Agenda() {
		this(10);
	}

	public Agenda(int cantidadDeContactos) {
		if (cantidadDeContactos <= 0 ) {
			throw new Error("La agenda debe tener al menos un contacto");
		}

		contacto = new Contacto[cantidadDeContactos];
		indice = 0;
	}	

	public void agendarContacto(String nombre, String apellido) {
		agendarContacto(nombre, "", apellido);
	}

	public void agendarContacto(String nombre, String segundoNombre, String apellido) {
		contacto[calcularIndice()] = new Contacto(nombre, apellido);
		this.indice++;
	}
	
	public void editarNombreDelContacto(int indiceDelContacto, String nombre, String apellido) {
		editarNombreDelContacto(indiceDelContacto, nombre, "", apellido);
	}
	
	public void editarNombreDelContacto(int indiceDelContacto, String nombre, String segundoNombre, String apellido) {
		if(!(contacto[indiceDelContacto-1] == null)) {
			contacto[indiceDelContacto-1].editarNombre(nombre, segundoNombre, apellido);;
		}
	}

	public void editarTelefonoDelContacto(int indiceDelContacto, Telefono telefono) {
		if(!(contacto[indiceDelContacto-1] == null)) {
			contacto[indiceDelContacto-1].editarTelefono(telefono);
		}
	}

	public void editarCorreoDelContacto(int indiceDelContacto, Correo correo) {
		if(!(contacto[indiceDelContacto-1] == null)) {
			contacto[indiceDelContacto-1].editarCorreoElectronico(correo);
		}
	}
	
	public void editarDireccionDelContacto(int indiceDelContacto, Direccion direccion) {
		if(!(contacto[indiceDelContacto-1] == null)) {
			contacto[indiceDelContacto-1].editarDireccion(direccion);
		}
	}

	public void editarCumpleañosDelContacto(int indiceDelContacto, int dia, int mes) {
		if(!(contacto[indiceDelContacto-1] == null)) {
			contacto[indiceDelContacto-1].editarCumpleaños(dia, mes);
		}
	}

	public void editarEmpresaDelContacto(int indiceDelContacto, String empresa) {
		contacto[indiceDelContacto].editarEmpresaDeTrabajo(empresa);
	}

	public void borrarContacto(int indiceDelContacto) {
		contacto[indiceDelContacto-1] = null;
	}

	public String mostrarDatosDelContacto(int indiceDelContacto) {
		if(contacto[indiceDelContacto-1] == null) {
			throw new Error("Contacto Nulo");
		}
		return contacto[indiceDelContacto-1].toString();
	}

	private int calcularIndice() {
		if(this.indice >= this.contacto.length) {
			throw new Error("agenda llena");
		}
		return indice;
	}

}
