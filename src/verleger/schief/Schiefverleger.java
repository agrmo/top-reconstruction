package verleger.schief;

import strecke.Dreistrecke;
import strecke.Zweistrecke;
import vektor.Dreivektor;
import vektor.Zweivektor;
import welt.zweistrecke.Zweistreckewelt;
import welt.vielflach.Vielflachwelt;

// Ein Schiefverleger nimmt eine dreidimensionale Vielflachwelt zu
// einer zweidimensionalen Streckenwelt mit Hilfe einer orthographischen
// Verlegung.
public class Schiefverleger {

    // Die Verlegungszahl.
    public double a;

    public Schiefverleger(double a) {
	this.a = a;
    }

    // ein: Dreivektor
    // aus: Zweivektor
    //
    // Verlege den gegeben dreidimensionalen Vektor auf einer
    // Sichtfläche, um einen zweidimensionalen Vektor zu bekommen.
    Zweivektor verlegenVektor(Dreivektor p) {
	double ausX = p.eins + (this.a * p.drei);
	double ausY = p.zwei + (this.a * p.drei);

	Zweivektor aus = new Zweivektor(ausX, ausY);
	
	return aus;
    }

    // ein: Dreistrecke
    // aus: Zweistrecke
    //
    // Verlege die gegebene dreidimensionale Strecke auf einer
    // Sichtfläche, um eine zweidimensionale Strecke zu bekommen.
    Zweistrecke verlegenStrecke(Dreistrecke k) {
	Zweivektor verlegterVektorVon = this.verlegenVektor(k.von);
	Zweivektor verlegterVektorBis = this.verlegenVektor(k.bis);

	// Diese ist die neue Strecke, die nur in zwei Dimensionen
	// liegt. 
	Zweistrecke zk = new Zweistrecke(verlegterVektorVon, verlegterVektorBis);
	
	return zk;
    }

    // ein: Vielflachwelt
    // kw: Die dreidimensionale Welt mit den ursprünglichen Daten.
    //
    // Verlegen die dreidimensionale Vielflachwelt zu einer
    // zweidimensionale Zweistreckewelt.
    //
    public Zweistreckewelt verlegenWelt(Vielflachwelt kw) {

	// Liste von Dreistrecken. Nehme die Strecken der
	// dreidimensionalen Welt.
	Dreistrecke[] dkl = kw.nehmekanten();

	// Liste von Zweistrecken. Mache die Strecken für eine
	// zweidimensionale Zweistreckewelt.
	Zweistrecke[] zsl = new Zweistrecke[dkl.length];
	
	for (int i = 0; i < dkl.length; i++) {
	    // Nehme die neue Strecke. Sie ist Teil einer neuen Welt,
	    // die Zweistreckewelt.
	    Zweistrecke zk = this.verlegenStrecke(dkl[i]);
	
	    // Fügen sie zu der Liste ein.
	    zsl[i] = zk;
	}

	// Bauen die Zweistreckewelt auf.
	Zweistreckewelt zkw = new Zweistreckewelt(zsl);

	return zkw;
    }
}
