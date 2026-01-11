package sicht.kreis;

import java.awt.Graphics;
import vektor.Zweivektor;
import figur.kreis.Kreis;
import sicht.Sicht;

// Stellen eine Reihe von Kreisen dar.
public class Kreissicht extends Sicht {

    Kreis[] kreisliste;
    Zweivektor[] ortliste;

    public Kreissicht(Kreis[] kl, Zweivektor[] ol) {
	this.kreisliste = kl;
	this.ortliste = ol;
    }

    public void darstellen(Graphics g) {
	for (int i = 0; i < this.kreisliste.length; i++) {
	    g.drawOval((int) this.ortliste[i].eins, (int) this.ortliste[i].zwei,
		       this.kreisliste[i].radius, this.kreisliste[i].radius);
	}
    }
}


