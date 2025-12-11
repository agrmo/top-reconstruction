package graph.rechnen.kantedurchschnitt;

import graph.Nachbarschaftsliste;
import graph.Nachbarschaftsmatrix;
import graph.druck.tgf.GraphTGF;
import graph.zufalls.Zufallsgraph;
import graph.rechnen.kanteverteilung.Kanteverteilung;
import liste.Liste;

public class Main {
    public static void beispielEins() {
	GraphTGF gtgf = new GraphTGF();
	
	int[][] paare = {{1,2},{2,0}};
	int betrag = 3;
	Nachbarschaftsliste nl = new Nachbarschaftsliste(paare, betrag);
	String tgfString = gtgf.macheGepheiTGF(nl);
	System.out.println(tgfString);

	Kantedurchschnitt kDurchschnitt = new Kantedurchschnitt();
	double kd = kDurchschnitt.berechneKantedurchschnitt(nl);
	System.out.println(kd);	
    }

    public static void beispielZwei() {
	// DIE ORDNUNG IST HIER WICHTIG!!!
	// NACH KANTEVERTEILUNG IST DER GRAPH VERDOPPELT!
	// ALSO DIE KANTEDURCHSCHNITT WURDE VERÄNDERT!
	// (Nicht genau ein Bug, aber man konnte einen Fehler machen...)
	
	Zufallsgraph zg = new Zufallsgraph(500, 0.01);
	GraphTGF gtgf = new GraphTGF();
	System.out.println(gtgf.macheGepheiTGF(zg.nachbarschaftsliste));

	Kanteverteilung kverteilung = new Kanteverteilung();
	int[][] kv = kverteilung.kanteVerteilung(zg.nachbarschaftsliste);
	// Nach gr.kanteVerteilung ist zg.nachbarschaftsliste VERDOPPELT!
	Liste l = new Liste();
	String kvString = l.nehmeStringVonArrayArray(kv);
	System.out.println(kvString);

	Kantedurchschnitt kDurchschnitt = new Kantedurchschnitt();
	double kd = kDurchschnitt.berechneKantedurchschnitt(zg.nachbarschaftsliste);
	System.out.println(kd);
    }

    public static void main(String[] args) {
	beispielEins();
    }
}
