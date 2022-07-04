public class BusquedaPorBucles {

	public static void main(String[] args) {

		int [] lista = {1,2,3,6,1,5,2,3,7};
		int [] lista2 = {1,2,3,4,5,6,7,8,9};

		int num = 6;
		int num2 = 7;

		System.out.println("El numero es: " + buscar(lista, num));
		System.out.println("El segundo numero es: " + buscar(lista2, num2));

	}

	public static int buscar(int[] lista, int num){

		int nu = 0, i = 0;

		while(i<lista.length){

			if(lista[i] == num){
				nu = lista[i];
				return nu;
			}
			i++;
		}

		return nu;
	}

}