package welt.graph;

import vektor.Dreivektor;
import vektor.Zweivektor;
import graph.Nachbarschaftsliste;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes welt.graph.Main
*/

public class Main {

    static void beispielEins() {
	// Der Graph.
	int[][] paare = {{1,2},{2,0}};
        int betrag = 3;
        Nachbarschaftsliste nl = new Nachbarschaftsliste(paare, 3);

	// Die Orten.
        Zweivektor[] orten = {
	    new Zweivektor(10,10),
	    new Zweivektor(50,50),
	    new Zweivektor(100,40)
	};
  
        // Die Welt.
        Zweigraphwelt gw = new Zweigraphwelt(nl, orten);
    }

    static void beispielZwei() {
	// Der Graph.
	int[][] paare = {{1,2},{2,0}};
        int betrag = 3;
        Nachbarschaftsliste nl = new Nachbarschaftsliste(paare, 3);

	// Die Orten.
        Dreivektor[] orten = {
	    new Dreivektor(10,10,10),
	    new Dreivektor(50,50,50),
	    new Dreivektor(100,40,50)
	};
  
        // Die Welt.
        Dreigraphwelt gw = new Dreigraphwelt(nl, orten);
    }

    public static void main(String[] args) {
	beispielZwei();
    }    
}
