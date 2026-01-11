package verleger.giernick;

import dreher.punkt.Punktdreher;
import strecke.Dreistrecke;
import strecke.Zweistrecke;
import punkt.Dreipunkt;
import punkt.Zweipunkt;
import welt.vielflach.Vielflachwelt;
import welt.zweistrecke.Zweistreckewelt;
import dreher.giernick.Giernickdreher;

// Ein Giernickverleger verlegt eine dreidimensionale Welt von
// Vielflächen zu einer zweidimensionalen Welt von Punkten und
// Strecken.
//
// Schritte:
// 1. Drehen alle Punkte in der xz-Fläche mit einem Gierwinkel.
// 2. Drehen alle Punkte in der yz-Fläche mit einem Nickwinkel.
// 3. Entfernen die Kamera vom Ursprung.
// 4. Projizieren alle Punkte zu einer zweidimensionalen Fläche.
// 5. Verschieben alle Punkte zum Zentrum des Bildchirms.
public class Giernickverleger {

    public Giernickverleger() {
	
    }

    // ein: Dreipunkt, Giernicksicht
    // aus: Zweipunkt
    //
    // Verlege den gegeben dreidimensionalen Punkt.
    static Zweipunkt verlegen(Dreipunkt p, Dreipunkt augepunkt, int brennweite,
			      int breite, int hoehe,
			      double gier, double nick) {

	Dreipunkt pgedreht = Giernickdreher.drehen(p, gier, nick);

	// Trennen das Auge vom Ursprung der Welt.
	pgedreht.xteil -= augepunkt.xteil;
	pgedreht.yteil -= augepunkt.yteil;
	pgedreht.zteil -= augepunkt.zteil;

	// Letzendlich verlegen die Stellen von drei zu zwei Dimensionen.
	int zweiDimensionaleX = (int) ((0.5 * ((double) breite))
				       + (pgedreht.xteil/pgedreht.zteil) * ((double) brennweite));
	
	int zweiDimensionaleY = (int) ((0.5 * ((double) hoehe))
				       + (pgedreht.yteil/pgedreht.zteil) * ((double) brennweite));

	Zweipunkt aus = new Zweipunkt(zweiDimensionaleX, zweiDimensionaleY);
	
	return aus;
    }

    // Ein: Liste von dreidimensionalen Punkten
    // Aus: Liste von zweidimensionalen Punkten
    //
    // Verlegen diese zweidimensionale Punkten zu dreidimensionalen Punkten.
    public static Zweipunkt[] verlegen(Dreipunkt[] dpl, Dreipunkt augepunkt, int brennweite,
				       int breite, int hoehe,
				       double gier, double nick) {
	
	Zweipunkt[] zpl = new Zweipunkt[dpl.length];

	for (int i = 0; i < dpl.length; i++) {
	    zpl[i] = Giernickverleger.verlegen(dpl[i], augepunkt, brennweite,
					       breite, hoehe,
					       gier, nick);
	}
	
	return zpl;
    }

    // ein: Dreistrecke, Giernicksicht
    // aus: Zweistrecke
    //
    // Verlege die gegebene dreidimensionale Strecke.
    static Zweistrecke verlegen(Dreistrecke k, Dreipunkt augepunkt, int brennweite,
				int breite, int hoehe,
				double gier, double nick) {
	
	Zweipunkt verlegterPunktVon = Giernickverleger.verlegen(k.von,
							    augepunkt, brennweite,
							    breite, hoehe,
							    gier, nick);
	
	Zweipunkt verlegterPunktBis = Giernickverleger.verlegen(k.bis, augepunkt, brennweite,
							    breite, hoehe,
							    gier, nick);
	
	// Diese ist die neue Strecke, die nur in zwei Dimensionen
	// liegt. 
	Zweistrecke zk = new Zweistrecke(verlegterPunktVon, verlegterPunktBis);
	
	return zk;
    }

    // ein: Vielflachwelt, Giernicksicht
    //
    // Verlegen die dreidimensionale Vielflachwelt zu einer
    // zweidimensionale Zweistreckewelt.
    public static Zweistreckewelt verlegen(Vielflachwelt kw,
					   Dreipunkt augepunkt, int brennweite,
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
	    Zweistrecke zk = Giernickverleger.verlegen(dkl[i], augepunkt, brennweite,
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
