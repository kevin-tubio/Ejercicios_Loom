package desafio2;

public abstract class Correo extends DatoDeContacto{

	private String correo;

	public Correo(String correo) {
		this.correo = correo;
	}

	@Override
	public String toString() {
		return this.correo;
	}
}	
