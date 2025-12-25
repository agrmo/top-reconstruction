package welt.graph.verorten.gitter;

import welt.graph.Graphwelt;
import graph.Nachbarschaftsliste;
import welt.graph.verorten.gitter.Gitter;

/*
  javac -d classes $(find src -name '*.java')		\
  && java -cp classes welt.graph.verorten.gitter.Main
*/

public class Main {
    public static void main(String[] args) {

	// Es gibt genau 3 Knoten.
	int[][] paare = {{1,2},{2,0}};
	int betrag = 3;
	Nachbarschaftsliste nl = new Nachbarschaftsliste(paare, 3);

	Gitter gitter = new Gitter(2, 10);
	int[][] orten = gitter.verorten(nl);

	Graphwelt gw = new Graphwelt(nl, orten);
    }    
}
