package desafio1;

public class TelefonoFijo extends Telefono {

	public TelefonoFijo(String numero) {
		super(numero);
	}

	@Override
	public String toString() {
		return "Numero de Linea: ".concat(super.toString());
	}

}
