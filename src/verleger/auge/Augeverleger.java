package verleger.auge;

import dreher.punkt.Punktdreher;
import java.util.ArrayList;
import kante.Dreikante;
import kante.Zweikante;
import punkt.Dreipunkt;
import punkt.Zweipunkt;
import welt.koerper.Koerperwelt;
import welt.zweikante.Zweikantewelt;

// Ein Augeverleger nimmt eine dreidimensionale Körperwelt zu einer
// zweidimensionalen Kantenwelt. Wir benutzen ein punktliches Auge als
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

    // ein: Dreikante, Augesicht
    // aus: Zweikante
    //
    // Verlege die gegebene dreidimensionale Kante.
    static Zweikante verlegen(Dreikante k, Dreipunkt augepunkt, int perspektive,
			      int breite, int hoehe,
			      double yaw, double pitch, double roll) {
	
	Zweipunkt verlegterPunktVon = Augeverleger.verlegen(k.von,
							    augepunkt, perspektive,
							    breite, hoehe,
							    yaw, pitch, roll);
	
	Zweipunkt verlegterPunktBis = Augeverleger.verlegen(k.bis, augepunkt, perspektive,
							    breite, hoehe,
							    yaw, pitch, roll);
	
	// Diese ist die neue Kante, die nur in zwei Dimensionen
	// liegt. 
	Zweikante zk = new Zweikante(verlegterPunktVon, verlegterPunktBis);
	
	return zk;
    }

    // ein: Körperwelt, Augesicht
    //
    // Verlegen die dreidimensionale Körperwelt zu einer
    // zweidimensionale Zweikantewelt.
    public static Zweikantewelt verlegen(Koerperwelt kw,
					 Dreipunkt augepunkt, int perspektive,
					 int breite, int hoehe,
					 double yaw, double pitch, double roll) {

	// Liste von Dreikanten. Nehme die Kanten der
	// dreidimensionalen Welt.
	ArrayList<Dreikante> dkl = kw.nehmeKanten();

	// Liste von Zweikanten. Mache die Kanten für eine
	// zweidimensionale Zweikantewelt.
	ArrayList<Zweikante> zkl = new ArrayList<Zweikante>();
	
	for (int i = 0; i < dkl.size(); i++) {
	    // Nehme die neue Kante. Sie ist Teil einer neuen Welt,
	    // die Zweikantewelt.
	    Zweikante zk = Augeverleger.verlegen(dkl.get(i), augepunkt, perspektive,
						 breite, hoehe,
						 yaw, pitch, roll);
	
	    // Fügen sie zu der Liste ein.
	    zkl.add(zk);
	}

	// Bauen die Zweikantewelt auf.
	Zweikantewelt zkw = new Zweikantewelt(zkl);

	return zkw;
    }
}
