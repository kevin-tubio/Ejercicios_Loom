package desafio3;

public abstract class EmpleadoPermanente extends Empleado {

	private int antiguedad;
	
	public EmpleadoPermanente(String nombre, String apellido) {
		this(nombre, apellido, false, 0, 0);
	}
	
	public EmpleadoPermanente(String nombre, String apellido, boolean casado, int cantidadDeHijos, int antiguedad) {
		super(nombre, apellido, casado, cantidadDeHijos);
		this.antiguedad = (antiguedad > 0 ? antiguedad : 0);
	}
	
	/**
	 * post: calcula el sueldo del empleado en base a la 'unidadRetributiva', el grupo familiar y la antiguedad del empleado.
	 * @param unidadRetributiva
	 * @return
	 */
	@Override
	public double calcularSueldo() {
		return super.calcularSueldo() + (100 * (antiguedad <= 20 ? antiguedad : 20)) * obtenerUR();
	}
	
}
