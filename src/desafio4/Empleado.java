package desafio4;


public abstract class Empleado {
 
	private static double UNIDAD_RETRIBUTIVA = 1;
	private int cantidadDeHijos;
	private boolean casado;
	private String nombre, apellido;
	
	public Empleado(String nombre, String apellido) {
		this(nombre, apellido, false, 0);
	}
	
	public Empleado(String nombre, String apellido, boolean casado, int cantidadDeHijos) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.casado = casado;
		this.cantidadDeHijos = (cantidadDeHijos >= 0 ? cantidadDeHijos : 0);
	}
	
	/**
	 * post: devuelve el nombre completo del empleado.
	 */
	@Override
	public String toString() {
		return this.nombre + " " + this.apellido;
	}
	
	/**
	 * post: calcula el sueldo del empleado en base a la 'unidadRetributiva' y el grupo familiar.
	 * @param unidadRetributiva
	 * @return
	 */
	public double calcularSueldo() {
		return (1000 + (200 * cantidadDeHijos) + (casado ? 100 : 0)) * Empleado.UNIDAD_RETRIBUTIVA;
	}

	/**
	 * post: devuelve el valor de la unidad retributiva;
	 * @return
	 */
	public static double obtenerUR() {
		return Empleado.UNIDAD_RETRIBUTIVA;
	}
	
	/**
	 * pre : 'unidadRetributiva' debe ser mayor a 0; 
	 * post: actualiza el valor de 'unidadRetributiva';
	 * @param unidadRetributiva
	 */
	public static void actualizarUR(double unidadRetributiva) {
		Empleado.UNIDAD_RETRIBUTIVA = (unidadRetributiva > 0 ? unidadRetributiva : 1);
	}
}
