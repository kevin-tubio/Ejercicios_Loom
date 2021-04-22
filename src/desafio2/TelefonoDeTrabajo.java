package desafio2;

public class TelefonoDeTrabajo extends Telefono {

	public TelefonoDeTrabajo(String numero) {
		super(numero);
	}

	@Override
	public String toString() {
		return "Linea de Trabajo: ".concat(super.toString());
	}

}

