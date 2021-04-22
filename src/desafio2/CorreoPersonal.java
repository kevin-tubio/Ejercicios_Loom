package desafio2;

public class CorreoPersonal extends Correo{

	public CorreoPersonal(String direccionDeCorreo) {
		super(direccionDeCorreo);
	}

	@Override
	public String toString() {
		return "Direccion de correo personal: ".concat(super.toString());
	}

}
