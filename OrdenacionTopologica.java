package pr2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OrdenacionTopologica {

	public static void main(String[] args) {

		GrafoDirigido<String> g = new GrafoDirigido<>();

		Vertice<String> a = new Vertice<>("1");
        Vertice<String> b = new Vertice<>("2");
        Vertice<String> c = new Vertice<>("3");
        Vertice<String> d = new Vertice<>("4");
        Vertice<String> e = new Vertice<>("5");
        Vertice<String> f = new Vertice<>("6");
        Vertice<String> h = new Vertice<>("7");
        Vertice<String> i = new Vertice<>("8");

        g.insertarVertice(b);
        g.insertarVertice(a);
        g.insertarVertice(c);
        g.insertarVertice(d);
        g.insertarVertice(e);
        g.insertarVertice(f);
        g.insertarVertice(h);
        g.insertarVertice(i);

        g.insertarArista(a, b, 0);
        g.insertarArista(b, c, 0);
        g.insertarArista(c, d, 0);
        g.insertarArista(d, i, 0);
        g.insertarArista(a, f, 0);
        g.insertarArista(e, f, 0);
        g.insertarArista(f, h, 0);
        g.insertarArista(f, c, 0);
        g.insertarArista(h, i, 0);
        g.insertarArista(b, h, 0);
        g.insertarArista(h, d, 0);

        System.out.print("   --- Grafo del que partimos ---\n\nVERTICES: ");
        List<String> Vertices = g.vertices.stream().map(Vertice::getId).collect(Collectors.toList());
        System.out.println(Vertices.toString());

        System.out.print("ARISTAS: ");
        List<String> Aristas = g.aristas.stream().map(ar -> "{"+ar.getX().getId()+","+ar.getY().getId()+"->"+ar.getPonderacion()+"},").collect(Collectors.toList());
        System.out.println(Aristas.toString());

        System.out.println("");
        g.printListaAdyacencia();

        System.out.println("\n\n   --- Ordenación topológica ---\n");
        List<Vertice<String>> OrdenacionTopologica = ordTopologica(g);
        for(int j = 0; j < OrdenacionTopologica.size(); j++){
        	System.out.print(OrdenacionTopologica.get(j).getId() + " - ");
        }

	}

	public static List<Vertice<String>> ordTopologica(GrafoDirigido<String> g){

		Queue<Vertice<String>> cola = new LinkedList<Vertice<String>>();
		List<Vertice<String>> lista = new ArrayList<Vertice<String>>();
		List<Vertice<String>> vert = g.getVertices();
		List<Vertice<String>> neighbors = null;
		Vertice<String> vertex = null;

		// Metemos vertices con gradoDeEntrada 0 en la cola y la lista
		for(Vertice<String> v : vert){
			if(g.gradoDeEntrada((Vertice<String>) v) == 0){
				cola.add((Vertice<String>) v);
				lista.add((Vertice<String>) v);
			}
		}

		while(!cola.isEmpty()){

			vertex = (Vertice<String>) cola.poll();
			// Definimos los vecinos como sus sucesores porque ya comprobamos que no tiene predecesores
			neighbors = g.sucesores(vertex);

			// Para todos (for each) los vecinos de nuestro vertice
			for(Vertice<String> neighbor : neighbors){
				// Eliminamos sus aristas
				g.eliminarArista (vertex, neighbor);

				// Si su grado de entrada se convierte en 0, lo metemos en la cola
				if (g.gradoDeEntrada(neighbor) == 0) {
					cola.add((Vertice<String>) neighbor);
					lista.add((Vertice<String>) neighbor);
				}
			}
		}

		return lista;
	}

}