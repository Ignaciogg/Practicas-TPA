public class buster {


	    public static void main(String[] args) {
	        int[] a = {0,1,2,3,4,5,6,7,8,9};
	        int i = 2;
	        int b = 4;
	        int x = 8;
	        System.out.print("La recursividad es: " + Bus3(a, i, b, x));

	    }

	    public static int Bus3(int[] lista, int i, int f, int x) {
	        if (i > f) {
	            return 0;
	        } else {

	            int q1 = (lista.length/3);
	            int q2 = (lista.length/3)*2;
	            if (x == lista[q1]) {
	                return q1;
	            } else {
	                if (x < lista[q1])
	                    return Bus3(lista, i, q1-1, x);
	                else if(x > lista[q1] && x<lista[q2])
	                    return Bus3(lista, q1, q2-1, x);
	                else{
	                	if(x > lista[q2])
	                		return Bus3(lista, q2, f, x);
	                }
	            }
	        }
	        return 0;
	    }

}