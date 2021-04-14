package desafio1;

public class Direccion extends DatoDeContacto{

	private String calle, localidad, partido, provincia, pais;
	private int numero, piso, numeroDepto;

	public Direccion(String calle, int numero, String localidad, String provincia, String pais) {
		this(calle, numero, 0, 0, localidad, "", provincia, pais);
	}

	public Direccion(String calle, int numero, int piso, int numeroDepto, String localidad, String partido, String provincia, String pais) {
		this.calle = calle;
		this.localidad = localidad;
		this.partido = partido;
		this.provincia = provincia;
		this.pais = pais;
		this.numero = numero;
		this.piso = piso;
		this.numeroDepto = numeroDepto;
	}

	@Override
	public String toString() {
		return "Direccion: " + this.calle + " " + numero + ",\n" +
				"Piso: " + piso + ", " + "Depto: " + numeroDepto + ",\n" +
				"Partido: " + partido + ", " + "Localidad: " + localidad + ",\n" + 
				"Provincia: " + provincia + ", " + "Pais: " + pais;
	}
}
