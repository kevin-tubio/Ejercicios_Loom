package desafio4;

public abstract class EmpleadoTransitorio extends Empleado {

	public EmpleadoTransitorio(String nombre, String apellido) {
		this(nombre, apellido, false, 0);
	}
	
	public EmpleadoTransitorio(String nombre, String apellido, boolean casado, int cantidadDeHijos) {
		super(nombre, apellido, casado, cantidadDeHijos);
	}
}
