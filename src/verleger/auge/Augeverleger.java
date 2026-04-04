package verleger.auge;

import druck.matrix.Matrixdrucker;
import matrix.Dreimatrix;
import matrix.rollnickgier.Rollnickgiermatrix;
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
    public static Zweivektor verlegen(Dreivektor va,
				      Dreivektor augevektor, double brennweite,
				      double breite, double hoehe,
				      Dreimatrix basismatrix) {

	// Drehen die Basis der Vektor um.
	Dreivektor vb = basismatrix.punkt(va);

	// augevektor = basismatrix.punkt(augevektor);

	// Trenne den Vektor vom Ursprung, wie ein Augenpaar.
	// Je ferner der Vektor bewegt wird, desto kleiner sieht er aus.
	vb.eins -= augevektor.eins;
	vb.zwei -= augevektor.zwei;
	vb.drei -= augevektor.drei;

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
    public static Zweistrecke verlegen(Dreistrecke ds, Dreivektor augevektor, double brennweite,
				       double breite, double hoehe,
				       Dreimatrix basismatrix) {
	
	Zweivektor verlegterVektorVon = Augeverleger.verlegen(ds.von,
							      augevektor, brennweite,
							      breite, hoehe,
							      basismatrix);
	
	Zweivektor verlegterVektorBis = Augeverleger.verlegen(ds.bis, augevektor, brennweite,
							      breite, hoehe,
							      basismatrix);
	
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
    public static Zweistreckewelt verlegen(Vielflachwelt vw,
					   Dreivektor augevektor, double brennweite,
					   double breite, double hoehe) {
	
	// Liste von Dreistrecken. Nehme die Strecken der
	// dreidimensionalen Welt. Jede Strecke hier wird zu einer
	// zweidimensionalen Fläche verlegt.
	Dreistrecke[] dsl = vw.nehmekanten();

	// Berechne die Matrix, die die Basis dreht.
	Dreimatrix basismatrix = Rollnickgiermatrix.nehmebasisdrehungmatrix(augevektor);
	
	// Liste von Zweistrecken. Mache die Strecken für eine
	// zweidimensionale Zweistreckewelt.
	Zweistrecke[] zsl = new Zweistrecke[dsl.length];
	
	for (int i = 0; i < dsl.length; i++) {
	    // Nehme die neue Strecke. Sie ist Teil einer neuen Welt,
	    // die Zweistreckewelt.
	    Zweistrecke zs = Augeverleger.verlegen(dsl[i], augevektor, brennweite,
						   breite, hoehe,
						   basismatrix);
	    
	    // Fügen sie zu der Liste ein.
	    zsl[i] = zs;
	}

	// Bauen die Zweistreckewelt auf.
	Zweistreckewelt zsw = new Zweistreckewelt(zsl);

	return zsw;
    }

    // Die Kanten und Knoten dieses Graphen werden von drei
    // Dimensionen zu zwei Dimensionen verlegen.
    public static Zweigraphwelt verlegen(Dreigraphwelt dgw,
					 Dreivektor augevektor, double brennweite,
					 double breite, double hoehe) {

	// Die dreidimensionale Knoten sind dgw.orten.  Wir brauchen
	// nicht, die Kanten zu verlegen.  Wir müssen nur die
	// Dreivektoren innerhalb dgw.orten verlegen. Die Orten von
	// dgw.orten bestimmen die Kanten.  Es gibt nichts innerhalb
	// der Nachbarschaftsliste zu verlegen. Sie enthält keine
	// Orten. Nach der Verlegung von dgw.orten, können wir
	// nehmekanten() von der Zweigraphwelt nehmen. Fertig.

	// Berechne die Matrix, die die Basis dreht.
	Dreimatrix basismatrix = Rollnickgiermatrix.nehmebasisdrehungmatrix(augevektor);

	// Die zweidimensionale Knoten.
	Zweivektor[] zweiorten = new Zweivektor[dgw.orten.length];

	for (int i = 0; i < dgw.orten.length; i++) {
	    
	    // dgw.orten[i] Dreivektor -> zweiorten[i] Zweivektor
	    zweiorten[i] = Augeverleger.verlegen(dgw.orten[i],
						 augevektor, brennweite,
						 breite, hoehe,
						 basismatrix);
	}

	Zweigraphwelt zgw = new Zweigraphwelt(dgw.graph, zweiorten);

	return zgw;
    }
}
