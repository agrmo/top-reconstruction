package verleger.schief;

import java.util.ArrayList;
import kante.Dreikante;
import kante.Zweikante;
import punkt.Dreipunkt;
import punkt.Zweipunkt;
import welt.zweikante.Zweikantewelt;
import welt.koerper.Koerperwelt;

// Ein Schiefverleger nimmt eine dreidimensionale Körperwelt zu
// einer zweidimensionalen Kantenwelt mit Hilfe einer orthographischen
// Verlegung.
public class Schiefverleger {

    // Die Verlegungszahl.
    public double a;

    public Schiefverleger(double a) {
	this.a = a;
    }

    // ein: Dreipunkt
    // aus: Zweipunkt
    //
    // Verlege den gegeben dreidimensionalen Punkt auf einer
    // Sichtfläche, um einen zweidimensionalen Punkt zu bekommen.
    Zweipunkt verlegenPunkt(Dreipunkt p) {
	double ausX = p.eins + (this.a * p.drei);
	double ausY = p.zwei + (this.a * p.drei);

	Zweipunkt aus = new Zweipunkt(ausX, ausY);
	
	return aus;
    }

    // ein: Dreikante
    // aus: Zweikante
    //
    // Verlege die gegebene dreidimensionale Kante auf einer
    // Sichtfläche, um eine zweidimensionale Kante zu bekommen.
    Zweikante verlegenKante(Dreikante k) {
	Zweipunkt verlegterPunktVon = this.verlegenPunkt(k.von);
	Zweipunkt verlegterPunktBis = this.verlegenPunkt(k.bis);

	// Diese ist die neue Kante, die nur in zwei Dimensionen
	// liegt. 
	Zweikante zk = new Zweikante(verlegterPunktVon, verlegterPunktBis);
	
	return zk;
    }

    // ein: Körperwelt
    // kw: Die dreidimensionale Welt mit den ursprünglichen Daten.
    //
    // Verlegen die dreidimensionale Körperwelt zu einer
    // zweidimensionale Zweikantewelt.
    //
    public Zweikantewelt verlegenWelt(Koerperwelt kw) {

	// Liste von Dreikanten. Nehme die Kanten der
	// dreidimensionalen Welt.
	ArrayList<Dreikante> dkl = kw.nehmeKanten();

	// Liste von Zweikanten. Mache die Kanten für eine
	// zweidimensionale Zweikantewelt.
	ArrayList<Zweikante> zkl = new ArrayList<Zweikante>();
	
	for (int i = 0; i < dkl.size(); i++) {
	    // Nehme die neue Kante. Sie ist Teil einer neuen Welt,
	    // die Zweikantewelt.
	    Zweikante zk = this.verlegenKante(dkl.get(i));
	
	    // Fügen sie zu der Liste ein.
	    zkl.add(zk);
	}

	// Bauen die Zweikantewelt auf.
	Zweikantewelt zkw = new Zweikantewelt(zkl);

	return zkw;
    }
}
