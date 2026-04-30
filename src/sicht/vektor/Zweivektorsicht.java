package sicht.vektor;

import java.awt.Graphics;
import welt.vektor.Zweivektorwelt;
import sicht.Sicht;
import verdoppler.vektor.Vektorverdoppler;
import vektor.Zweivektor;

// Stellen eine Reihe von Vektoren dar.
public class Zweivektorsicht extends Sicht {
    
    Zweivektorwelt zvw;

    // Die Größe der Spitze des Vektors. 
    int spitze = 5;
    
    public Zweivektorsicht(Zweivektorwelt zvw) {
	this.zvw = zvw;
    }
    
    public void darstellen(Graphics g) {
	for (int i = 0; i < this.zvw.orte.length; i++) {

	    // Stelle den Schwanz des Vektors dar.
	    Zweivektor von = this.zvw.orte[i];
	    Zweivektor bis = Vektorverdoppler.verdoppeln(this.zvw.orte[i]);
	    bis.addiere(this.zvw.vektoren[i]);
	    
	    g.drawLine((int) von.eins, (int) von.zwei,
		       (int) bis.eins, (int) bis.zwei);

	    // Stelle die Spitze des Vektors dar.
	    // Die Spitze hat zwei Teile: ein nach "links" und ein nach "rechts."
	    // d.i.
	    //          \
	    // ----------
	    //          /

	    // Zweivektor spitzeeinsbis = Vektorverdoppler.verdoppeln(bis);
	    // spitzeeinsbis.addiere()
	}
    }
}


