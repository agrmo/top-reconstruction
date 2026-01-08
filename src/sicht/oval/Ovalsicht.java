package sicht.oval;

import java.awt.Graphics;
import punkt.Zweipunkt;
import figur.oval.Oval;
import sicht.Sicht;

// Stellen eine Reihe von Ovalen dar.
public class Ovalsicht extends Sicht {

    Oval[] ovalliste;
    Zweipunkt[] ortliste;

    public Ovalsicht(Oval[] kl, Zweipunkt[] ol) {
	this.ovalliste = kl;
	this.ortliste = ol;
    }

    public void darstellen(Graphics g) {

	for (int i = 0; i < this.ovalliste.length; i++) {
	    g.drawOval((int) this.ortliste[i].xteil, (int) this.ortliste[i].yteil,
		       this.ovalliste[i].breite, this.ovalliste[i].hoehe);
	}
    }
}


