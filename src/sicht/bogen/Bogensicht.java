package sicht.bogen;

import java.awt.Graphics;
import punkt.Zweipunkt;
import bogen.Bogen;
import sicht.Sicht;

// Stellen eine Reihe von Bogen dar.
public class Bogensicht extends Sicht {

    Bogen[] bogenliste;
    Zweipunkt[] ortliste;

    public Bogensicht(Bogen[] bl, Zweipunkt[] ol) {
	this.bogenliste = bl;
	this.ortliste = ol;
    }

    public void darstellen(Graphics g) {
	for (int i = 0; i < this.bogenliste.length; i++) {
	    g.drawArc((int) this.ortliste[i].xteil, (int) this.ortliste[i].yteil,
		      this.bogenliste[i].breite, this.bogenliste[i].hoehe,
		      this.bogenliste[i].anfangwinkel, this.bogenliste[i].unterschiedwinkel);
	}
    }
}


