package desafio2;

public class EmpleadoPermanenteDeTiempoParcial extends EmpleadoPermanente {

	public EmpleadoPermanenteDeTiempoParcial(String nombreCompleto) {
		super(nombreCompleto);
	}

	@Override
	public String toString() {
		return super.toString() + ": empleado/a a tiempo parcial. Planta Permanente.";
	}
}
