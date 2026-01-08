package verleger.auge;

import dreher.punkt.Punktdreher;
import strecke.Dreistrecke;
import strecke.Zweistrecke;
import punkt.Dreipunkt;
import punkt.Zweipunkt;
import welt.koerper.Koerperwelt;
import welt.zweistrecke.Zweistreckewelt;

// Ein Augeverleger nimmt eine dreidimensionale Körperwelt zu einer
// zweidimensionalen Streckenwelt. Wir benutzen ein punktliches Auge als
// Ursache der Sicht.
public class Augeverleger {

    public Augeverleger() {
	
    }

    // ein: Dreipunkt, Augesicht
    // aus: Zweipunkt
    //
    // Verlege den gegeben dreidimensionalen Punkt.
    static Zweipunkt verlegen(Dreipunkt p, Dreipunkt augepunkt, int perspektive,
			      int breite, int hoehe,
			      double yaw, double pitch, double roll) {

	Zweipunkt xz = Punktdreher.drehen(new Zweipunkt(p.xteil, p.zteil), yaw);
	Zweipunkt yz = Punktdreher.drehen(new Zweipunkt(p.yteil, xz.yteil), pitch);
	Zweipunkt xy = Punktdreher.drehen(new Zweipunkt(xz.xteil, yz.xteil), pitch);

	double x = xy.xteil;
	double y = xy.yteil;
	double z = yz.yteil;

	x -= augepunkt.xteil;
	y -= augepunkt.yteil;
	z -= augepunkt.zteil;

	int zweiDimensionaleX = (int) ((0.5 * ((double) breite)) + (x / z) * ((double) perspektive));
	int zweiDimensionaleY = (int) ((0.5 * ((double) hoehe)) + (y / z) * ((double) perspektive));

	Zweipunkt aus = new Zweipunkt(zweiDimensionaleX, zweiDimensionaleY);
	
	return aus;
    }

    // Ein: Liste von dreidimensionalen Punkten
    // Aus: Liste von zweidimensionalen Punkten
    //
    // Verlegen diese zweidimensionale Punkten zu dreidimensionalen Punkten.
    public static Zweipunkt[] verlegen(Dreipunkt[] dpl, Dreipunkt augepunkt, int perspektive,
				       int breite, int hoehe,
				       double yaw, double pitch, double roll) {
	
	Zweipunkt[] zpl = new Zweipunkt[dpl.length];

	for (int i = 0; i < dpl.length; i++) {
	    zpl[i] = Augeverleger.verlegen(dpl[i], augepunkt, perspektive,
					   breite, hoehe,
					   yaw, pitch, roll);
	}
	
	return zpl;
    }

    // ein: Dreistrecke, Augesicht
    // aus: Zweistrecke
    //
    // Verlege die gegebene dreidimensionale Strecke.
    static Zweistrecke verlegen(Dreistrecke k, Dreipunkt augepunkt, int perspektive,
			      int breite, int hoehe,
			      double yaw, double pitch, double roll) {
	
	Zweipunkt verlegterPunktVon = Augeverleger.verlegen(k.von,
							    augepunkt, perspektive,
							    breite, hoehe,
							    yaw, pitch, roll);
	
	Zweipunkt verlegterPunktBis = Augeverleger.verlegen(k.bis, augepunkt, perspektive,
							    breite, hoehe,
							    yaw, pitch, roll);
	
	// Diese ist die neue Strecke, die nur in zwei Dimensionen
	// liegt. 
	Zweistrecke zk = new Zweistrecke(verlegterPunktVon, verlegterPunktBis);
	
	return zk;
    }

    // ein: Körperwelt, Augesicht
    //
    // Verlegen die dreidimensionale Körperwelt zu einer
    // zweidimensionale Zweistreckewelt.
    public static Zweistreckewelt verlegen(Koerperwelt kw,
					 Dreipunkt augepunkt, int perspektive,
					 int breite, int hoehe,
					 double yaw, double pitch, double roll) {

	// Liste von Dreistrecken. Nehme die Strecken der
	// dreidimensionalen Welt.
	Dreistrecke[] dkl = kw.nehmeStrecken();
	
	// Liste von Zweistrecken. Mache die Strecken für eine
	// zweidimensionale Zweistreckewelt.
	Zweistrecke[] zsl = new Zweistrecke[dkl.length];
	
	for (int i = 0; i < dkl.length; i++) {
	    // Nehme die neue Strecke. Sie ist Teil einer neuen Welt,
	    // die Zweistreckewelt.
	    Zweistrecke zk = Augeverleger.verlegen(dkl[i], augepunkt, perspektive,
						   breite, hoehe,
						   yaw, pitch, roll);
	
	    // Fügen sie zu der Liste ein.
	    zsl[i] = zk;
	}

	// Bauen die Zweistreckewelt auf.
	Zweistreckewelt zkw = new Zweistreckewelt(zsl);

	return zkw;
    }
}
