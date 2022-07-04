public class BusquedaPorBuclesRecursiva {

	public static void main(String[] args) {

		int [] lista = {1,2,3,6,1,5,2,3,7};

		int num = 6;

		int i = 0;
		System.out.println("El numero esta en la posicion: " + buscar(lista, num, i));

	}

	public static int buscar(int[] lista, int num, int i){

		int nu = 0;

		while(i<lista.length){

			if(lista[i] == num){
				return i+1;
			}else{
				i++;
				buscar(lista, num, i);
			}

		}

		return nu;
	}

}