package sicht.text;

import java.awt.Graphics;
import punkt.Zweipunkt;
import sicht.Sicht;

// Stellen eine Reihe von Texten dar.
public class Textsicht extends Sicht {

    public String[] textliste;
    public Zweipunkt[] ortliste;

    public Textsicht(String[] tl, Zweipunkt[] ol) {
	this.textliste = tl;
	this.ortliste = ol;
    }

    public void darstellen(Graphics g) {

	for (int i = 0; i < this.textliste.length; i++) {
	    g.drawString(this.textliste[i],
			 (int) this.ortliste[i].xteil,
			 (int) this.ortliste[i].yteil);
	}
    }
}


