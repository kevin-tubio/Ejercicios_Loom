package desafio4;

public class TransitorioDeTiempoCompleto extends EmpleadoTransitorio {

	public TransitorioDeTiempoCompleto(String nombre, String apellido) {
		this(nombre, apellido, false, 0);
	}
	
	public TransitorioDeTiempoCompleto(String nombre, String apellido, boolean casado, int cantidadDeHijos) {
		super(nombre, apellido, casado, cantidadDeHijos);
	}
	
	@Override
	public double calcularSueldo() {
		return super.calcularSueldo();
	}
	
	@Override
	public String toString() {
		return super.toString() + ": empleado/a a tiempo completo. Planta Transitoria.";
	}

}
