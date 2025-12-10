package graph.graphrechner;

import graph.Nachbarschaftsliste;
import graph.Nachbarschaftsmatrix;
import graph.druck.tgf.GraphTGF;
import graph.zufalls.Zufallsgraph;
import liste.Liste;

public class Main {

    public static void beispielEins() {
	Graphrechner gr = new Graphrechner();
	
	int[][] paare = {{1,2},{2,0}};
	int betrag = 3;
	Nachbarschaftsmatrix nm = new Nachbarschaftsmatrix(paare, betrag);
	System.out.println(gr.hatKante(nm,1,2));
	System.out.println(gr.hatKante(nm,2,1));
	
	Nachbarschaftsliste nl = new Nachbarschaftsliste(paare, betrag);
	System.out.println(gr.hatKante(nl,1,2));
	System.out.println(gr.hatKante(nl,2,1));

	int[][] verteilung = gr.kanteVerteilung(nl);
	Liste l = new Liste();
	String verteilungString = l.nehmeStringVonArrayArray(verteilung);
	System.out.println(verteilungString);	
    }

    public static void beispielZwei() {
	Zufallsgraph zg = new Zufallsgraph(10, 0.3);
    	GraphTGF gtgf = new GraphTGF();
	System.out.println(gtgf.macheGepheiTGF(zg.nachbarschaftsliste));

	Graphrechner gr = new Graphrechner();
	int[][] verteilung = gr.kanteVerteilung(zg.nachbarschaftsliste);
	Liste l = new Liste();
	String verteilungString = l.nehmeStringVonArrayArray(verteilung);
	System.out.println(verteilungString);	
    }        

    public static void beispielDrei() {
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

    public static void beispielVier() {
	// DIE ORDNUNG ITST HIER WICHTIG!!!
	// NACH KANTEVERTEILUNG IST DER GRAPH VERDOPPELT!
	// ALSO DIE KANTEDURCHSCHNITT WURDE VERÄNDERT!
	// (Nicht genau ein Bug, aber man konnte einen Fehler machen...)
	
	Zufallsgraph zg = new Zufallsgraph(500, 0.01);
	GraphTGF gtgf = new GraphTGF();
	System.out.println(gtgf.macheGepheiTGF(zg.nachbarschaftsliste));

	Graphrechner gr = new Graphrechner();
	int[][] kv = gr.kanteVerteilung(zg.nachbarschaftsliste);
	// Nach gr.kanteVerteilung ist zg.nachbarschaftsliste VERDOPPELT! :[
	Liste l = new Liste();
	String kvString = l.nehmeStringVonArrayArray(kv);
	System.out.println(kvString);

	double kd = gr.berechneKantedurchschnitt(zg.nachbarschaftsliste);
	System.out.println(kd);
    }
    
    public static void main(String[] args) {
	beispielZwei();
    }
}
