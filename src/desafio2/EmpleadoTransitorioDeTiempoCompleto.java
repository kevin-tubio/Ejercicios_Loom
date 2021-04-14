package desafio2;

public class EmpleadoTransitorioDeTiempoCompleto extends EmpleadoTransitorio {

	public EmpleadoTransitorioDeTiempoCompleto(String nombreCompleto) {
		super(nombreCompleto);
	}
	
	@Override
	public String toString() {
		return super.toString() + ": empleado/a a tiempo completo. Planta Transitoria.";
	}

}
