package verleger.graph;

import auge.Auge;
import dreher.euler.Eulerdreher;
import matrix.Dreimatrix;
import vektor.Dreivektor;
import vektor.Zweivektor;
import verleger.punkt.Punktverleger;
import welt.graph.Dreigraphwelt;
import welt.graph.Zweigraphwelt;

public class Graphverleger {
    
    // ein: Dreigraphwelt, ...
    // aus: Zweigraphwelt
    //
    // Verlege die dreidimensionale Dreigraphwelt zu einer
    // zweidimensionale Zweigraphwelt.
    public static Zweigraphwelt verlege(Dreigraphwelt dgw, Auge auge) {

	Dreivektor[] dreiorten = dgw.nehmeknoten();
	Zweivektor[] zweiorten = new Zweivektor[dreiorten.length];

	// Für jeden Knoten, verlegen den Knoten.
	Dreimatrix drehung = Eulerdreher.nehmedrehung(auge.winkeleins,
						      auge.winkelzwei,
						      auge.winkeldrei);

	// Verlege jeden Vektor. 
	for (int i = 0; i < zweiorten.length; i++) {
	    zweiorten[i] = Punktverleger.verlege(dreiorten[i],
						 auge.entfernung, auge.brennweite,
						 auge.breite, auge.hoehe,
						 drehung);
	}

	Zweigraphwelt zw = new Zweigraphwelt(dgw.graph, zweiorten);
	
	return zw;
    }
}
