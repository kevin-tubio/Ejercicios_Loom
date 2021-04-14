package desafio3;

public class Empresa {

	private int indice;
	private Empleado[] lista;
	
	public Empresa() {
		this(15, 1);
	}
	
	public Empresa(int cantidadDeEmpleados) {
		this(cantidadDeEmpleados, 1);
	}
	
	/**
	 * pre : 'cantidadDeEmpleados' y 'unidadRetributiva' deben ser mayores a cero.
	 * @param cantidadDeEmpleados
	 * @param unidadRetributiva
	 */
	public Empresa(int cantidadDeEmpleados, double unidadRetributiva) {
		
		if(cantidadDeEmpleados <= 0) {
			throw new Error("La empresa debe poder almacenar al menos un empleado");
		}
		this.indice = 0;
		this.lista = new Empleado[cantidadDeEmpleados];
		actualizarUnidadRetributiva((unidadRetributiva > 0 ? unidadRetributiva : 1));
	}
	
	/**
	 * pre : el valor de 'unidadRetributiva' debe ser mayor o igual a 1.
	 * post: cambia el valor de 'unidadRetributiva'.
	 * @param unidadRetributiva
	 */
	public void actualizarUnidadRetributiva(double unidadRetributiva) {
		Empleado.actualizarUR(unidadRetributiva);
	}

	/**
	 * post: devuelve un String con la informacion de todos los empleados de la empresa sin liquidar el sueldo de cada uno.
	 * @return
	 */
	public String listarEmpleados() {
		String listado = ""; 
		for(Empleado empleado: this.lista) 
			if(empleado != null) 
				listado += empleado.toString() + "\n";

		return listado;
	}
	
	/**
	 * post: devuelve un String con la informacion de todos los empleados de la empresa.
	 * @return
	 */
	public String liquidarSueldos() {
		String listado = "";
		for(Empleado empleado: this.lista) {
			if(empleado != null)
				listado += empleado.toString() + " Sueldo: " + empleado.calcularSueldo() + "\n";
		}
		
		return listado;
	}
	
	/**
	 * post: agrega el 'empleado' a la empresa.
	 * @param empleado
	 */
	public void agregarEmpleado(Empleado empleado) {
		if(this.indice >= this.lista.length) {
			throw new Error("nomina Llena");
		}
		this.lista[indice] = empleado;
		this.indice++;
	}
}
