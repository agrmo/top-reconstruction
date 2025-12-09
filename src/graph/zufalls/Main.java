package graph.zufalls;

import graph.Nachbarschaftsliste;
import graph.Nachbarschaftsmatrix;
import graph.graphdrucker.Graphdrucker;
import graph.graphcsv.GraphCSV;

public class Main {
    public static void main(String[] args) {

	Zufallsgraph z = new Zufallsgraph(15, 0.5);
	Graphdrucker gd = new Graphdrucker();
	System.out.println(gd.drucke(z.nachbarschaftsliste));
	GraphCSV gcsv = new GraphCSV();
	System.out.println(gcsv.macheGepheiCSV(z.nachbarschaftsliste));
    }
}
