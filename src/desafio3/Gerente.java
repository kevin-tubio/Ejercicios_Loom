package desafio3;

public class Gerente extends EmpleadoPermanente {

	public Gerente(String nombreCompleto) {
		super(nombreCompleto);
	}
	
	@Override
	public String toString() {
		return super.toString() + ": gerente. Planta Permanente.";
	}
}
