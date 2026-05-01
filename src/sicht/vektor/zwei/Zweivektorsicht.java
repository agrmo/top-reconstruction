package sicht.vektor.zwei;

import dreher.zweivektor.Zweivektordreher;
import java.awt.Graphics;
import sicht.Sicht;
import vektor.Zweivektor;
import vektor.fort.Zweifortvektor;
import verdoppler.vektor.Vektorverdoppler;
import welt.vektor.Zweivektorwelt;

// Stellen eine Reihe von Vektoren dar.
public class Zweivektorsicht extends Sicht {
    
    Zweivektorwelt zvw;

    // Die Größe der Spitze des Vektors. 
    int spitze = 20;
    
    public Zweivektorsicht(Zweivektorwelt zvw) {
	this.zvw = zvw;
    }
    
    public void darstellen(Graphics g) {
	for (int i = 0; i < this.zvw.orte.length; i++) {

	    // Stelle die Spitze des Vektors dar.
	    // Die Spitze hat zwei Teile: ein nach "links" und ein nach "rechts."
	    // d.i.
	    //          \  <-- Größe der Spitze
	    // ----------
	    //          /  <-- Größe der Spitze

	    // Baue die zwei Spitzen.

	    Zweivektor a = Zweifortvektor.mache(this.zvw.vektoren[i], this.spitze);
	    Zweivektor b = Zweivektordreher.drehen(a, 135.0 * (Math.PI / 180.0));
	    Zweivektor c = Zweifortvektor.mache(this.zvw.vektoren[i], this.spitze);
	    Zweivektor d = Zweivektordreher.drehen(c, -135.0 * (Math.PI / 180.0));

	    // Es gibt bis jetzt 3 Vektoren: der Schwanz und die zwei
	    // Spitzen.  Der Schwanz ist this.zvw.vektoren[i] und die
	    // zwei Spitzen sind b, d.

	    // Die zeigen sich in die richtige Richtungen aber stehen
	    // nicht an den richtigen Orten. D.i.

	    /*
	       
             \  
	      -----
	     /

	    */
	    
	    // Nun verschiebe alle drei Vektoren zum richtigen Ort.

	    Zweivektor schwanzvon = this.zvw.orte[i];
	    Zweivektor schwanzbis = Vektorverdoppler.verdoppeln(this.zvw.orte[i]);
	    schwanzbis.addiere(this.zvw.vektoren[i]);

	    // Zweivektor spitzeeinsvon = schwanzbis;
	    Zweivektor spitzeeinsbis = Vektorverdoppler.verdoppeln(schwanzbis);
	    spitzeeinsbis.addiere(b);

	    // Zweivektor spitzezweivon = schwanzbis;
	    Zweivektor spitzezweibis = Vektorverdoppler.verdoppeln(schwanzbis);
	    spitzezweibis.addiere(d);

	    // Stelle den Schwanz dar.
	    g.drawLine((int) schwanzvon.eins, (int) schwanzvon.zwei,
		       (int) schwanzbis.eins, (int) schwanzbis.zwei);

	    // Stelle die erste Spitze des Vektors dar.
	    g.drawLine((int) schwanzbis.eins, (int) schwanzbis.zwei,
		       (int) spitzeeinsbis.eins, (int) spitzeeinsbis.zwei);
	    
	    // Stelle die zweite Spitze des Vektors dar.
	    g.drawLine((int) schwanzbis.eins, (int) schwanzbis.zwei,
		       (int) spitzezweibis.eins, (int) spitzezweibis.zwei);
	}
    }
}


