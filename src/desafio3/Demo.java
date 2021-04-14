package desafio3;

public class Demo {

	public static void main(String[] args) {
		Empresa empresa = new Empresa(); 
		
		System.out.println("-------------------------------------------------------");
		
		empresa.agregarEmpleado(new Gerente("Ana", "García"));
		empresa.agregarEmpleado(new TransitorioDeTiempoCompleto("Pedro", "Perez Pereira"));
		empresa.agregarEmpleado(new PermanenteDeTiempoParcial("Maria", "Lopez"));
		empresa.agregarEmpleado(new TransitorioDeTiempoParcial("Sonia", "Agullo"));
		empresa.agregarEmpleado(new PermanenteDeTiempoCompleto("Raul", "Carrero"));
		
		System.out.println(empresa.listarEmpleados());
		System.out.println("-------------------------------------------------------");
		
		System.out.println(empresa.liquidarSueldos());
		System.out.println("-------------------------------------------------------");
		
		empresa.actualizarUnidadRetributiva(150);
		System.out.println(empresa.liquidarSueldos());
		System.out.println("-------------------------------------------------------");
		
		empresa.actualizarUnidadRetributiva(20);
		System.out.println(empresa.liquidarSueldos());
		System.out.println("-------------------------------------------------------");
		
	}

}
