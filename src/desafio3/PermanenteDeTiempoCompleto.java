package desafio3;

public class PermanenteDeTiempoCompleto extends PermanenteSinCategoria {

	public PermanenteDeTiempoCompleto(String nombre, String apellido) {
		this(nombre, apellido, false, 0, 0);
	}
	
	public PermanenteDeTiempoCompleto(String nombre, String apellido, boolean casado, int cantidadDeHijos, int antiguedad) {
		super(nombre, apellido, casado, cantidadDeHijos, antiguedad);
	}
	
	/**
	 * post: calcula el sueldo del empleado en base a la 'unidadRetributiva', el grupo familiar y la antiguedad del empleado.
	 * @param unidadRetributiva
	 * @return
	 */
	@Override
	public double calcularSueldo() {
		return super.calcularSueldo();
	}
	
	@Override
	public String toString() {
		return super.toString() + ": empleado/a a tiempo completo. Planta Permanente.";
	}
}
