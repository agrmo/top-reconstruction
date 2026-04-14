package macher.graph.zufalls;

import druck.graph.Graphtext;
import druck.graph.csv.GraphCSV;
import druck.graph.tgf.GraphTGF;
import graph.Nachbarschaftsliste;
import graph.Nachbarschaftsmatrix;
import graph.rechnen.kanteverteilung.Kanteverteilung;
import liste.Liste;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes macher.graph.zufalls.Main
*/

public class Main {
    public static void main(String[] args) {
	Nachbarschaftsliste nl = Zufallsgraph.machezufallsgraph(10, 0.1);

	// GraphCSV gcsv = new GraphCSV();
	// System.out.println(gcsv.macheGepheiCSV(z.nachbarschaftsliste));

	GraphTGF gtgf = new GraphTGF();
	System.out.println(gtgf.macheGepheiTGF(nl));	

	// int[][] verteilung = Kanteverteilung.kanteVerteilung(nl);
	// String verteilungString = Liste.nehmeStringVonArrayArray(verteilung);
	// System.out.println(verteilungString);	
	
	// Graphtext gt = new Graphtext();
	// System.out.println(gt.drucke(z.nachbarschaftsliste));
    }
}
