package desafio6;

import java.util.ArrayList;
import java.util.PriorityQueue;
import desafio6.Proceso.Estado;

public class SistemaOperativo {

	private PriorityQueue<Proceso> colaProcesos = new PriorityQueue<Proceso>();
	private PriorityQueue<Proceso> colaArribo;
	private ArrayList<Proceso> procesosSalida;
	private int tiempoProcesador;
	private Procesador procesador;

	/**
	 * @param colaArribo cola priorizada por tiempo de arribo
	 */
	public SistemaOperativo(PriorityQueue<Proceso> colaArribo) {
		this.tiempoProcesador = 0;
		this.colaArribo = colaArribo;
		this.procesosSalida = new ArrayList<Proceso>();
		this.procesador = new Procesador(procesosSalida);
	}

	/**
	 * Se ejecuta la simulacion durante el tiempo pasado como parametro, 
	 * en cada ciclo, se desencola los procesos de la colaArribo segun 
	 * si el tiempo de arribo coincide con el tiempo de proceso actual y se encola
	 * en colaProcesos solo si el proceso no esta terminado.
	 * Tambien si el procesador esta libre comienza a procesar un proceso de la colaProcesos.
	 * El procesador procesa en cada ciclo el proceso que tiene asignado. 
	 * @param tiempo duracion de la simulacion
	 */
	public void simular(int tiempo) {
		Proceso pActual;
		for (; tiempoProcesador <= tiempo; tiempoProcesador++) {
			
			while (!colaArribo.isEmpty() && colaArribo.peek().getT_Arribo() == tiempoProcesador) {
				pActual = colaArribo.poll();
				if(pActual.getStatus() == Estado.LISTO) {
					colaProcesos.add(pActual);
				}	
			}

			if (procesador.getStatus() == Procesador.Estado.LIBRE) {
				if (!colaProcesos.isEmpty()) {
					procesador.procesar(colaProcesos.poll());
				}
			}
			procesador.pulsoClock();
		}
	}

	/**
	 * @return lista de procesos terminados.
	 */
	public ArrayList<Proceso> listarProcesosSalida() {
		return procesosSalida;
	}
}
