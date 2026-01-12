package verleger.basis;

import dreher.vektor.Vektordreher;
import dreher.vektor.Vektordreher;
import strecke.Dreistrecke;
import strecke.Zweistrecke;
import vektor.Dreivektor;
import vektor.Zweivektor;
import welt.vielflach.Vielflachwelt;
import welt.zweistrecke.Zweistreckewelt;
import matrix.Dreimatrix;

// Ein Basisverleger verlegt eine dreidimensionale Welt von
// Vielflächen zu einer zweidimensionalen Welt von Vektoren und
// Strecken.
//
// Schritte:
// 1. Wandeln alle Punkte zur neuen Basis um.
// 3. Entfernen die Kamera vom Ursprung.
// 4. Projizieren alle Vektore zu einer zweidimensionalen Fläche.
// 5. Verschieben alle Vektore zum Zentrum des Bildchirms.
public class Basisverleger {

    // ein: Dreivektor, Giernicksicht
    // aus: Zweivektor
    //
    // Verlege den gegeben dreidimensionalen Vektor.
    public static Zweivektor verlegen(Dreivektor pa, Dreivektor augevektor, double brennweite,
			       double breite, double hoehe,
			       Dreimatrix basis) {

	Dreivektor pb = basis.punkt(pa);

	// Trennen das Auge vom Ursprung der Welt.
	pb.eins -= augevektor.eins;
	pb.zwei -= augevektor.zwei;
	pb.drei -= augevektor.drei;

	// Letzendlich verlegen die Stellen von drei zu zwei Dimensionen.
	int zweiDimensionaleX = (int) ((0.5 * breite)
				       + (pb.eins/pb.drei) * brennweite);
	
	int zweiDimensionaleY = (int) ((0.5 * hoehe)
				       + (pb.zwei/pb.drei) * brennweite);

	Zweivektor aus = new Zweivektor(zweiDimensionaleX, zweiDimensionaleY);
	
	return aus;
    }

    // ein: Dreistrecke
    // aus: Zweistrecke
    //
    // Verlege die gegebene dreidimensionale Strecke.
    public static Zweistrecke verlegen(Dreistrecke k, Dreivektor augevektor, double brennweite,
				double breite, double hoehe,
				Dreimatrix basis) {
	
	Zweivektor verlegterVektorVon = Basisverleger.verlegen(k.von,
							       augevektor, brennweite,
							       breite, hoehe,
							       basis);
	
	Zweivektor verlegterVektorBis = Basisverleger.verlegen(k.bis, augevektor, brennweite,
							       breite, hoehe,
							       basis);
	
	// Diese ist die neue Strecke, die nur in zwei Dimensionen
	// liegt. 
	Zweistrecke zk = new Zweistrecke(verlegterVektorVon, verlegterVektorBis);
	
	return zk;
    }

    // Ein: Liste von dreidimensionalen Vektoren
    // Aus: Liste von zweidimensionalen Vektoren
    //
    // Verlegen diese zweidimensionale Vektoren zu dreidimensionalen Vektoren.
    public static Zweivektor[] verlegen(Dreivektor[] dpl, Dreivektor augevektor, double brennweite,
					double breite, double hoehe,
					Dreimatrix basis) {
	
	Zweivektor[] zpl = new Zweivektor[dpl.length];

	for (int i = 0; i < dpl.length; i++) {
	    zpl[i] = Basisverleger.verlegen(dpl[i], augevektor, brennweite,
					    breite, hoehe,
					    basis);
	}
	
	return zpl;
    }

    // ein: Vielflachwelt, Giernicksicht
    //
    // Verlegen die dreidimensionale Vielflachwelt zu einer
    // zweidimensionale Zweistreckewelt.
    public static Zweistreckewelt verlegen(Vielflachwelt kw,
					   Dreivektor augevektor, double brennweite,
					   double breite, double hoehe,
					   Dreimatrix basis) {
	
	// Liste von Dreistrecken. Nehme die Strecken der
	// dreidimensionalen Welt.
	Dreistrecke[] dkl = kw.nehmekanten();
	
	// Liste von Zweistrecken. Mache die Strecken für eine
	// zweidimensionale Zweistreckewelt.
	Zweistrecke[] zsl = new Zweistrecke[dkl.length];
	
	for (int i = 0; i < dkl.length; i++) {
	    // Nehme die neue Strecke. Sie ist Teil einer neuen Welt,
	    // die Zweistreckewelt.
	    Zweistrecke zk = Basisverleger.verlegen(dkl[i], augevektor, brennweite,
						    breite, hoehe,
						    basis);
	    
	    // Fügen sie zu der Liste ein.
	    zsl[i] = zk;
	}

	// Bauen die Zweistreckewelt auf.
	Zweistreckewelt zkw = new Zweistreckewelt(zsl);

	return zkw;
    }
}
