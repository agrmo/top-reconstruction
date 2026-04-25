package welt.graph.gitter;

import graph.Nachbarschaftsliste;
import vektor.Zweivektor;
import welt.graph.Zweigraphwelt;
import graph.gitter.Zweigitter;

public class Zweigitterwelt {
    /*
      Mache eine zweidimensionale Graphwelt, die ein Gitter enthält.
      
      xknoten: Die Anzahl von Knoten in der x-Richtung.
      yknoten: Die Anzahl von Knoten in der y-Richtung.
      weg: Der räumliche Entfernung zwischen zwei Knoten.
    */
    public static Zweigraphwelt machewelt(int xknoten, int yknoten, int weg) {

	// Der Graph kennt seine Stellen nicht. Wichtig.
	Nachbarschaftsliste graph = Zweigitter.machegraph(xknoten, yknoten);

	// Die Welt kennt die Stellen aller Knoten. Wichtig.
	Zweivektor[] orte = Zweigitterorte.macheorte(xknoten, yknoten, weg);

	// Nun baue die Welt.
	Zweigraphwelt zgw = new Zweigraphwelt(graph, orte);

	return zgw;
    }
}
