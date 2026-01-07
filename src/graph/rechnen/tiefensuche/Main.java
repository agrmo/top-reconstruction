package graph.rechnen.tiefensuche;

import graph.Nachbarschaftsliste;
import graph.Doppelnachbarschaftsliste;
import java.util.Arrays;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes graph.rechnen.tiefensuche.Main
*/

public class Main {

    public static void beispielEins() {
	int[][] paare = {{1,2},{2,0}};
	int betrag = 3;
	Nachbarschaftsliste nl = new Nachbarschaftsliste(paare, betrag);
	Doppelnachbarschaftsliste dnl = new Doppelnachbarschaftsliste(nl);

	int[] gesehen = Tiefensuche.tiefensuche(dnl, 1);
	System.out.println(Arrays.toString(gesehen));	
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
	Doppelnachbarschaftsliste dnl = new Doppelnachbarschaftsliste(nl);

	// Soll 9 geben.
	int[] gesehenEins = Tiefensuche.tiefensuche(dnl, 9);
	System.out.println(Arrays.toString(gesehenEins));

	// Soll [0, 1, 3, 4, 7] geben.
	int[] gesehenZwei = Tiefensuche.tiefensuche(dnl, 7);
	System.out.println(Arrays.toString(gesehenZwei));

	// Soll [0, 1, 3, 4, 7] geben.
	int[] gesehenDrei = Tiefensuche.tiefensuche(dnl, 1);
	System.out.println(Arrays.toString(gesehenZwei));
	// Soll [6,2,8] geben.

	int[] gesehenVier = Tiefensuche.tiefensuche(dnl, 6);
	System.out.println(Arrays.toString(gesehenVier));

	// Soll [6,2,8] geben.
	int[] gesehenFuenf = Tiefensuche.tiefensuche(dnl, 8);
	System.out.println(Arrays.toString(gesehenFuenf));
    }
    
    public static void main(String[] args) {
	beispielZwei();
    }
}
