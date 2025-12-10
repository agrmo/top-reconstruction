package graph.graphrechner;

import graph.Nachbarschaftsliste;
import graph.Nachbarschaftsmatrix;
import graph.druck.tgf.GraphTGF;
import graph.graphlaeufer.Graphlaeufer;
import graph.zufalls.Zufallsgraph;
import liste.Liste;

public class Main {

    public static void beispielEins() {
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

    public static void beispielZwei() {
	// DIE ORDNUNG ITST HIER WICHTIG!!!
	// NACH KANTEVERTEILUNG IST DER GRAPH VERDOPPELT!
	// ALSO DIE KANTEDURCHSCHNITT WURDE VERÄNDERT!
	// (Nicht genau ein Bug, aber man konnte einen Fehler machen...)
	
	Zufallsgraph zg = new Zufallsgraph(500, 0.01);
	Graphlaeufer gl = new Graphlaeufer();

	GraphTGF gtgf = new GraphTGF();
	System.out.println(gtgf.macheGepheiTGF(zg.nachbarschaftsliste));

	int[][] kv = gl.kanteVerteilung(zg.nachbarschaftsliste);
	Liste l = new Liste();
	String kvString = l.nehmeStringVonArrayArray(kv);
	System.out.println(kvString);

	Graphrechner gr = new Graphrechner();
	double kd = gr.berechneKantedurchschnitt(zg.nachbarschaftsliste);
	System.out.println(kd);
    }
    
    public static void main(String[] args) {
	beispielZwei();
    }
}
