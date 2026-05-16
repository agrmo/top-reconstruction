package verleger.punkt;

import matrix.Dreimatrix;
import vektor.Dreivektor;
import vektor.Zweivektor;

// Ein Punktverleger verlegt einen dreidimensionalen Punkt von einer
// zweidimensionalen Punkt mit Hilfe der Ein-Punkt-Perspektive.
//
// Schritte der Ein-Punkt-Perspektive:
// 1. Berechne die nötige Drehung.
// 2. Drehe den Punkt.
// 3. Entfernen die Kamera vom Ursprung.
// 4. Projizieren alle Vektoren zu einer zweidimensionalen Fläche.
// 5. Verschieben alle Vektoren zum Zentrum des Bildchirms.
public class Punktverleger {
    
    // ein: Dreivektor, ...
    // aus: Zweivektor
    //
    // Verlege den gegeben dreidimensionalen Vektor.
    public static Zweivektor verlege(Dreivektor va,
				     Dreivektor entfernung, double brennweite,
				     double breite, double hoehe,
				     Dreimatrix drehung) {
		
	// Drehe die Basis des Vektors um.
	Dreivektor vb = drehung.punkt(va);

	// Jetzt ist die Stelle gedreht.
	// Entferne die Augen entlang der z-Achse.
	vb.eins -= entfernung.eins;
	vb.zwei -= entfernung.zwei;
	vb.drei -= entfernung.drei;
	
	// Letzendlich verlegen die Stellen von drei bis zwei Dimensionen.
	int zweidimensionalex = (int) ((0.5 * breite)
				       + (vb.eins/vb.drei) * brennweite);
	
	int zweidimensionaley = (int) ((0.5 * hoehe)
				       + (vb.zwei/vb.drei) * brennweite);

	Zweivektor aus = new Zweivektor(zweidimensionalex, zweidimensionaley);
	
	return aus;
    }
}
