package sicht.text;

import java.awt.Graphics;
import vektor.Zweivektor;
import sicht.Sicht;

// Stellen eine Reihe von Texten dar.
public class Textsicht extends Sicht {

    public String[] textliste;
    public Zweivektor[] ortliste;

    public Textsicht(String[] tl, Zweivektor[] ol) {
	this.textliste = tl;
	this.ortliste = ol;
    }

    public void darstellen(Graphics g) {

	for (int i = 0; i < this.textliste.length; i++) {
	    g.drawString(this.textliste[i],
			 (int) this.ortliste[i].eins,
			 (int) this.ortliste[i].zwei);
	}
    }
}


