package voraz;

public class monedasLuis {

    private static int seleccionarMoneda(float[] monedas, float acumulado, float cambio) {
        int pos = 0;
        boolean encontrado = false;
        while (pos < monedas.length && encontrado != true) {
            if (monedas[pos] + acumulado <= cambio) {
                encontrado = true;
            } else {
                pos++;
            }
        }
        if (pos == monedas.length) {
            pos = -1;
        }
        return pos;
    }//seleccionarMoneda

    public static int[] cambioMin(float[] monedas, float cambio) {
        int[] sol = new int[monedas.length];
        float acumulado = 0;
        boolean salir = false;

        while (acumulado != cambio && salir != true) {
            int posMoneda = seleccionarMoneda(monedas, acumulado, cambio);

            if (posMoneda == -1) {
                salir = true;
                sol = null;
            } else {
                sol[posMoneda]++;
                acumulado = acumulado + monedas[posMoneda];
            }

        }

        return sol;

    }//cambioMin

    public static void main(String[] args) {
        float[] monedas = {2f, 1f, 0.5f, 0.2f, 0.1f, 0.05f, 0.02f, 0.01f};
        float cambio = 10.89f;

        int[] numMonedas = cambioMin(monedas, cambio);
        if (numMonedas == null) {
            System.out.println("El sistema monetario actual no le puede proporcionar cambio");
        } else {
            for (int i = 0; i < numMonedas.length; i++) {
                if (numMonedas[i] != 0) {
                    System.out.println(" - " + numMonedas[i] + " de " + monedas[i] + "€");
                }
            }
        }

    }

}