package verleger.auge;

import dreher.achse.Achsedreher;
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

// Ein Augeverleger verlegt eine dreidimensionale Welt von
// Vielflächen zu einer zweidimensionalen Welt von Vektoren und
// Strecken.
//
// Schritte:
// 1. Berechne die nötige Drehung.
// 2. Drehe den Punkt.
// 3. Entfernen die Kamera vom Ursprung.
// 4. Projizieren alle Vektoren zu einer zweidimensionalen Fläche.
// 5. Verschieben alle Vektoren zum Zentrum des Bildchirms.
public class Augeverleger {
    
    // ein: Dreivektor, ...
    // aus: Zweivektor
    //
    // Verlege den gegeben dreidimensionalen Vektor.
    public static Zweivektor verlege(Dreivektor va,
				     double augenentfernung, double brennweite,
				     double breite, double hoehe,
				     Dreimatrix basis) {
	
	
	// Drehen die Basis der Vektor um.
	Dreivektor vb = basis.punkt(va);

	// Jetzt ist die Stelle gedreht.
	// Entferne die Augen entlang der z-Achse.
	va.drei -= augenentfernung;
	
	// Letzendlich verlegen die Stellen von drei zu zwei Dimensionen.
	int zweiDimensionaleX = (int) ((0.5 * breite)
				       + (vb.eins/vb.drei) * brennweite);
	
	int zweiDimensionaleY = (int) ((0.5 * hoehe)
				       + (vb.zwei/vb.drei) * brennweite);

	Zweivektor aus = new Zweivektor(zweiDimensionaleX, zweiDimensionaleY);
	
	return aus;
    }

    // ein: Dreistrecke, ...
    // aus: Zweistrecke
    //
    // Verlege die gegebene dreidimensionale Strecke.
    public static Zweistrecke verlege(Dreistrecke ds, double augenentfernung, double brennweite,
				      double breite, double hoehe,
				      Dreimatrix basis) {
	
	Zweivektor verlegterVektorVon = Augeverleger.verlege(ds.von,
							     augenentfernung, brennweite,
							     breite, hoehe,
							     basis);
	
	Zweivektor verlegterVektorBis = Augeverleger.verlege(ds.bis, augenentfernung, brennweite,
							     breite, hoehe,
							     basis);
	
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
					  Dreivektor augevektor, double brennweite,
					  double breite, double hoehe) {
	
	// Liste von Dreistrecken. Nehme die Strecken der
	// dreidimensionalen Welt. Jede Strecke hier wird zu einer
	// zweidimensionalen Fläche verlegt.
	Dreistrecke[] dsl = vw.nehmekanten();

	// Berechne die nötige Drehung.
	Dreimatrix basis = Achsedreher.nehmexachsedrehung(augevektor);

	// Berechne den Betrag des Vektors. Er ist die Augeentfernung.
	double augenentfernung = augevektor.betrag();
	
	// Liste von Zweistrecken. Mache die Strecken für eine
	// zweidimensionale Zweistreckewelt.
	Zweistrecke[] zsl = new Zweistrecke[dsl.length];
	
	for (int i = 0; i < dsl.length; i++) {
	    // Nehme die neue Strecke. Sie ist Teil einer neuen Welt,
	    // die Zweistreckewelt.
	    Zweistrecke zs = Augeverleger.verlege(dsl[i], augenentfernung, brennweite,
						  breite, hoehe,
						  basis);
	    
	    // Fügen sie zu der Liste ein.
	    zsl[i] = zs;
	}

	// Bauen die Zweistreckewelt auf.
	Zweistreckewelt zsw = new Zweistreckewelt(zsl);

	return zsw;
    }

    // Die Kanten und Knoten dieses Graphen werden von drei
    // Dimensionen zu zwei Dimensionen verlegen.
    public static Zweigraphwelt verlege(Dreigraphwelt dgw,
					Dreivektor augevektor, double brennweite,
					double breite, double hoehe) {

	// Die dreidimensionale Knoten sind dgw.orten.  Wir brauchen
	// nicht, die Kanten zu verlegen.  Wir müssen nur die
	// Dreivektoren innerhalb dgw.orten verlegen. Die Orten von
	// dgw.orten bestimmen die Kanten.  Es gibt nichts innerhalb
	// der Nachbarschaftsliste zu verlegen. Sie enthält keine
	// Orten. Nach der Verlegung von dgw.orten, können wir
	// nehmekanten() von der Zweigraphwelt nehmen. Fertig.

	// ich verstehe nicht
	Dreimatrix basis = new Dreimatrix(0,0,1,0,1,0,0,0,1);

	// Berechne den Betrag des Vektors. Er ist die Augeentfernung.
	double augenentfernung = augevektor.betrag();

	// Die zweidimensionale Knoten.
	Zweivektor[] zweiorten = new Zweivektor[dgw.orten.length];

	for (int i = 0; i < dgw.orten.length; i++) {
	    
	    // dgw.orten[i] Dreivektor -> zweiorten[i] Zweivektor
	    zweiorten[i] = Augeverleger.verlege(dgw.orten[i],
						augenentfernung, brennweite,
						breite, hoehe,
						basis);
	}

	Zweigraphwelt zgw = new Zweigraphwelt(dgw.graph, zweiorten);

	return zgw;
    }
}
