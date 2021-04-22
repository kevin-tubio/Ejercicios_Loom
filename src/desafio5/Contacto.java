package desafio5;

import java.io.PrintWriter;
import java.io.StringWriter;

public class Contacto {

	private String nombre, apellido, mail;
	
	public Contacto(String nombre, String apellido, String mail) throws ContactoInvalidoEx {
		autoValidar(nombre, apellido, mail);
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
	}	
	
	@Override
	public String toString() {
		StringWriter cadena = new StringWriter();
		PrintWriter printer = new PrintWriter(cadena);
		
		printer.print("nombre: " + this.nombre + ", ");
		printer.print("apellido: " + this.apellido + ", ");
		printer.print("mail: " + this.mail);
		
		printer.close();
		return cadena.toString();
	}
	
	private void autoValidar(String nombre, String apellido, String mail) throws ContactoInvalidoEx {
		if(nombre == null || nombre.equals("")) 
			throw new ContactoInvalidoEx("El contacto no tiene nombre.");
		
		if(apellido == null || apellido.equals("")) 
			throw new ContactoInvalidoEx("El contacto no tiene apellido.");
		
		if(mail == null || mail.equals("")) 
			throw new ContactoInvalidoEx("El contacto no tiene mail.");
		
		if(!mail.contains("@")) 
			throw new ContactoInvalidoEx("El mail no es valido.");
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) 
			return true;
		
		if (!(obj instanceof Contacto)) 
			return false;
		
		Contacto other = (Contacto) obj;
		if (!this.nombre.equals(other.nombre)) 
			return false;
		
		if (!this.apellido.equals(other.apellido)) 
			return false;
					
		return true;
	}
	
}