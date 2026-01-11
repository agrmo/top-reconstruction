package welt.zweigraph.gitter;

import welt.zweigraph.Zweigraphwelt;
import graph.Nachbarschaftsliste;
import vektor.Zweivektor;

/*
  javac -d classes $(find src -type f)		\
  && java -cp classes welt.zweigraph.gitter.Main
*/

public class Main {
    public static void main(String[] args) {

	// Es gibt genau 3 Knoten.
	int[][] paare = {{1,2},{2,0}};
	int betrag = 3;
	Nachbarschaftsliste nl = new Nachbarschaftsliste(paare, 3);

	Zweivektor[] orten = Zweigitter.machen(nl, 20, 10);

	Zweigraphwelt gw = new Zweigraphwelt(nl, orten);
    }    
}
