package desafio1;

public abstract class Telefono extends DatoDeContacto{

	private String numero;

	public Telefono(String numero) {
		this.numero = numero;
	}
	
	@Override 
	public String toString(){
		return this.numero;
	}
}
