package verleger.giernick;

import dreher.vektor.Vektordreher;
import strecke.Dreistrecke;
import strecke.Zweistrecke;
import vektor.Dreivektor;
import vektor.Zweivektor;
import welt.vielflach.Vielflachwelt;
import welt.zweistrecke.Zweistreckewelt;
import dreher.giernick.Giernickdreher;

// Ein Giernickverleger verlegt eine dreidimensionale Welt von
// Vielflächen zu einer zweidimensionalen Welt von Vektoren und
// Strecken.
//
// Schritte:
// 1. Drehen alle Vektore in der xz-Fläche mit einem Gierwinkel.
// 2. Drehen alle Vektore in der yz-Fläche mit einem Nickwinkel.
// 3. Entfernen die Kamera vom Ursprung.
// 4. Projizieren alle Vektore zu einer zweidimensionalen Fläche.
// 5. Verschieben alle Vektore zum Zentrum des Bildchirms.
public class Giernickverleger {

    public Giernickverleger() {
	
    }

    // ein: Dreivektor, Giernicksicht
    // aus: Zweivektor
    //
    // Verlege den gegeben dreidimensionalen Vektor.
    static Zweivektor verlegen(Dreivektor p, Dreivektor augevektor, int brennweite,
			      int breite, int hoehe,
			      double gier, double nick) {

	Dreivektor pgedreht = Giernickdreher.drehen(p, gier, nick);

	// Trennen das Auge vom Ursprung der Welt.
	pgedreht.eins -= augevektor.eins;
	pgedreht.zwei -= augevektor.zwei;
	pgedreht.drei -= augevektor.drei;

	// Letzendlich verlegen die Stellen von drei zu zwei Dimensionen.
	int zweiDimensionaleX = (int) ((0.5 * ((double) breite))
				       + (pgedreht.eins/pgedreht.drei) * ((double) brennweite));
	
	int zweiDimensionaleY = (int) ((0.5 * ((double) hoehe))
				       + (pgedreht.zwei/pgedreht.drei) * ((double) brennweite));

	Zweivektor aus = new Zweivektor(zweiDimensionaleX, zweiDimensionaleY);
	
	return aus;
    }

    // Ein: Liste von dreidimensionalen Vektoren
    // Aus: Liste von zweidimensionalen Vektoren
    //
    // Verlegen diese zweidimensionale Vektoren zu dreidimensionalen Vektoren.
    public static Zweivektor[] verlegen(Dreivektor[] dpl, Dreivektor augevektor, int brennweite,
				       int breite, int hoehe,
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
    static Zweistrecke verlegen(Dreistrecke k, Dreivektor augevektor, int brennweite,
				int breite, int hoehe,
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
					   Dreivektor augevektor, int brennweite,
					   int breite, int hoehe,
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
