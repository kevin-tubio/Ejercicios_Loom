package desafio2;

public class CorreoLaboral extends Correo{

	public CorreoLaboral(String correo) {
		super(correo);
	}

	@Override
	public String toString() {
		return "Direccion de correo laboral: ".concat(super.toString());
	}
}
