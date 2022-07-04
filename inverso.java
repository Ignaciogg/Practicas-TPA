public class inverso {

	public static void main(String[] args) {


		int arr[] = {1,2,3,4,5,6,7,8};
		int arr2[] = {8,7,6,5,4,3,2,1};

		if(inverso(0, 6, arr, arr2) == true)
			System.out.println("True");
		else
			System.out.println("False");

	}

	public static boolean inverso (int ini, int fin, int arr[], int arr2[]){
		boolean sol = false;

		if(ini >= fin){
	        sol = true;
	    }
	    if(arr[ini] != arr[fin]){
	        sol = false;
	    }

	    return inverso (++ini, --fin, arr);

	}

}