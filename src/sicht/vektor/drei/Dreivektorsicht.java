package sicht.vektor.drei;

import dreher.euler.Eulerdreher;
import dreher.euler.Eulerdreher;
import java.awt.Graphics;
import matrix.Dreimatrix;
import sicht.Sicht;
import sicht.strecke.drei.Dreistreckesicht;
import strecke.Dreistrecke;
import vektor.Dreivektor;
import vektor.fort.drei.Dreifortvektor;
import verdoppler.vektor.Vektorverdoppler;
import welt.strecke.drei.Dreistreckewelt;
import welt.vektor.Dreivektorwelt;

// Stellen eine Reihe von Vektoren dar. Ein Vektor wird wie ein Pfeil
// dargestellt.
public class Dreivektorsicht extends Sicht {
    
    Dreivektorwelt dreivektorwelt;
    Dreivektor entfernung;
    double brennweite;
    double breite;
    double hoehe;
    double winkeleins;
    double winkelzwei;
    double winkeldrei;

    // Die Größe der Spitze des Vektors. 
    int spitze = 10;
    
    public Dreivektorsicht(Dreivektorwelt dreivektorwelt,
			   Dreivektor entfernung, double brennweite,
			   double breite, double hoehe,
			   double winkeleins,
			   double winkelzwei,
			   double winkeldrei) {
	this.dreivektorwelt = dreivektorwelt;
	this.entfernung = entfernung;
	this.brennweite = brennweite;
	this.breite = breite;
	this.hoehe = hoehe;
	this.winkeleins = winkeleins;
	this.winkelzwei = winkelzwei;
	this.winkeldrei = winkeldrei;
    }
    
    public void darstellen(Graphics g) {

	// Stelle jeden Vektor dieser Welt dar.  Jeder Vektor ergibt 3
	// neue: die Spitzen des Vektors.  Also 4 insgesamt.  Also
	// multipliziere 4 mit der Anzahl der Vektoren.  Die ist die
	// Anzahl der Strecken der Dreistreckewelt.  Lass wir eine
	// Streckewelt bauen. Jeder Vektor ergibt 4 Strecken.

	// Baue alle Strecken dieser Dreivektorwelt.
	
	int streckeanzahl = 4 * this.dreivektorwelt.vektoren.length;
	Dreistrecke[] dsl = new Dreistrecke[streckeanzahl];
	
	for (int i = 0; i < this.dreivektorwelt.vektoren.length; i++) {

	    // Stelle die Spitze des Vektors dar.  Die Spitze hat drei
	    // Teile. Jede Spitze geht ein bißchen in der
	    // Gegenrichtung (135 Grad) und sind gleichmäßig
	    // voneinander entfernt (120 Grad).
	    
	    // d.i.
	    //          \  <-- Größe der Spitze, 135 Grad "zurück"
	    // ----------
	    //          /  <-- Größe der Spitze, 135 Grad "zurück"
	    //
	    // und von Spitzenaussicht
	    //
	    //             |
	    //             |
	    //  120 Grad   .   120 Grad           
	    //            / \
	    //           /   \
	    //
	    //          120 Grad
	    //
	    // wobei jede Strecke ist 120 Grad voneinander entfernt.
	    // Und 120+120+120 = 360.

	    // Baue die drei Spitzen.
	    
	    Dreivektor a = Dreifortvektor.mache(this.dreivektorwelt.vektoren[i], this.spitze);
	    Dreivektor b = Dreifortvektor.mache(this.dreivektorwelt.vektoren[i], this.spitze);
	    Dreivektor c = Dreifortvektor.mache(this.dreivektorwelt.vektoren[i], this.spitze);

	    Dreimatrix adrehung = Eulerdreher.nehmedrehung(0,
							   -135 * (Math.PI / 180.0),
							   0);

	    Dreimatrix bdrehung = Eulerdreher.nehmedrehung(0,
							   -135 * (Math.PI / 180.0),
							   -120 * (Math.PI / 180.0));

	    Dreimatrix cdrehung = Eulerdreher.nehmedrehung(0,
							   -135 * (Math.PI / 180.0),
							   120 * (Math.PI / 180.0));

	    
	    Dreivektor d = adrehung.punkt(a);
	    Dreivektor e = bdrehung.punkt(b);
	    Dreivektor f = cdrehung.punkt(c);

	    // Es gibt bis jetzt 4 Vektoren: der Schwanz und die zwei
	    // Spitzen.  Der Schwanz ist
	    // this.dreivektorwelt.vektoren[i] und die zwei Spitzen
	    // sind d, e und f. Die zeigen sich in die richtige
	    // Richtungen aber stehen nicht an den richtigen
	    // Orten. D.i.

	    /*
	       
             \  
	      -----
	     /

	    */
	    
	    // Nun verschiebe alle vier Vektoren zum richtigen Ort.

	    Dreivektor schwanzvon = this.dreivektorwelt.orte[i];
	    Dreivektor schwanzbis = Vektorverdoppler.verdoppeln(this.dreivektorwelt.orte[i]);
	    schwanzbis.addiere(this.dreivektorwelt.vektoren[i]);

	    Dreivektor spitzeeinsvon = Vektorverdoppler.verdoppeln(schwanzbis);
	    Dreivektor spitzeeinsbis = Vektorverdoppler.verdoppeln(schwanzbis);
	    spitzeeinsbis.addiere(d);

	    Dreivektor spitzezweivon = Vektorverdoppler.verdoppeln(schwanzbis);
	    Dreivektor spitzezweibis = Vektorverdoppler.verdoppeln(schwanzbis);
	    spitzezweibis.addiere(e);

	    Dreivektor spitzedreivon = Vektorverdoppler.verdoppeln(schwanzbis);
	    Dreivektor spitzedreibis = Vektorverdoppler.verdoppeln(schwanzbis);
	    spitzedreibis.addiere(f);

	    dsl[i * 4] = new Dreistrecke(schwanzvon, schwanzbis);
	    dsl[(i * 4) + 1] = new Dreistrecke(spitzeeinsvon, spitzeeinsbis);
	    dsl[(i * 4) + 2] = new Dreistrecke(spitzezweivon, spitzezweibis);
	    dsl[(i * 4) + 3] = new Dreistrecke(spitzedreivon, spitzedreibis);
	}

	// Nun stelle alle Strecken dar. Wir benutzen eine
	// Dreistreckewelt und eine Dreistreckesicht.

	Dreistreckewelt dsw = new Dreistreckewelt(dsl);

	Dreistreckesicht dss = new Dreistreckesicht(dsw,
						    this.entfernung,
						    this.brennweite,
						    this.breite, this.hoehe,
						    this.winkeleins,
						    this.winkelzwei,
						    this.winkeldrei);

	dss.darstellen(g);
    }
}


