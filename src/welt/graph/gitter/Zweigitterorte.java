package welt.graph.gitter;

import vektor.Zweivektor;

public class Zweigitterorte {
    // Berechne die zweidimensionalen Orte jedes Knoten. Diese
    // Funktion baut die Stellen gleich wie der Graph in machegraph()
    // gebaut würde. D.h., orte[0] ist die Stelle des ersten Knoten 0.
    static Zweivektor[] macheorte(int xknoten, int yknoten, int weg) {

	Zweivektor[] orte = new Zweivektor[xknoten * yknoten];

	for (int i = 0; i < yknoten; i++) {
	    for (int j = 0; j < xknoten; j++) {
		int knotenindex = (i * xknoten) + j;
		orte[knotenindex] = new Zweivektor(j * weg, i * weg);
	    }
	}

	return orte;
    }
}
