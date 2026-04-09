package verleger.schief;

import strecke.Dreistrecke;
import strecke.Zweistrecke;
import vektor.Dreivektor;
import vektor.Zweivektor;
import welt.strecke.Zweistreckewelt;
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
    Zweivektor verlegevektor(Dreivektor v) {
	double ausX = v.eins + (this.a * v.drei);
	double ausY = v.zwei + (this.a * v.drei);

	Zweivektor aus = new Zweivektor(ausX, ausY);
	
	return aus;
    }

    // ein: Dreistrecke
    // aus: Zweistrecke
    //
    // Verlege die gegebene dreidimensionale Strecke auf einer
    // Sichtfläche, um eine zweidimensionale Strecke zu bekommen.
    Zweistrecke verlegestrecke(Dreistrecke ds) {
	Zweivektor verlegterVektorVon = this.verlegevektor(ds.von);
	Zweivektor verlegterVektorBis = this.verlegevektor(ds.bis);

	// Diese ist die neue Strecke, die nur in zwei Dimensionen
	// liegt. 
	Zweistrecke zs = new Zweistrecke(verlegterVektorVon, verlegterVektorBis);
	
	return zs;
    }

    // ein: 
    // Vielflachwelt: Die dreidimensionale Welt mit den ursprünglichen Daten.
    //
    // Verlegen die dreidimensionale Vielflachwelt zu einer
    // zweidimensionale Zweistreckewelt.
    //
    public Zweistreckewelt verlegewelt(Vielflachwelt vw) {

	// Liste von Dreistrecken. Nehme die Strecken der
	// dreidimensionalen Welt.
	Dreistrecke[] dsl = vw.nehmekanten();

	// Liste von Zweistrecken. Mache die Strecken für eine
	// zweidimensionale Zweistreckewelt.
	Zweistrecke[] zsl = new Zweistrecke[dsl.length];
	
	for (int i = 0; i < dsl.length; i++) {
	    // Nehme die neue Strecke. Sie ist Teil einer neuen Welt,
	    // die Zweistreckewelt.
	    Zweistrecke zs = this.verlegestrecke(dsl[i]);
	
	    // Fügen sie zu der Liste ein.
	    zsl[i] = zs;
	}

	// Bauen die Zweistreckewelt auf.
	Zweistreckewelt zsw = new Zweistreckewelt(zsl);

	return zsw;
    }
}
