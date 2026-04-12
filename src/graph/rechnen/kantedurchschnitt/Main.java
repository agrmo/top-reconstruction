package graph.rechnen.kantedurchschnitt;

import graph.Nachbarschaftsliste;
import graph.Nachbarschaftsmatrix;
import druck.graph.tgf.GraphTGF;
import graph.zufalls.Zufallsgraph;
import graph.rechnen.kanteverteilung.Kanteverteilung;
import liste.Liste;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes graph.rechnen.kantedurchschnitt.Main
*/

public class Main {
    public static void beispieleins() {
	GraphTGF gtgf = new GraphTGF();
	
	int[][] paare = {{1,2},{2,0}};
	int betrag = 3;
	Nachbarschaftsliste nl = new Nachbarschaftsliste(paare, betrag);
	String tgfString = gtgf.macheGepheiTGF(nl);
	System.out.println(tgfString);

	double kd = Kantedurchschnitt.berechneKantedurchschnitt(nl);
	System.out.println(kd);	
    }

    public static void beispielzwei() {
	// DIE ORDNUNG IST HIER WICHTIG!!!
	// NACH KANTEVERTEILUNG IST DER GRAPH VERDOPPELT!
	// ALSO DIE KANTEDURCHSCHNITT WURDE VERÄNDERT!
	// (Nicht genau ein Bug, aber man konnte einen Fehler machen...)
	
	Zufallsgraph zg = new Zufallsgraph(500, 0.01);
	GraphTGF gtgf = new GraphTGF();
	System.out.println(gtgf.macheGepheiTGF(zg.nachbarschaftsliste));

	int[][] kv = Kanteverteilung.kanteVerteilung(zg.nachbarschaftsliste);
	
	// Nach Kanteverteilung ist zg.nachbarschaftsliste VERDOPPELT!
	
	String kvString = Liste.nehmeStringVonArrayArray(kv);
	System.out.println(kvString);

	double kd = Kantedurchschnitt.berechneKantedurchschnitt(zg.nachbarschaftsliste);
	System.out.println(kd);
    }

    public static void main(String[] args) {
	beispieleins();
    }
}
