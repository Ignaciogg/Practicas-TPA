public class Maximo {

	public static void main(String[] args) {

		int [] lista = {1,2,3,6,1,5,2,3,7};

		System.out.println("Maximo Normal: " + maximoNormal(lista));
		System.out.println("Maximo Recursivo: " + maximoRecursivo(lista));

	}

	public static int maximoNormal(int[]lista){

		int num = 0;

		for(int i = 0; i< lista.length; i++){
			if(lista[i] > num){
				num = lista[i];
			}
		}


		return num;
	}

	public static int maximoRecursivo(int[]lista){

		int num2, num3;

		if(lista.length == 1){
			return lista[0];
		}
		else if(lista.length == 2){
			if(lista[0] < lista[1])
				return lista[1];
			else
				return lista[0];

		}else{

			int[] lista1 = new int[lista.length/2];
			int[] lista2 = new int[lista.length/2+lista.length%2];

			for(int i = 0; i<lista.length/2; i++){
				lista1[i] = lista[i];
				lista2[i] = lista[i+lista.length%2+lista.length/2];
			}

			num2 = maximoRecursivo(lista1);
			num3 = maximoRecursivo(lista2);

			if(num2 < num3)
				return num3;
			else
				return num2;
		}

	}
}