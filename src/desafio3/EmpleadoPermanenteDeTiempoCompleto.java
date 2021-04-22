package desafio3;

public class EmpleadoPermanenteDeTiempoCompleto extends EmpleadoPermanente {

	public EmpleadoPermanenteDeTiempoCompleto(String nombreCompleto) {
		super(nombreCompleto);
	}
	
	@Override
	public String toString() {
		return super.toString() + ": empleado/a a tiempo completo. Planta Permanente.";
	}
}
