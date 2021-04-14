package desafio1;

public class TelefonoDeCasa extends Telefono{

	public TelefonoDeCasa(String numero) {
		super(numero);
	}

	@Override
	public String toString() {
		return "Linea de Casa: ".concat(super.toString());
	}

}
