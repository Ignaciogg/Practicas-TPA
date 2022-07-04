public class MergeSort {

	public static void mergesort(int lista[], int ini, int fin){

		int []listIZQ = {};
		int []listDER = {};

		if(ini < fin){

			int medio = (ini+fin)/2;

			for(int i = 0; i< lista.length/2; i++){
				listIZQ[i] = lista[i];
				listDER[i] = lista[i+lista.length/2];
			}

			mergesort(listIZQ, ini, medio);
			mergesort(listDER, medio+1, fin);

			merge(lista, ini, medio, fin);

		}
	}

	public static void merge(int array[], int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int leftArray[] = new int[n1];
        int rightArray[] = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[left + i];
        }

        for (int j = 0; j < n2; j++) {
            rightArray[j] = array[middle + j + 1];
        }

        int i = 0, j = 0;

        int k = left;

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){

		int arr[] = {1,3,7,23,64,5345,76,4,2,7,4,2,9,3,6};

		mergesort(arr, 0, 14);

		printArray(arr);

	}

}