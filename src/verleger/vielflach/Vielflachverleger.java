package verleger.vielflach;

import dreher.euler.Eulerdreher;
import druck.matrix.Matrixdrucker;
import matrix.Dreimatrix;
import strecke.Dreistrecke;
import strecke.Zweistrecke;
import vektor.Dreivektor;
import vektor.Zweivektor;
import welt.graph.Dreigraphwelt;
import welt.graph.Zweigraphwelt;
import welt.strecke.Zweistreckewelt;
import welt.vielflach.Vielflachwelt;

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

    // ein: Dreistrecke, ...
    // aus: Zweistrecke
    //
    // Verlege die gegebene dreidimensionale Strecke.
    public static Zweistrecke verlege(Dreistrecke ds,
				      Dreivektor entfernung, double brennweite,
				      double breite, double hoehe,
				      Dreimatrix drehung) {
	
	Zweivektor verlegterVektorVon = Vielflachverleger.verlege(ds.von,
							     entfernung, brennweite,
							     breite, hoehe,
							     drehung);
	
	Zweivektor verlegterVektorBis = Vielflachverleger.verlege(ds.bis,
							     entfernung, brennweite,
							     breite, hoehe,
							     drehung);
	
	// Diese ist die neue Strecke, die nur in zwei Dimensionen
	// liegt. 
	Zweistrecke zs = new Zweistrecke(verlegterVektorVon, verlegterVektorBis);
	
	return zs;
    }

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
	    Zweistrecke zs = Vielflachverleger.verlege(dsl[i], entfernung, brennweite,
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
