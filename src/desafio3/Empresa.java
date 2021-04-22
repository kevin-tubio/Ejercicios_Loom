package desafio3;

public class Empresa {

	private int indice;
	private Empleado[] lista;
	
	public Empresa() {
		this(15);
	}
	
	public Empresa(int cantidadDeEmpleados) {
		this.lista = new Empleado[cantidadDeEmpleados];
	}
	
	public String listarEmpleados() {
		String listado = ""; 
		for(Empleado lista : lista) {
			if(lista == null) 
				continue;
			listado += lista.toString() + "\n";
		}
		return listado;
	}
	
	public void agregarEmpleado(Empleado empleado) {
		if(indice >= lista.length) {
			throw new Error("nomina Llena");
		}
		lista[indice] = empleado;
		indice++;
	}
}
