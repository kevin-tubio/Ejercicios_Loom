package desafio6;

public class Proceso implements Comparable<Proceso>{

	public enum Estado { LISTO, FINALIZADO };
	
	private String nombre;
	private int prioridad, tiempoDeEjecucion, tiempoDeArribo;
	private Estado status;
	
	/**
	 * pre : 'prioridad' debe pertenecer al rango comprendido entre 1 y 5, siendo 1 la maxima prioridad; 
	 * 		 'tiempoDeEjecucion' debe ser positivo.
	 * @param prioridad
	 * @param tiempoDeEjecucion
	 */
	public Proceso(String nombre, int tiempoDeArribo, int tiempoDeEjecucion, int prioridad) {
		this.nombre = nombre;
		this.tiempoDeArribo = tiempoDeArribo;
		this.tiempoDeEjecucion = tiempoDeEjecucion;
		this.prioridad = prioridad;
		this.status = Estado.LISTO;
	}
	
	/**
	 * post: compara objetos de tipo proceso.
	 */
	/*@Override
	public boolean equals(Object obj) {
		
		if (this == obj) { return true; }		
		if (!(obj instanceof Proceso)) { return false; }
		
		Proceso other = (Proceso) obj;
		if (nombre == null) { 
			if (other.nombre != null) { return false; }
		}
		else if (!nombre.equals(other.nombre)) { return false; }
		
		if (prioridad != other.prioridad) { return false; }
		if (status != other.status) { return false; }
		if (tiempoDeEjecucion != other.tiempoDeEjecucion) { return false; }
		if (tiempoDeArribo != other.tiempoDeArribo) { return false; }
		
		return true;
	}*/

	/**
	 * post: Define un orden natural para el tipo Proceso. 
	 * @param 
	 * @return
	 *   the value 0 if 'this' == 'other';
	 *   a value less than 0 if 'this' < 'other'; 
	 *   and a value greater than 0 if 'this' > 'other'.
	 */
	@Override
 	public int compareTo(Proceso other) {
		
		if(this.equals(other)) { return 0;}
		
		if(this.prioridad == other.prioridad) {
			return Integer.compare(this.tiempoDeArribo, other.tiempoDeArribo);
		}
		return Integer.compare(this.prioridad, other.prioridad);
	}
	
	/**
	 * post: define el estado del proceso.
	 * @param status del proceso.
	 */
	public void setStatus(Estado status) { this.status = status; }
	
	/**
	 * @return status del proceso.
	 */
	public Estado getStatus(){ return this.status; }
	
	/**
	 * @return tiempo de arribo en cola de arribo.
	 */
	public int getT_Arribo() { return this.tiempoDeArribo; }
	
	/**
	 * @return tiempo que tarda en ejecutarse el proceso.
	 */
	public int getT_ejecucion() { return this.tiempoDeEjecucion; }
	
	@Override
 	public String toString() {
		return "| "+ this.nombre +  
				" |Tiempo de ejecución " + this.tiempoDeEjecucion + 
				" |Prioridad " + this.prioridad + " |";
	}
}
