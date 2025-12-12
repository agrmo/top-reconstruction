package graph.rechnen.teile;

import java.util.ArrayList;
import graph.Nachbarschaftsliste;
import graph.zufalls.Zufallsgraph;
import graph.druck.tgf.GraphTGF;
import liste.Liste;

public class Main {

    public static void beispielEins() {
	int[][] paare = {{1,2},{2,0}};
	int betrag = 3;
	Nachbarschaftsliste nl = new Nachbarschaftsliste(paare, betrag);
	nl.verdoppeln();

	// Soll [[3,1]] geben.
	Teile t = new Teile();
	int[][] tTeile = t.teile(nl);
	Liste l = new Liste();
	System.out.println(l.nehmeStringVonArrayArray(tTeile));
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
	Teile t = new Teile();
	int[][] tTeile = t.teile(nl);
	Liste l = new Liste();
	System.out.println(l.nehmeStringVonArrayArray(tTeile));
	int groesste = t.groessterTeil(nl);
	System.out.println(groesste);
    }

    public static void beispielDrei() {
	Zufallsgraph zg = new Zufallsgraph(500, 0.01);
	GraphTGF gtgf = new GraphTGF();
	System.out.println(gtgf.macheGepheiTGF(zg.nachbarschaftsliste));

	zg.nachbarschaftsliste.verdoppeln();
	
	Teile t = new Teile();
	int[][] tTeile = t.teile(zg.nachbarschaftsliste);
	Liste l = new Liste();
	System.out.println(l.nehmeStringVonArrayArray(tTeile));
	int groesste = t.groessterTeil(zg.nachbarschaftsliste);
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
	    Teile t = new Teile();
	    int groesste = t.groessterTeil(zg.nachbarschaftsliste);
	    pZuBetrag[i] = new double[] {p, groesste};
	}

	Liste l = new Liste();
	String pZuBetragString = l.nehmeStringVonArrayArrayDouble(pZuBetrag);
	System.out.println(pZuBetragString);
    }

    public static void main(String[] args) {
	beispielVier();
    }
}
