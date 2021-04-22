package desafio4;

public class Gerente extends EmpleadoPermanente {

	private int personalACargo;
	
	public Gerente(String nombre, String apellido) {
		this(nombre, apellido, false, 0, 0, 0);
	}
	
	public Gerente(String nombre, String apellido, boolean casado, int cantidadDeHijos, int antiguedad, int personalACargo) {
		super(nombre, apellido, casado, cantidadDeHijos, antiguedad);
		this.personalACargo = (personalACargo > 0 ? personalACargo : 0);
	}
	
	@Override
	public double calcularSueldo() {
		return super.calcularSueldo() + ((2000 * personalACargo) * obtenerUR());
	}
	
	@Override
	public String toString() {
		return super.toString() + ": gerente. Planta Permanente.";
	}
}
