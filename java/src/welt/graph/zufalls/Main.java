package welt.graph.zufalls;

import vektor.Dreivektor;
import vektor.Zweivektor;
import graph.Nachbarschaftsliste;
import welt.graph.Zweigraphwelt;
import welt.graph.Dreigraphwelt;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes welt.graph.zufalls.Main
*/

public class Main {

    static void beispieleins() {
	// Der Graph.
	int[][] paare = {{1,2},{2,0}};
        int groesse = 3;
        Nachbarschaftsliste nl = new Nachbarschaftsliste(paare, groesse);

	// Die Orten wird zufällig gebaut.
        Zweivektor[] orten = Zufallszweigraphwelt.mache(groesse,
							  0, 50, 0, 50);
  
        // Die Welt.
        Zweigraphwelt gw = new Zweigraphwelt(nl, orten);

	// Dieses Beispiel ist wichtig. Der Graph ist nicht zufällig
	// gebaut, sind aber die Orte der Knoten.
    }

    static void beispielzwei() {
	// Der Graph.
	int[][] paare = {{1,2},{2,0}};
        int groesse = 3;
        Nachbarschaftsliste nl = new Nachbarschaftsliste(paare, groesse);

	// Die Orten wird zufällig gebaut.
        Dreivektor[] orten = Zufallsdreigraphwelt.mache(groesse,
							  0, 50,
							  0, 50,
							  0, 50);
  
        // Die Welt.
        Dreigraphwelt gw = new Dreigraphwelt(nl, orten);
    }

    public static void main(String[] args) {
	beispielzwei();
    }    
}
