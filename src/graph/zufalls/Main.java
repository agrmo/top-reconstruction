package graph.zufalls;

import graph.Nachbarschaftsliste;
import graph.Nachbarschaftsmatrix;
import graph.druck.GraphText;
import graph.druck.csv.GraphCSV;
import graph.druck.tgf.GraphTGF;

public class Main {
    public static void main(String[] args) {
	Zufallsgraph z = new Zufallsgraph(500, 0.0001);

	GraphTGF gtgf = new GraphTGF();
	System.out.println(gtgf.macheGepheiTGF(z.nachbarschaftsliste));
	
	// GraphText gt = new GraphText();
	// System.out.println(gt.drucke(z.nachbarschaftsliste));
	// GraphCSV gcsv = new GraphCSV();
	// System.out.println(gcsv.macheGepheiCSV(z.nachbarschaftsliste));
    }
}
