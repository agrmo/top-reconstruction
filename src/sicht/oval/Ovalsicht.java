package sicht.oval;

import java.awt.Graphics;
import vektor.Zweivektor;
import figur.oval.Oval;
import sicht.Sicht;

// Stellen eine Reihe von Ovalen dar.
public class Ovalsicht extends Sicht {

    Oval[] ovalliste;
    Zweivektor[] ortliste;

    public Ovalsicht(Oval[] kl, Zweivektor[] ol) {
	this.ovalliste = kl;
	this.ortliste = ol;
    }

    public void darstellen(Graphics g) {

	for (int i = 0; i < this.ovalliste.length; i++) {
	    g.drawOval((int) this.ortliste[i].eins, (int) this.ortliste[i].zwei,
		       this.ovalliste[i].breite, this.ovalliste[i].hoehe);
	}
    }
}


