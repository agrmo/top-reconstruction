package graph.rechnen.teile;

import java.util.ArrayList;
import graph.Nachbarschaftsliste;
import graph.zufalls.Zufallsgraph;
import druck.graph.tgf.GraphTGF;
import liste.Liste;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes graph.rechnen.teile.Main
*/

public class Main {

    public static void beispielEins() {
	int[][] paare = {{1,2},{2,0}};
	int betrag = 3;
	Nachbarschaftsliste nl = new Nachbarschaftsliste(paare, betrag);
	nl.verdoppeln();

	// Soll [[3,1]] geben.
	int[][] tTeile = Teile.teile(nl);
	System.out.println(Liste.nehmeStringVonArrayArray(tTeile));
    }

    public static void beispielZwei() {
	/*
	 * Darstellung:
	 * 
	 * 9
	 * 
	 * 1 - 7 - 3 - 4
	 *     \   |
	 *      \  |
	 *       \ |
	 *        0
	 *
	 * 6 - 2 - 8
	 * |       |
	 * ---------
	 */

	// Es gibt 3 Teile.
	
	int[][] paare = {{1,7},{7,3},{3,4},{3,0},{7,0},{6,2},{2,8},{6,8}};
	int betrag = 10;
	Nachbarschaftsliste nl = new Nachbarschaftsliste(paare, betrag);
	nl.verdoppeln();

	// Soll [[1,1],[5,1],[3,1]] abgeben.
	int[][] tTeile = Teile.teile(nl);
	System.out.println(Liste.nehmeStringVonArrayArray(tTeile));
	int groesste = Teile.groessterTeil(nl);
	System.out.println(groesste);
    }

    public static void beispielDrei() {
	Zufallsgraph zg = new Zufallsgraph(500, 0.01);
	GraphTGF gtgf = new GraphTGF();
	System.out.println(gtgf.macheGepheiTGF(zg.nachbarschaftsliste));

	zg.nachbarschaftsliste.verdoppeln();
	
	int[][] tTeile = Teile.teile(zg.nachbarschaftsliste);
	System.out.println(Liste.nehmeStringVonArrayArray(tTeile));
	int groesste = Teile.groessterTeil(zg.nachbarschaftsliste);
	System.out.println(groesste);	
    }

    public static void beispielVier() {
	// Berechne eine Reihe von Zufallsgraphen.
	// Die Graphen haben die gleiche Anzahl von Knoten.
	// Die Wahrscheinlichkeit p wird erhöht.
	// Für jeden Graphen, misst den Betrag des größten Teiles.
	//
	// Stelle eine Kurve, die zeigt, wie schnell den Betrag des
	// größten Teiles erhöht, während die Wahrscheinlichkeit p
	// zunimmt.

	// Beispiel:
	//
	// Ein:
	// Berechnen wir 3 Graphen. 500 Knoten. Nimm die
	// Wahrscheinlichkeit von 0.0001 bis 0.001 bis 0.01 zu. Miß
	// den Betrag des größten Teiles.
	// Aus:
	// [[0.0001,3],[0.001,9],[0.01,490]]
	//
	// Also wir glauben, daß der Betrag des größten Teiles nimmt
	// mit der Wahrscheinlichkeit zu.

	double[] pListe = new double[] {0.0001, 0.001, 0.002, 0.003, 0.004, 0.005, 0.006, 0.007, 0.008, 0.009, 0.01};
	double[][] pZuBetrag = new double[pListe.length][];

	for (int i = 0; i < pListe.length; i++) {
	    double p = pListe[i];
	    Zufallsgraph zg = new Zufallsgraph(500, p);
	    zg.nachbarschaftsliste.verdoppeln();
	    int groesste = Teile.groessterTeil(zg.nachbarschaftsliste);
	    pZuBetrag[i] = new double[] {p, groesste};
	}

	String pZuBetragString = Liste.nehmeStringVonArrayArrayDouble(pZuBetrag);
	System.out.println(pZuBetragString);
    }

    public static void main(String[] args) {
	beispielVier();
    }
}
