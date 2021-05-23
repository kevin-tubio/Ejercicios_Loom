package desafio7;

public class ContadorDeRotaciones {
	
	/**
	 * pre : 'arreglo' no tiene elementos repetidos.
	 * post: Devuelve un entero cuyo valor representa las rotaciones necesarias para
	 * 			que el elemento de menor valor dentro del arreglo quede en la primera posicion. 
	 *         El modulo de dicho numero representa cuantas rotaciones son necesarias y el signo 
	 *         representa el sentido de giro, positivo indica dechecha; negativo indica izquierda. 
	 *         El coste de ejecucion del metodo pertenece al orden O(log(n)).
	 *         Si descomponemos el metodo calculando el tiempo de ejecucion de las operaciones 
	 *         complejas notamos que en general el coste pertence a O(1), salvo por la llamada 
	 *         al metodo "buscarMenorElemento()" cuyo coste pertenece al orden O(log(n)) y se 
	 *         considera entonces al mayor coste.
	 *    
	 * @param arreglo circular ordenado.
	 * @return cantidad de rotaciones, positivo para rotaciones a la derecha y
	 *  negativo para rotaciones a la izquierda.
	 */
	public int contarRotaciones(int[] arreglo) {
		if(!(arreglo.length <= 1)) {  
			int menorElemento = buscarMenorElemento(0, arreglo.length-1, arreglo);
		
			if(menorElemento == 0) { return 0; } 
			if(menorElemento <= arreglo.length/2) { return menorElemento*-1; }
			if(menorElemento > arreglo.length/2) { return arreglo.length - menorElemento; } 
		}
		return 0;
	}
	
	/** 
	 * post: busca el elemento de menor valor dentro de 'arreglo' y devuelve su indice. 
	 *          El metodo solo considera los elementos del arreglo que se encuentren
	 *          dentro del rango (posicion 'pInicial' _ posicion 'pFinal'). Evalua la relacion entre 
	 *          los extremos de dicho rango. 
	 * 			Si el rango contiene solo un elemento, caso base, entonces la busqueda
	 *          termina y se devuelve su indice. 
	 *          Si no encuentra el elemento buscado, se considera un nuevo rango con la 
	 *          mitad de elementos que el rango anterior, hasta encontrar el elemento 
	 *          buscado.
	 *          El coste de ejecucion del metodo es segun el teorema maestro 
	 *          T(n) = ( a*T(n/b) + O(n^c)), donde "a" es la cantidad de subproblemas 
	 *          que debo resolver para hallar el elemento buscado, a = 1. 
	 *          "b" es la cantidad por la cual se divide el tamaño original del problema
	 *          por cada subproblema, b = 2.
	 *          "c" es el exponente que determina el orden de complejidad al realizar la 
	 *          conquista del problema, en base al tamaño del mismo. El coste de realizar la
	 *          conquista pertenece al orden O(1), por lo cual c = 0;
	 *          El teorema maestro dice que si log_b(a) = c, entonces T(n) pertenece a O((n^c)*log(n)). 
	 *          Por lo tanto la complejidad del metodo pertenece al orden O(log(n)).
	 *          
	 * @param pInicial posicion inicial de busqueda.
	 * @param pFinal posicion final de busqueda.
	 * @param arreglo circular ordenado.
	 * @return el indice del elemento mas pequeño.
	 */
	private int buscarMenorElemento(int pInicial, int pFinal, int[] arreglo) {
		int pMedia = ((pInicial+1)+pFinal)/2;
		if(pInicial == pFinal || pMedia == 0) { return pInicial; }
		
		if(arreglo[pInicial] > arreglo[pFinal]) {	
			if(arreglo[pInicial] > arreglo[pMedia]) {
				return buscarMenorElemento(pInicial+1, pMedia, arreglo);
			}
			return buscarMenorElemento(pMedia+1, pFinal, arreglo);
		}
		else if(arreglo[pInicial] < arreglo[pFinal]) {
			return buscarMenorElemento(pInicial, pMedia-1, arreglo);
		}
		
		return pInicial;
	}
}
