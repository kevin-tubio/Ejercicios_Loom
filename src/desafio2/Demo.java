package desafio2;

public class Demo {

	public static void main(String[] args) {
		Empresa empresa = new Empresa(); 
		
		System.out.println(empresa.listarEmpleados());
		System.out.println("-------------------------------------------------------");
		empresa.agregarEmpleado(new Gerente("Ana García"));
		empresa.agregarEmpleado(new EmpleadoTransitorioDeTiempoCompleto("Pedro Perez Pereira"));
		empresa.agregarEmpleado(new EmpleadoPermanenteDeTiempoParcial("María López"));
		empresa.agregarEmpleado(new EmpleadoTransitorioDeTiempoParcial("Sonia Agullo"));
		empresa.agregarEmpleado(new EmpleadoPermanenteDeTiempoCompleto("Raul Carrero"));
		System.out.println(empresa.listarEmpleados());
	}

}
