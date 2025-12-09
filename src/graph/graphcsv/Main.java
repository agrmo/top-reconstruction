package graph.graphcsv;

import graph.Nachbarschaftsliste;
import graph.Nachbarschaftsmatrix;
import graph.graphdrucker.Graphdrucker;
import graph.graphcsv.GraphCSV;

public class Main {
    public static void main(String[] args) {

	GraphCSV gc = new GraphCSV();
	
	int[][] paare = {{1,2},{2,0}};
	int groese = 3;
	Nachbarschaftsmatrix nm = new Nachbarschaftsmatrix(paare, groese);
	System.out.println(gc.macheGepheiCSV(nm));
	
	Nachbarschaftsliste nl = new Nachbarschaftsliste(paare, 3);
    }
}
