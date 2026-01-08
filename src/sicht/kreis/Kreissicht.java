package sicht.kreis;

import java.awt.Graphics;
import punkt.Zweipunkt;
import figur.kreis.Kreis;
import sicht.Sicht;

// Stellen eine Reihe von Kreisen dar.
public class Kreissicht extends Sicht {

    Kreis[] kreisliste;
    Zweipunkt[] ortliste;

    public Kreissicht(Kreis[] kl, Zweipunkt[] ol) {
	this.kreisliste = kl;
	this.ortliste = ol;
    }

    public void darstellen(Graphics g) {
	for (int i = 0; i < this.kreisliste.length; i++) {
	    g.drawOval((int) this.ortliste[i].xteil, (int) this.ortliste[i].yteil,
		       this.kreisliste[i].radius, this.kreisliste[i].radius);
	}
    }
}


