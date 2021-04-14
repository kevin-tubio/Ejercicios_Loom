package desafio1;

public class TelefonoCelular extends Telefono{

	public TelefonoCelular(String numero) {
		super(numero);
	}

	@Override
	public String toString() {
		return "Numero de Celular: ".concat(super.toString());
	}
}
