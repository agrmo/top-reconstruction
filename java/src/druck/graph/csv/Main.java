package druck.graph.csv;

import graph.Nachbarschaftsliste;
import graph.Nachbarschaftsmatrix;

/*
  javac -d classes $(find src -type f) && java -cp classes druck.graph.csv.Main
*/

public class Main {
    public static void main(String[] args) {

	GraphCSV gc = new GraphCSV();
	
	int[][] paare = {{1,2},{2,0}};
	int groese = 3;
	Nachbarschaftsmatrix nm = new Nachbarschaftsmatrix(paare, groese);
	System.out.println(gc.macheGepheiCSV(nm));

	Nachbarschaftsliste nl = new Nachbarschaftsliste(paare, groese);
	System.out.println(gc.macheGepheiCSV(nl));
    }
}
