package rechner.graph.kanteanzahl;

import graph.Nachbarschaftsliste;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes rechner.graph.kanteanzahl.Main
*/

public class Main {

    static void beispieleins() {
	int[][] paare = {{1,2},{2,0}};
	int betrag = 3;
	Nachbarschaftsliste nl = new Nachbarschaftsliste(paare, betrag);
	int ka = Kanteanzahl.kanteanzahl(nl);
	System.out.println(ka);
    }

    static void beispielzwei() {
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
	
	int[][] paare = {{1,7},{7,3},{3,4},{3,0},{7,0},{6,2},{2,8},{6,8}};
	int betrag = 10;
	Nachbarschaftsliste nl = new Nachbarschaftsliste(paare, betrag);
	int ka = Kanteanzahl.kanteanzahl(nl);

	// Soll 8 geben.
	System.out.println(ka);
    }

    public static void main(String[] args) {
	beispielzwei();
    }
}
