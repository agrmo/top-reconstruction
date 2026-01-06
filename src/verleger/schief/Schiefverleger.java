package verleger.schief;

import java.util.ArrayList;
import strecke.Dreistrecke;
import strecke.Zweistrecke;
import punkt.Dreipunkt;
import punkt.Zweipunkt;
import welt.zweistrecke.Zweistreckewelt;
import welt.koerper.Koerperwelt;

// Ein Schiefverleger nimmt eine dreidimensionale Körperwelt zu
// einer zweidimensionalen Streckenwelt mit Hilfe einer orthographischen
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
	double ausX = p.xteil + (this.a * p.zteil);
	double ausY = p.yteil + (this.a * p.zteil);

	Zweipunkt aus = new Zweipunkt(ausX, ausY);
	
	return aus;
    }

    // ein: Dreistrecke
    // aus: Zweistrecke
    //
    // Verlege die gegebene dreidimensionale Strecke auf einer
    // Sichtfläche, um eine zweidimensionale Strecke zu bekommen.
    Zweistrecke verlegenStrecke(Dreistrecke k) {
	Zweipunkt verlegterPunktVon = this.verlegenPunkt(k.von);
	Zweipunkt verlegterPunktBis = this.verlegenPunkt(k.bis);

	// Diese ist die neue Strecke, die nur in zwei Dimensionen
	// liegt. 
	Zweistrecke zk = new Zweistrecke(verlegterPunktVon, verlegterPunktBis);
	
	return zk;
    }

    // ein: Körperwelt
    // kw: Die dreidimensionale Welt mit den ursprünglichen Daten.
    //
    // Verlegen die dreidimensionale Körperwelt zu einer
    // zweidimensionale Zweistreckewelt.
    //
    public Zweistreckewelt verlegenWelt(Koerperwelt kw) {

	// Liste von Dreistrecken. Nehme die Strecken der
	// dreidimensionalen Welt.
	ArrayList<Dreistrecke> dkl = kw.nehmeStrecken();

	// Liste von Zweistrecken. Mache die Strecken für eine
	// zweidimensionale Zweistreckewelt.
	ArrayList<Zweistrecke> zsl = new ArrayList<Zweistrecke>();
	
	for (int i = 0; i < dkl.size(); i++) {
	    // Nehme die neue Strecke. Sie ist Teil einer neuen Welt,
	    // die Zweistreckewelt.
	    Zweistrecke zk = this.verlegenStrecke(dkl.get(i));
	
	    // Fügen sie zu der Liste ein.
	    zsl.add(zk);
	}

	// Bauen die Zweistreckewelt auf.
	Zweistreckewelt zkw = new Zweistreckewelt(zsl);

	return zkw;
    }
}
