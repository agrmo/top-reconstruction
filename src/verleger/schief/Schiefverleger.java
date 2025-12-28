package verleger.schief;

import java.util.ArrayList;
import kante.Dreikante;
import kante.Zweikante;
import punkt.Dreipunkt;
import punkt.Zweipunkt;
import vektor.Dreivektor;
import welt.kante.Zweikantewelt;
import welt.punktkoerper.Punktkoerperwelt;

// Ein Schiefverleger nimmt eine dreidimensionale Punktkörperwelt zu
// einer zweidimensionalen Kantenwelt mit Hilfe einer orthographischen
// Verlegung.
public class Schiefverleger {

    // Die dreidimensionale Welt mit den ursprünglichen Daten.
    Punktkoerperwelt punktkoerperwelt;

    // Der Verlegungsvektor.
    public Dreivektor d;

    // Der Verleger braucht die ursprüngliche Daten von der
    // dreidimensionale Welt, und einen Verlegungsvektor, der die
    // Verlegungsrichtung zeigt.
    public Schiefverleger(Punktkoerperwelt pkw, Dreivektor d) {
	this.punktkoerperwelt = pkw;
	this.d = d;
    }

    // ein: Dreipunkt
    // aus: Zweipunkt
    //
    // Verlege den gegeben dreidimensionalen Punkt auf einer
    // Sichtfläche, um einen zweidimensionalen Punkt zu bekommen.
    public Zweipunkt verlegenPunkt(Dreipunkt p) {
	int ausX = p.eins - ((this.d.eins / this.d.drei) * p.drei);
	int ausY = p.zwei - ((this.d.zwei / this.d.drei) * p.drei);

	Zweipunkt aus = new Zweipunkt(ausX, ausY);
	
	return aus;
    }

    // ein: Dreikante
    // aus: Zweikante
    //
    // Verlege die gegebene dreidimensionale Kante auf einer
    // Sichtfläche, um eine zweidimensionale Kante zu bekommen.
    public Zweikante verlegenKante(Dreikante k) {
	Zweipunkt verlegterPunktVon = this.verlegenPunkt(k.von);
	Zweipunkt verlegterPunktBis = this.verlegenPunkt(k.bis);

	// Diese ist die neue Kante, die nur in zwei Dimensionen
	// liegt. 
	Zweikante zk = new Zweikante(verlegterPunktVon, verlegterPunktBis);
	
	return zk;
    }

    // Verlegen die dreidimensionale Punktkörperwelt zu einer
    // zweidimensionale Zweikantewelt.
    public Zweikantewelt verlegenWelt() {

	// Liste von Dreikanten. Nehme die Kanten der
	// dreidimensionalen Welt.
	ArrayList<Dreikante> dkl = this.punktkoerperwelt.nehmeKanten();

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
