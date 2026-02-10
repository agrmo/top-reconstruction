package graph.rechnen.breitensuche;

import graph.Nachbarschaftsliste;
import graph.Doppelnachbarschaftsliste;
import java.util.Arrays;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes graph.rechnen.breitensuche.Main
*/

public class Main {

    public static void beispielEins() {
	int[][] paare = {{1,2},{2,0}};
	int betrag = 3;
	Nachbarschaftsliste nl = new Nachbarschaftsliste(paare, betrag);
	Doppelnachbarschaftsliste dnl = new Doppelnachbarschaftsliste(nl);

	int[] gesehen = Breitensuche.breitensuche(dnl, 1);
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
	int[] gesehenEins = Breitensuche.breitensuche(dnl, 9);
	System.out.println(Arrays.toString(gesehenEins));

	// Soll [7, 1, 0, 3, 4] geben.
	int[] gesehenZwei = Breitensuche.breitensuche(dnl, 7);
	System.out.println(Arrays.toString(gesehenZwei));

	// Soll [1, 7, 3, 0, 4] geben.
	int[] gesehenDrei = Breitensuche.breitensuche(dnl, 1);
	System.out.println(Arrays.toString(gesehenDrei));
	
	// Soll [6,2,8] oder [6,8,2] geben.
	int[] gesehenVier = Breitensuche.breitensuche(dnl, 6);
	System.out.println(Arrays.toString(gesehenVier));

	// Soll [8,2,6] oder [8,6,2] geben.
	int[] gesehenFuenf = Breitensuche.breitensuche(dnl, 8);
	System.out.println(Arrays.toString(gesehenFuenf));
    }

        public static void beispielDrei() {
	/*
	  
                     5       4
	              \     /
                       2   3
	                \ /
		    13-7-1-6-12
	                / \
		       8   9
	              /     \
                     10      11
	 */

	// Soll etwas sinnvolles geben...
	int[][] paare = {{1,7},{1,2},{1,3},{1,6},{1,8},{1,9},
			 {2,5},{3,4},{6,12},{9,11},{8,10},{7,13}};
	
	int betrag = 14;
	Nachbarschaftsliste nl = new Nachbarschaftsliste(paare, betrag);
	Doppelnachbarschaftsliste dnl = new Doppelnachbarschaftsliste(nl);

	int[] gesehenEins = Breitensuche.breitensuche(dnl, 1);
	System.out.println(Arrays.toString(gesehenEins));
    }

    
    public static void main(String[] args) {
	beispielDrei();
    }
}
