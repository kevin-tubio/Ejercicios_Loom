package desafio0;

public class SumadorArreglo {

	/*
	 * Escribir una función que reciba un arreglo de enteros y devuelva la suma de los elementos que 
	 * se encuentran en posiciones pares (incluido el elemento de la posición 0).
	 * Por ejemplo: 
	 * Dado el arreglo [1, 2, 13 ,4, 8, 6] devuelve 22 (1+13+8)
	 */
	public int sumarPosicionesPares(int[] arreglo) {
		
		if(arreglo == null){
			throw new Error("Arreglo nulo");
		}
		
		int resultado = 0;
		
		for(int i = 0; i < arreglo.length; i += 2){
			
			resultado += arreglo[i]; 
		
		}
		
		return resultado;
	}
	
}
