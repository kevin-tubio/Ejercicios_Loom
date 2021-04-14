package desafio3;

public class TransitorioDeTiempoParcial extends EmpleadoTransitorio {

	private int horasTrabajadas;
	
	public TransitorioDeTiempoParcial(String nombre, String apellido) {
		this(nombre, apellido, false, 0, 0);
	}
	
	public TransitorioDeTiempoParcial(String nombre, String apellido, boolean casado, int cantidadDeHijos, int horasTrabajadas) {
		super(nombre, apellido, casado, cantidadDeHijos);
		this.horasTrabajadas = horasTrabajadas;
	}
	
	@Override
	public String toString() {
		return super.toString() + ": empleado/a a tiempo parcial. Planta Transitoria.";
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
}