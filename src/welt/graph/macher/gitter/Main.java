package welt.graph.macher.gitter;

import welt.graph.Graphwelt;
import graph.Nachbarschaftsliste;
import welt.graph.macher.gitter.Gitter;

/*
  javac -d classes $(find src -type f)		\
  && java -cp classes welt.graph.macher.gitter.Main
*/

public class Main {
    public static void main(String[] args) {

	// Es gibt genau 3 Knoten.
	int[][] paare = {{1,2},{2,0}};
	int betrag = 3;
	Nachbarschaftsliste nl = new Nachbarschaftsliste(paare, 3);

	Gitter gitter = new Gitter(2, 10);
	int[][] orten = gitter.machen(nl);

	Graphwelt gw = new Graphwelt(nl, orten);
    }    
}
