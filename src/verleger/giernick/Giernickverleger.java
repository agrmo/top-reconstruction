package verleger.giernick;

import dreher.vektor.Vektordreher;
import dreher.vektor.Vektordreher;
import strecke.Dreistrecke;
import strecke.Zweistrecke;
import vektor.Dreivektor;
import vektor.Zweivektor;
import welt.vielflach.Vielflachwelt;
import welt.zweistrecke.Zweistreckewelt;

// Ein Giernickverleger verlegt eine dreidimensionale Welt von
// Vielflächen zu einer zweidimensionalen Welt von Punkten und
// Strecken.
//
// Schritte:
// 1. Drehen alle Vektoren in der xz-Fläche mit einem Gierwinkel.
// 2. Drehen alle Vektoren in der yz-Fläche mit einem Nickwinkel.
// 3. Entfernen die Kamera vom Ursprung.
// 4. Projizieren alle Vektore zu einer zweidimensionalen Fläche.
// 5. Verschieben alle Vektore zum Zentrum des Bildchirms.
public class Giernickverleger {

    // ein: Dreivektor, Giernicksicht
    // aus: Zweivektor
    //
    // Verlege den gegeben dreidimensionalen Vektor.
    static Zweivektor verlegen(Dreivektor pa, Dreivektor augevektor, double brennweite,
			       double breite, double hoehe,
			       double gier, double nick) {

	Dreivektor pb = Vektordreher.drehenY(pa, gier);
	Dreivektor pc = Vektordreher.drehenX(pb, nick);

	// Trennen das Auge vom Ursprung der Welt.
	pc.eins -= augevektor.eins;
	pc.zwei -= augevektor.zwei;
	pc.drei -= augevektor.drei;

	// Letzendlich verlegen die Stellen von drei zu zwei Dimensionen.
	int zweiDimensionaleX = (int) ((0.5 * breite)
				       + (pc.eins/pc.drei) * brennweite);
	
	int zweiDimensionaleY = (int) ((0.5 * hoehe)
				       + (pc.zwei/pc.drei) * brennweite);

	Zweivektor aus = new Zweivektor(zweiDimensionaleX, zweiDimensionaleY);
	
	return aus;
    }

    // Ein: Liste von dreidimensionalen Vektoren
    // Aus: Liste von zweidimensionalen Vektoren
    //
    // Verlegen diese zweidimensionale Vektoren zu dreidimensionalen Vektoren.
    public static Zweivektor[] verlegen(Dreivektor[] dpl,
					Dreivektor augevektor, double brennweite,
					double breite, double hoehe,
					double gier, double nick) {
	
	Zweivektor[] zpl = new Zweivektor[dpl.length];

	for (int i = 0; i < dpl.length; i++) {
	    zpl[i] = Giernickverleger.verlegen(dpl[i], augevektor, brennweite,
					       breite, hoehe,
					       gier, nick);
	}
	
	return zpl;
    }

    // ein: Dreistrecke, Giernicksicht
    // aus: Zweistrecke
    //
    // Verlege die gegebene dreidimensionale Strecke.
    static Zweistrecke verlegen(Dreistrecke k,
				Dreivektor augevektor, double brennweite,
				double breite, double hoehe,
				double gier, double nick) {
	
	Zweivektor verlegterVektorVon = Giernickverleger.verlegen(k.von,
								  augevektor, brennweite,
								  breite, hoehe,
								  gier, nick);
	
	Zweivektor verlegterVektorBis = Giernickverleger.verlegen(k.bis, augevektor, brennweite,
								  breite, hoehe,
								  gier, nick);
	
	// Diese ist die neue Strecke, die nur in zwei Dimensionen
	// liegt. 
	Zweistrecke zk = new Zweistrecke(verlegterVektorVon, verlegterVektorBis);
	
	return zk;
    }

    // ein: Vielflachwelt, Giernicksicht
    //
    // Verlegen die dreidimensionale Vielflachwelt zu einer
    // zweidimensionale Zweistreckewelt.
    public static Zweistreckewelt verlegen(Vielflachwelt kw,
					   Dreivektor augevektor, double brennweite,
					   double breite, double hoehe,
					   double gier, double nick) {

	// Liste von Dreistrecken. Nehme die Strecken der
	// dreidimensionalen Welt.
	Dreistrecke[] dkl = kw.nehmekanten();
	
	// Liste von Zweistrecken. Mache die Strecken für eine
	// zweidimensionale Zweistreckewelt.
	Zweistrecke[] zsl = new Zweistrecke[dkl.length];
	
	for (int i = 0; i < dkl.length; i++) {
	    // Nehme die neue Strecke. Sie ist Teil einer neuen Welt,
	    // die Zweistreckewelt.
	    Zweistrecke zk = Giernickverleger.verlegen(dkl[i], augevektor, brennweite,
						       breite, hoehe,
						       gier, nick);
	    
	    // Fügen sie zu der Liste ein.
	    zsl[i] = zk;
	}

	// Bauen die Zweistreckewelt auf.
	Zweistreckewelt zkw = new Zweistreckewelt(zsl);

	return zkw;
    }
}
