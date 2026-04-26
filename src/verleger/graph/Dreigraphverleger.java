package verleger.graph;

import dreher.euler.Eulerdreher;
import matrix.Dreimatrix;
import vektor.Dreivektor;
import vektor.Zweivektor;
import verleger.punkt.Punktverleger;
import welt.graph.Dreigraphwelt;
import welt.graph.Zweigraphwelt;

public class Dreigraphverleger {
    
    // ein: Dreigraphwelt, ...
    // aus: Zweigraphwelt
    //
    // Verlegen die dreidimensionale Dreigraphwelt zu einer
    // zweidimensionale Zweigraphwelt.
    public static Zweigraphwelt verlege(Dreigraphwelt dgw,
					Dreivektor entfernung, double brennweite,
					double breite, double hoehe,
					double winkeleins,
					double winkelzwei,
					double winkeldrei) {

	Dreivektor[] dreiorten = dgw.nehmeknoten();
	Zweivektor[] zweiorten = new Zweivektor[dreiorten.length];

	// Für jeden Knoten, verlegen den Knoten.
	Dreimatrix drehung = Eulerdreher.nehmedrehung(winkeleins,
						      winkelzwei,
						      winkeldrei);

	// Verlege jeden Vektor. 
	for (int i = 0; i < zweiorten.length; i++) {
	    zweiorten[i] = Punktverleger.verlege(dreiorten[i],
						 entfernung, brennweite,
						 breite, hoehe,
						 drehung);
	}

	Zweigraphwelt zw = new Zweigraphwelt(dgw.graph, zweiorten);
	
	return zw;
    }
}
