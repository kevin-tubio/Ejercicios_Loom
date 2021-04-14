package desafio3;

public abstract class PermanenteSinCategoria extends EmpleadoPermanente {

	public PermanenteSinCategoria(String nombre, String apellido) {
		super(nombre, apellido);
	}

	public PermanenteSinCategoria(String nombre, String apellido, boolean casado, int cantidadDeHijos, int antiguedad) {
		super(nombre, apellido, casado, cantidadDeHijos, antiguedad);
	}

}
