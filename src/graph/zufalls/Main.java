package graph.zufalls;

import graph.Nachbarschaftsliste;
import graph.Nachbarschaftsmatrix;
import graph.graphdrucker.Graphdrucker;

public class Main {
    public static void main(String[] args) {

	Zufallsgraph z = new Zufallsgraph(10, 0.5);
	Graphdrucker gd = new Graphdrucker();
	System.out.println(gd.drucke(z.nachbarschaftsliste));
    }
}
