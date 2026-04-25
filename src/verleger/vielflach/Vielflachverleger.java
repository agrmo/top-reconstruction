package verleger.vielflach;

import dreher.euler.Eulerdreher;
import druck.matrix.Matrixdrucker;
import matrix.Dreimatrix;
import strecke.Dreistrecke;
import strecke.Zweistrecke;
import vektor.Dreivektor;
import welt.strecke.Zweistreckewelt;
import welt.vielflach.Vielflachwelt;
import verleger.strecke.Streckeverleger;

// Ein Vielflachverleger verlegt eine dreidimensionale Welt von
// Vielflächen zu einer zweidimensionalen Welt von Vektoren und
// Strecken.
//
// Schritte:
// 1. Berechne die nötige Drehung.
// 2. Drehe den Punkt.
// 3. Entfernen die Kamera vom Ursprung.
// 4. Projizieren alle Vektoren zu einer zweidimensionalen Fläche.
// 5. Verschieben alle Vektoren zum Zentrum des Bildchirms.
public class Vielflachverleger {
    
    // ein: Vielflachwelt, ...
    // aus: Zweistreckewelt
    //
    // Verlegen die dreidimensionale Vielflachwelt zu einer
    // zweidimensionale Zweistreckewelt.
    public static Zweistreckewelt verlege(Vielflachwelt vw,
					  Dreivektor entfernung, double brennweite,
					  double breite, double hoehe,
					  double winkeleins,
					  double winkelzwei,
					  double winkeldrei) {
	
	// Liste von Dreistrecken. Nehme die Strecken der
	// dreidimensionalen Welt. Jede Strecke hier wird zu einer
	// zweidimensionalen Fläche verlegt.
	Dreistrecke[] dsl = vw.nehmekanten();

	// Berechne die nötige Drehung.
	Dreimatrix drehung = Eulerdreher.nehmedrehung(winkeleins,
						      winkelzwei,
						      winkeldrei);
	
	// Liste von Zweistrecken. Mache die Strecken für eine
	// zweidimensionale Zweistreckewelt.
	Zweistrecke[] zsl = new Zweistrecke[dsl.length];
	
	for (int i = 0; i < dsl.length; i++) {
	    // Nehme die neue Strecke. Sie ist Teil einer neuen Welt,
	    // die Zweistreckewelt.
	    Zweistrecke zs = Streckeverleger.verlege(dsl[i], entfernung, brennweite,
						     breite, hoehe,
						     drehung);
	    
	    // Fügen sie zu der Liste ein.
	    zsl[i] = zs;
	}

	// Bauen die Zweistreckewelt auf.
	Zweistreckewelt zsw = new Zweistreckewelt(zsl);

	return zsw;
    }
}
