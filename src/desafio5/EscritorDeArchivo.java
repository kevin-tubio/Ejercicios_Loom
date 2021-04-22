package desafio5;

import java.io.FileWriter;
import java.io.IOException;

public class EscritorDeArchivo {

	private FileWriter escritor;
	private String pArchivo;
	
	public EscritorDeArchivo(String pArchivo) {
		this.pArchivo = pArchivo;
			
		try{
			escritor = new FileWriter(pArchivo); 
			escritor.close();
		}
		catch (IOException e) { System.err.println(e.getMessage()); }
	}
	
	public void escribirLineaEnArchivo(String linea) {
		try {
			escritor = new FileWriter(this.pArchivo, true);
			escritor.write(linea + "\n"); 
		    escritor.close();
		}
		catch (IOException e) { System.err.println(e.getMessage()); }
	}

}
