package graph.zufalls;

import graph.Nachbarschaftsliste;
import graph.Nachbarschaftsmatrix;
import graph.druck.GraphText;
import graph.druck.csv.GraphCSV;
import graph.druck.tgf.GraphTGF;
import graph.rechnen.kanteverteilung.Kanteverteilung;
import liste.Liste;

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
