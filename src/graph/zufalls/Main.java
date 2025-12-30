package graph.zufalls;

import graph.Nachbarschaftsliste;
import graph.Nachbarschaftsmatrix;
import druck.graph.GraphText;
import druck.graph.csv.GraphCSV;
import druck.graph.tgf.GraphTGF;
import graph.rechnen.kanteverteilung.Kanteverteilung;
import liste.Liste;

/*
  javac -d classes $(find src -type f) && java -cp classes graph.zufalls.Main
*/

public class Main {
    public static void main(String[] args) {
	Zufallsgraph z = new Zufallsgraph(10, 0.1);

	// GraphCSV gcsv = new GraphCSV();
	// System.out.println(gcsv.macheGepheiCSV(z.nachbarschaftsliste));

	GraphTGF gtgf = new GraphTGF();
	System.out.println(gtgf.macheGepheiTGF(z.nachbarschaftsliste));	

	Kanteverteilung kv = new Kanteverteilung();
	int[][] verteilung = kv.kanteVerteilung(z.nachbarschaftsliste);
	Liste l = new Liste();
	String verteilungString = l.nehmeStringVonArrayArray(verteilung);
	System.out.println(verteilungString);	
	
	// GraphText gt = new GraphText();
	// System.out.println(gt.drucke(z.nachbarschaftsliste));
    }
}
