package voraz;

public class monedas {

	public static void main(String[] args) {

		double [] monedas = {5, 2, 1, 0.5, 0.2, 0.1, 0.05, 0.02, 0.01};

		int [] cantidad = {1, 1, 1, 1, 1, 1, 1, 1, 1};

		double num1 = 99.12;
		cuantasMonedas(monedas, cantidad, num1);

	}

	static void cuantasMonedas(double []mon, int[]can, double num){

		for(int i = 0; i< mon.length; i++){
			if(mon[i] % num != 0){
				if(can[i] >= num/mon[i]){
					System.out.println("Se necesitarán " + Math.floor(num/mon[i]) + " monedas de " + mon[i] + " euros.");
					num = num - Math.floor(num/mon[i]) * mon[i];
				}else{
					System.out.println("No tenemos sufiencientes monedas de "+ mon[i] +" euros.");
				}

			}
		}

	}

}