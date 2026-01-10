package verleger.auge;

import dreher.punkt.Punktdreher;
import strecke.Dreistrecke;
import strecke.Zweistrecke;
import punkt.Dreipunkt;
import punkt.Zweipunkt;
import welt.vielflach.Vielflachwelt;
import welt.zweistrecke.Zweistreckewelt;

// Ein Augeverleger nimmt eine dreidimensionale Vielflachwelt zu einer
// zweidimensionalen Streckenwelt. Wir benutzen ein punktliches Auge als
// Ursache der Sicht.
public class Augeverleger {

    public Augeverleger() {
	
    }

    // ein: Dreipunkt, Augesicht
    // aus: Zweipunkt
    //
    // Verlege den gegeben dreidimensionalen Punkt.
    static Zweipunkt verlegen(Dreipunkt p, Dreipunkt augepunkt, int brennweite,
			      int breite, int hoehe,
			      double gier, double nick, double roll) {

	// Drehen den Punkt in der xz-Fläche.
	Zweipunkt xz = Punktdreher.drehen(new Zweipunkt(p.xteil, p.zteil), gier);

	// Drehen den Punkt in der yz-Achse.
	Zweipunkt yz = Punktdreher.drehen(new Zweipunkt(p.yteil, xz.yteil), nick);

	// Drehen den Punkt in der xy-Achse.
	Zweipunkt xy = Punktdreher.drehen(new Zweipunkt(xz.xteil, yz.xteil), roll);

	// Nehmen die x, y und z-Punkte.
	double x = xy.xteil;
	double y = xy.yteil;
	double z = yz.yteil;

	// Trennen das Auge vom Ursprung der Welt.
	x -= augepunkt.xteil;
	y -= augepunkt.yteil;
	z -= augepunkt.zteil;

	// Letzendlich verlegen die Stellen von drei zu zwei Dimensionen.
	int zweiDimensionaleX = (int) ((0.5 * ((double) breite))
				       + (x/z) * ((double) brennweite));
	
	int zweiDimensionaleY = (int) ((0.5 * ((double) hoehe))
				       + (y/z) * ((double) brennweite));

	Zweipunkt aus = new Zweipunkt(zweiDimensionaleX, zweiDimensionaleY);
	
	return aus;
    }

    // Ein: Liste von dreidimensionalen Punkten
    // Aus: Liste von zweidimensionalen Punkten
    //
    // Verlegen diese zweidimensionale Punkten zu dreidimensionalen Punkten.
    public static Zweipunkt[] verlegen(Dreipunkt[] dpl, Dreipunkt augepunkt, int brennweite,
				       int breite, int hoehe,
				       double gier, double nick, double roll) {
	
	Zweipunkt[] zpl = new Zweipunkt[dpl.length];

	for (int i = 0; i < dpl.length; i++) {
	    zpl[i] = Augeverleger.verlegen(dpl[i], augepunkt, brennweite,
					   breite, hoehe,
					   gier, nick, roll);
	}
	
	return zpl;
    }

    // ein: Dreistrecke, Augesicht
    // aus: Zweistrecke
    //
    // Verlege die gegebene dreidimensionale Strecke.
    static Zweistrecke verlegen(Dreistrecke k, Dreipunkt augepunkt, int brennweite,
			      int breite, int hoehe,
			      double gier, double nick, double roll) {
	
	Zweipunkt verlegterPunktVon = Augeverleger.verlegen(k.von,
							    augepunkt, brennweite,
							    breite, hoehe,
							    gier, nick, roll);
	
	Zweipunkt verlegterPunktBis = Augeverleger.verlegen(k.bis, augepunkt, brennweite,
							    breite, hoehe,
							    gier, nick, roll);
	
	// Diese ist die neue Strecke, die nur in zwei Dimensionen
	// liegt. 
	Zweistrecke zk = new Zweistrecke(verlegterPunktVon, verlegterPunktBis);
	
	return zk;
    }

    // ein: Vielflachwelt, Augesicht
    //
    // Verlegen die dreidimensionale Vielflachwelt zu einer
    // zweidimensionale Zweistreckewelt.
    public static Zweistreckewelt verlegen(Vielflachwelt kw,
					   Dreipunkt augepunkt, int brennweite,
					   int breite, int hoehe,
					   double gier, double nick, double roll) {

	// Liste von Dreistrecken. Nehme die Strecken der
	// dreidimensionalen Welt.
	Dreistrecke[] dkl = kw.nehmekanten();
	
	// Liste von Zweistrecken. Mache die Strecken für eine
	// zweidimensionale Zweistreckewelt.
	Zweistrecke[] zsl = new Zweistrecke[dkl.length];
	
	for (int i = 0; i < dkl.length; i++) {
	    // Nehme die neue Strecke. Sie ist Teil einer neuen Welt,
	    // die Zweistreckewelt.
	    Zweistrecke zk = Augeverleger.verlegen(dkl[i], augepunkt, brennweite,
						   breite, hoehe,
						   gier, nick, roll);
	
	    // Fügen sie zu der Liste ein.
	    zsl[i] = zk;
	}

	// Bauen die Zweistreckewelt auf.
	Zweistreckewelt zkw = new Zweistreckewelt(zsl);

	return zkw;
    }
}
