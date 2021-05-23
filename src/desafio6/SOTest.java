package desafio6;

import java.util.ArrayList;
import java.util.PriorityQueue;

import org.junit.Assert;
import org.junit.Test;

public class SOTest {

	private OrdenadorProcesosArribo ordenDeArribo = new OrdenadorProcesosArribo();
	private PriorityQueue<Proceso> colaArribo;
	private ArrayList<Proceso> procesosSalida;
	private SistemaOperativo so;

	@Test
	public void todosLosProcesosSonAtendidosAunqueNoTenganNombre() {
		Proceso p0 = new Proceso(null, 0, 5, 4);
		Proceso p1 = new Proceso(null, 1, 3, 2);
		Proceso p2 = new Proceso(null, 2, 8, 5);
		Proceso p3 = new Proceso(null, 3, 2, 1);
		Proceso p4 = new Proceso(null, 4, 3, 2);

		colaArribo = new PriorityQueue<Proceso>(ordenDeArribo);
		colaArribo.add(p0);
		colaArribo.add(p1);
		colaArribo.add(p2);
		colaArribo.add(p3);
		colaArribo.add(p4);

		procesosSalida = new ArrayList<Proceso>();
		procesosSalida.add(p0);
		procesosSalida.add(p3);
		procesosSalida.add(p1);
		procesosSalida.add(p4);
		procesosSalida.add(p2);

		so = new SistemaOperativo(colaArribo);
		so.simular(25);
		Assert.assertEquals(procesosSalida, so.listarProcesosSalida());
	}

	@Test
	public void siLaSimulacionTerminaAntesQueElProcesoEsteNoFinaliza() {
		Proceso p0 = new Proceso("P0", 0, 50, 4);
		Proceso p1 = new Proceso("P0", 1, 3, 1);
		Proceso p2 = new Proceso("P0", 1, 5, 2);

		colaArribo = new PriorityQueue<Proceso>(ordenDeArribo);
		colaArribo.add(p0);
		colaArribo.add(p1);
		colaArribo.add(p2);

		procesosSalida = new ArrayList<Proceso>();

		so = new SistemaOperativo(colaArribo);
		so.simular(25);
		Assert.assertEquals(procesosSalida, so.listarProcesosSalida());
	}

	@Test
	public void laColaDeArribosAdmiteProcesosIdenticos() {
		Proceso p0 = new Proceso("P0", 0, 2, 4);
		Proceso p1 = new Proceso("P0", 0, 2, 4);
		Proceso p2 = new Proceso("P0", 0, 2, 4);

		colaArribo = new PriorityQueue<Proceso>(ordenDeArribo);
		colaArribo.add(p0);
		colaArribo.add(p1);
		colaArribo.add(p2);

		procesosSalida = new ArrayList<Proceso>();
		procesosSalida.add(p0);
		procesosSalida.add(p1);
		procesosSalida.add(p2);

		so = new SistemaOperativo(colaArribo);
		so.simular(25);
		Assert.assertEquals(procesosSalida, so.listarProcesosSalida());
	}

	@Test
	public void procesosIdenticosRespetanOrdenDePrioridadYSeEjecutanJuntosAMenosQueLaColaEstuvieraVacia() {
		Proceso p0 = new Proceso("P0", 0, 6, 4);
		Proceso p1 = new Proceso("P0", 0, 6, 4);
		Proceso p2 = new Proceso("P0", 0, 6, 4);
		Proceso p3 = new Proceso("P1", 3, 4, 2);
		Proceso p4 = new Proceso("P2", 4, 5, 3);
		Proceso p5 = new Proceso("P3", 2, 5, 3);
		Proceso p6 = new Proceso("P4", 1, 5, 3);

		colaArribo = new PriorityQueue<Proceso>(ordenDeArribo);
		colaArribo.add(p0);
		colaArribo.add(p1);
		colaArribo.add(p2);
		colaArribo.add(p3);
		colaArribo.add(p4);
		colaArribo.add(p5);
		colaArribo.add(p6);

		procesosSalida = new ArrayList<Proceso>();
		procesosSalida.add(p0);
		procesosSalida.add(p3);
		procesosSalida.add(p6);
		procesosSalida.add(p5);
		procesosSalida.add(p4);
		procesosSalida.add(p1);
		procesosSalida.add(p2);

		so = new SistemaOperativo(colaArribo);
		so.simular(50);
		Assert.assertEquals(procesosSalida, so.listarProcesosSalida());
	}

	@Test
	public void procesosIdenticosSeEjecutanJuntosSiLaColaNoEstaVacia() {
		Proceso p0 = new Proceso("P0", 3, 6, 4);
		Proceso p1 = new Proceso("P1", 3, 6, 4);
		Proceso p2 = new Proceso("P2", 3, 6, 4);
		Proceso p3 = new Proceso("P1", 0, 4, 2);
		Proceso p4 = new Proceso("P2", 1, 5, 3);
		Proceso p5 = new Proceso("P3", 2, 5, 3);
		Proceso p6 = new Proceso("P4", 0, 5, 3);

		colaArribo = new PriorityQueue<Proceso>(ordenDeArribo);
		colaArribo.add(p0);
		colaArribo.add(p1);
		colaArribo.add(p2);
		colaArribo.add(p3);
		colaArribo.add(p4);
		colaArribo.add(p5);
		colaArribo.add(p6);

		procesosSalida = new ArrayList<Proceso>();
		procesosSalida.add(p3);
		procesosSalida.add(p6);
		procesosSalida.add(p4);
		procesosSalida.add(p5);
		procesosSalida.add(p1);
		procesosSalida.add(p0);
		procesosSalida.add(p2);

		so = new SistemaOperativo(colaArribo);
		so.simular(50);
		Assert.assertEquals(procesosSalida, so.listarProcesosSalida());
	}
}
