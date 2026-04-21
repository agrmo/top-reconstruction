package welt.graph.zufaellig;

import vektor.Dreivektor;
import vektor.Zweivektor;
import graph.Nachbarschaftsliste;
import welt.graph.Zweigraphwelt;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes welt.graph.zufaellig.Main
*/

public class Main {

    static void beispieleins() {
	// Der Graph.
	int[][] paare = {{1,2},{2,0}};
        int groesse = 3;
        Nachbarschaftsliste nl = new Nachbarschaftsliste(paare, groesse);

	// Die Orten wird zufällig gebaut.
        Zweivektor[] orten = Zufaelligzweigraphwelt.mache(groesse,
							  0, 50, 0, 50);
  
        // Die Welt.
        Zweigraphwelt gw = new Zweigraphwelt(nl, orten);
    }

    public static void main(String[] args) {
	beispieleins();
    }    
}
