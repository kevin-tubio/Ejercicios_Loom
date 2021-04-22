package desafio5;

public class ArchivoPerdidoEx extends Exception {

	private static final long serialVersionUID = -1227142762514052858L;

	public ArchivoPerdidoEx() {}

	public ArchivoPerdidoEx(String message) {
		super(message);
	}
}
