package graph.zufalls;

import graph.Nachbarschaftsliste;
import graph.Nachbarschaftsmatrix;
import graph.druck.GraphText;
import graph.druck.csv.GraphCSV;

public class Main {
    public static void main(String[] args) {
	Zufallsgraph z = new Zufallsgraph(500, 0.0001);
	GraphText gd = new GraphText();
	System.out.println(gd.drucke(z.nachbarschaftsliste));
	GraphCSV gcsv = new GraphCSV();
	System.out.println(gcsv.macheGepheiCSV(z.nachbarschaftsliste));
    }
}
