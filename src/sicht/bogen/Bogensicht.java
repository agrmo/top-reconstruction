package sicht.bogen;

import java.awt.Graphics;
import vektor.Zweivektor;
import bogen.Bogen;
import sicht.Sicht;

// Stellen eine Reihe von Bogen dar.
public class Bogensicht extends Sicht {

    Bogen[] bogenliste;
    Zweivektor[] ortliste;

    public Bogensicht(Bogen[] bl, Zweivektor[] ol) {
	this.bogenliste = bl;
	this.ortliste = ol;
    }

    public void darstellen(Graphics g) {
	for (int i = 0; i < this.bogenliste.length; i++) {
	    g.drawArc((int) this.ortliste[i].eins, (int) this.ortliste[i].zwei,
		      this.bogenliste[i].breite, this.bogenliste[i].hoehe,
		      this.bogenliste[i].anfangwinkel, this.bogenliste[i].unterschiedwinkel);
	}
    }
}


