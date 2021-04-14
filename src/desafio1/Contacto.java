package desafio1;

public class Contacto {

	private String nombre, segundoNombre, apellido, fechaDeCumple, empresa;

	private DatoDeContacto telefono, correo, direccion;

	public Contacto(String nombre, String apellido) {
		this(nombre, "", apellido);
	}

	public Contacto(String nombre, String segundoNombre, String apellido) {
		this.nombre = nombre;
		this.segundoNombre = segundoNombre;
		this.apellido = apellido;
		this.fechaDeCumple = "";
		this.empresa = "";
	}

	public void editarNombre(String nombre, String segundoNombre, String apellido) {
		this.nombre = nombre;
		this.segundoNombre = segundoNombre;
		this.apellido = apellido;
	}

	public void editarCumpleaños(int dia, int mes) {
		this.fechaDeCumple = new String(dia + "/"+ mes);
	}

	public void editarEmpresaDeTrabajo(String empresa) {
		this.empresa = empresa;
	}

	public void editarTelefono(Telefono telefono) {
		this.telefono = telefono;
	}

	public void editarCorreoElectronico(Correo correo) {
		this.correo = correo;
	}

	public void editarDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		String data = "Nombre: " + obtenerNombreCompleto() + ",\n" + 
				"Cumpleaños: " + this.fechaDeCumple + ",\n" +
				"Empresa: "+ this.empresa + ",\n";

		if(!(this.telefono == null)) {
			data = data.concat(this.telefono.toString() + ",\n");
		}
		if(!(this.correo == null)) {
			data = data.concat(this.correo.toString() + ",\n");
		}
		if(!(this.direccion == null)) {
			data = data.concat(this.direccion.toString() + ",\n");
		}

		return data;
	}

	private String obtenerNombreCompleto() {
		if(segundoNombre.length() != 0) {
			return nombre + " " + segundoNombre + " " + apellido;
		}
		return nombre + " " + apellido; 
	} 
}
