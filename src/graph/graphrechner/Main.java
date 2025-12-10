package graph.graphrechner;

import graph.Nachbarschaftsliste;
import graph.Nachbarschaftsmatrix;
import graph.druck.tgf.GraphTGF;
import liste.Liste;

public class Main {
    public static void main(String[] args) {

	Graphrechner gr = new Graphrechner();
	GraphTGF gtgf = new GraphTGF();
	
	int[][] paare = {{1,2},{2,0}};
	int betrag = 3;
	Nachbarschaftsliste nl = new Nachbarschaftsliste(paare, betrag);
	String tgfString = gtgf.macheGepheiTGF(nl);
	System.out.println(tgfString);
	
	double kd = gr.berechneKantedurchschnitt(nl);
	System.out.println(kd);
    }
}
