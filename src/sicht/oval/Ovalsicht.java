package sicht.oval;

import java.awt.Graphics;
import welt.oval.Ovalwelt;
import sicht.Sicht;

// Stellen eine Reihe von Ovalen dar.
public class Ovalsicht extends Sicht {
    
    Ovalwelt ow;
    
    public Ovalsicht(Ovalwelt ow) {
	this.ow = ow;
    }
    
    public void darstellen(Graphics g) {
	for (int i = 0; i < this.ow.ovale.length; i++) {
	    g.drawOval((int) this.ow.orte[i].eins, (int) this.ow.orte[i].zwei,
		       this.ow.ovale[i].breite, this.ow.ovale[i].hoehe);
	}
    }
}


