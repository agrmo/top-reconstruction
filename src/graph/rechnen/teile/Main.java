package graph.rechnen.teile;

import graph.Nachbarschaftsliste;
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

    public static void main(String[] args) {
	beispielZwei();
    }
}
