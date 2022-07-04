package voraz;

import java.util.Vector;

public class monedasCarlos {

    static Vector<Double> restar (int i, int fin, double eur_a_devolver, double[] caja, Vector<Double> solucion){
        if(i+1<=fin) {
            if(eur_a_devolver!=0) {
                if(eur_a_devolver-caja[i] > 0){
                    eur_a_devolver = eur_a_devolver-caja[i];
                    System.out.println("Se devuelven: "+caja[i]+" euros.");
                    solucion.add(caja[i]);
                    return restar(i, fin, eur_a_devolver, caja, solucion);
                }else {
                    return restar(i+1, fin, eur_a_devolver, caja, solucion);
                }


            }System.out.println("No hay nada que devolver!");
        }
        return solucion;
    }

    public static void main(String[] args) {

        double eur_a_devolver = 127.34;
        double caja [] = {500, 200, 100, 50, 20, 10, 5, 2, 1, 0.5, 0.2, 0.1, 0.05, 0.02, 0.01};
        Vector<Double> solucion = new Vector<>();
        int i=0;
        int fin = caja.length;

        solucion = restar(i, fin, eur_a_devolver, caja, solucion);
    }

}