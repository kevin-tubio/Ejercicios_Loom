package desafio3;

public abstract class Empleado {
 
	private String nombreCompleto;
	
	public Empleado(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	
	@Override
	public String toString() {
		return nombreCompleto;
	}
}
