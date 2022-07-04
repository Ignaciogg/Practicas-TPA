public class BusquedaBinaria {

	public static void main(String[] args) {

		int[] arr = {1,2,3,4,5,6,7,8,9,10};

		System.out.println(busca(arr, 4, 1, 10));

	}

	public static int busca (int []array, int x, int inicio, int fin){

		if(inicio > fin)
			return -1;
		else{
			int medio = (inicio+fin)/2;
			if(array[medio] == x)
				return medio;
			else{
				if(array[medio] > x)
					return busca(array, x, inicio, medio-1);
				else
					return busca(array, x, medio+1, fin);
			}
		}
	}
}