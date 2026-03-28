package verleger.basis.passiv;

import druck.vektor.Vektordrucker;
import dreher.vektor.Vektordreher;
import dreher.vektor.Vektordreher;
import strecke.Dreistrecke;
import strecke.Zweistrecke;
import vektor.Dreivektor;
import vektor.Zweivektor;
import welt.vielflach.Vielflachwelt;
import welt.strecke.Zweistreckewelt;
import matrix.Dreimatrix;
import welt.graph.Zweigraphwelt;
import welt.graph.Dreigraphwelt;

// Ein Basisverlegerpassiv verlegt eine dreidimensionale Welt von
// Vielflächen zu einer zweidimensionalen Welt von Vektoren und
// Strecken, aber nur mit einer Umwandlung für die Augen.
//
// Schritte:
// 1. Drehe die Augen um.
// 3. Entfernen den Augen vom Ursprung.
// 4. Projizieren alle Vektoren zu einer zweidimensionalen Fläche.
// 5. Verschieben alle Vektoren zum Zentrum des Bildschirms.
//
// Die echte ursprüngliche Stellen der Dingen in der Welt stehen bleiben.
public class Basisverlegerpassiv {

    // ein: Dreivektor, ...
    // aus: Zweivektor
    //
    // Verlege den gegeben dreidimensionalen Vektor.
    public static Zweivektor verlegen(Dreivektor pa,
				      Dreivektor augevektor, double brennweite,
				      double breite, double hoehe,
				      Dreimatrix vorbasis, Dreimatrix basis) {

	// Drehe den Punkt nicht. Nur verlege den Punkt.
	// Die Augen sind schon verlegen.

	// Ja entferne den Punkt.
	pa.eins -= augevektor.eins;
	pa.zwei -= augevektor.zwei;
	pa.drei -= augevektor.drei;
	
	// Verlegen die Stellen von drei zu zwei Dimensionen.
	int zweiDimensionaleX = (int) ((0.5 * breite)
				       + (pa.eins/pa.drei) * brennweite);
	
	int zweiDimensionaleY = (int) ((0.5 * hoehe)
				       + (pa.zwei/pa.drei) * brennweite);

	Zweivektor aus = new Zweivektor(zweiDimensionaleX, zweiDimensionaleY);
	
	return aus;
    }

    // ein: Dreistrecke, ...
    // aus: Zweistrecke
    //
    // Verlege die gegebene dreidimensionale Strecke.
    public static Zweistrecke verlegen(Dreistrecke ds, Dreivektor augevektor, double brennweite,
				       double breite, double hoehe,
				       Dreimatrix vorbasis, Dreimatrix basis) {
	
	Zweivektor verlegterVektorVon = Basisverlegerpassiv.verlegen(ds.von,
								     augevektor, brennweite,
								     breite, hoehe,
								     vorbasis, basis);
	
	Zweivektor verlegterVektorBis = Basisverlegerpassiv.verlegen(ds.bis, augevektor, brennweite,
								     breite, hoehe,
								     vorbasis, basis);
	
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
					   double breite, double hoehe,
					   Dreimatrix vorbasis, Dreimatrix basis) {

	// Wir müssen die Augen hier drehen.  Im Vergleich mit dem
	// Basisverleger müssen wir nur die Augen drehen.  Die
	// ursprünglichen Stellen der Dingen dieser Welt werden nicht
	// gedreht.

	// Wir haben eine Wahl. Wir können entweder eine aktive oder
	// eine passive Umwandlung der Koordinatenstellen
	// benutzen. Offentsichtlich ist eine passive Umwandlung
	// rechnerisch schneller. Aber beide Konzepten sind wichtig zu
	// programmieren. Hier benutzen wir eine passive
	// Umwandlung. Deshalb werden wir den Titel "passiv"
	// schreiben. Die aktive Umwandlung ist nicht
	// programmiert. Sie ergibt keinen Vorteil.
	
	Dreivektor augevektorb = vorbasis.punkt(augevektor);
	Dreivektor augevektorc = basis.punkt(augevektorb);
	
	// Liste von Dreistrecken. Nehme die Strecken der
	// dreidimensionalen Welt.
	Dreistrecke[] dsl = vw.nehmekanten();
	
	// Liste von Zweistrecken. Mache die Strecken für eine
	// zweidimensionale Zweistreckewelt.
	Zweistrecke[] zsl = new Zweistrecke[dsl.length];
	
	for (int i = 0; i < dsl.length; i++) {
	    // Nehme die neue Strecke. Sie ist Teil einer neuen Welt,
	    // die Zweistreckewelt.
	    Zweistrecke zs = Basisverlegerpassiv.verlegen(dsl[i], augevektorc, brennweite,
							  breite, hoehe,
							  vorbasis, basis);
	
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
					 double breite, double hoehe,
					 Dreimatrix vorbasis, Dreimatrix basis) {

	// Die dreidimensionale Knoten sind dgw.orten.  Wir brauchen
	// nicht, die Kanten zu verlegen.  Die Orten von dgw.orten
	// bestimmen die Kanten.  Es gibt nichts innerhalb der
	// Nachbarschaftsliste zu verlegen. Sie enthält keine
	// Orten. Nach der Verlegung von dgw.orten, können wir
	// nehmekanten() von der Zweigraphwelt nehmen. Fertig.

	// Die zweidimensionale Knoten.
	Zweivektor[] zweiorten = new Zweivektor[dgw.orten.length];

	for (int i = 0; i < dgw.orten.length; i++) {
	    zweiorten[i] = Basisverlegerpassiv.verlegen(dgw.orten[i],
							augevektor, brennweite,
							breite, hoehe,
							vorbasis, basis);
	}

	Zweigraphwelt zgw = new Zweigraphwelt(dgw.graph, zweiorten);

	return zgw;
    }
}
