package desafio5;

public abstract class ContactoEx extends Exception {

	private static final long serialVersionUID = -6731357440270504192L;

	public ContactoEx() {}

	public ContactoEx(String message) {
		super(message);
	}
}
