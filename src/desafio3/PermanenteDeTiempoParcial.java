package desafio3;

public class PermanenteDeTiempoParcial extends PermanenteSinCategoria {

	private int horasTrabajadas;
	
	public PermanenteDeTiempoParcial(String nombre, String apellido) {
		this(nombre, apellido, false, 0, 0, 0);
	}
	
	public PermanenteDeTiempoParcial(String nombre, String apellido, boolean casado, int cantidadDeHijos, int antiguedad, int horasTrabajadas) {
		super(nombre, apellido, casado, cantidadDeHijos, antiguedad);
		this.horasTrabajadas = horasTrabajadas;
	}
	
	/**
	 * post: calcula el sueldo del empleado en base al tercio del salario basico + adicionales.
	 * @return
	 */
	@Override
	public double calcularSueldo() {
		double ur = Empleado.obtenerUR();
		double porHora = ((1000 * ur/3) + 10 * horasTrabajadas * ur);  		
		return (int)(porHora >= 1000 * ur ? super.calcularSueldo() : porHora + (super.calcularSueldo() - 1000 * ur));
	}

	@Override
	public String toString() {
		return super.toString() + ": empleado/a a tiempo parcial. Planta Permanente.";
	}
}
