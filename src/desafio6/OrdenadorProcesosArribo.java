package desafio6;

import java.util.Comparator;

public class OrdenadorProcesosArribo implements Comparator<Proceso> {

	@Override
	public int compare(Proceso o1, Proceso o2) {	
		return Integer.compare(o1.getT_Arribo(), o2.getT_Arribo());
	}
}
