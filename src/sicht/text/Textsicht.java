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

	int zeilehoehe = g.getFontMetrics().getHeight();

	for (int i = 0; i < this.textliste.length; i++) {
	    
	    String[] zeilen = this.textliste[i].split("\n");
	    
	    for (int j = 0; j < zeilen.length; j++) {
		g.drawString(zeilen[j],
			     (int) this.ortliste[i].eins,
			     (int) (this.ortliste[i].zwei + (j * zeilehoehe)));
	    }
	}
    }
}


