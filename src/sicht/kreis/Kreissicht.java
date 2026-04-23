package sicht.kreis;

import java.awt.Graphics;
import sicht.Sicht;
import welt.kreis.Kreiswelt;

// Stellen eine Reihe von Kreisen dar.
public class Kreissicht extends Sicht {

    Kreiswelt kw;

    public Kreissicht(Kreiswelt kw) {
	this.kw = kw;
    }

    public void darstellen(Graphics g) {
	for (int i = 0; i < this.kw.kreise.length; i++) {
	    g.drawOval((int) this.kw.orte[i].eins, (int) this.kw.orte[i].zwei,
		       this.kw.kreise[i].radius, this.kw.kreise[i].radius);
	}
    }
}


