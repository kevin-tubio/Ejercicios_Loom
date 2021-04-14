package desafio2;

public class EmpleadoTransitorioDeTiempoParcial extends EmpleadoTransitorio {

	public EmpleadoTransitorioDeTiempoParcial(String nombreCompleto) {
		super(nombreCompleto);
	}
	
	@Override
	public String toString() {
		return super.toString() + ": empleado/a a tiempo parcial. Planta Transitoria.";
	}
}
