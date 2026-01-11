package sicht.text.giernick;

import java.awt.Graphics;
import sicht.vielflach.giernick.Giernicksicht;
import sicht.text.Textsicht;
import vektor.Zweivektor;
import sicht.Sicht;

// Stellen die Eigenschaften der Giernicksicht dar.
public class Giernicktextsicht extends Sicht {

    Giernicksicht augesicht;
    Textsicht textsicht;

    public Giernicktextsicht(Giernicksicht as) {
	this.augesicht = as;
	this.textsicht = new Textsicht(new String[] {},
				       new Zweivektor[] {});
    }

    public void darstellen(Graphics g) {
	String[] tl = new String[] {
	    Double.toString(this.augesicht.nick),
	    Double.toString(this.augesicht.gier)
	};

	Zweivektor[] tol = new Zweivektor[] {
	    new Zweivektor(0,12),
	    new Zweivektor(0,24),
	};

	// Ein bischen schneller. Wir benutzen die gleiche Sicht jedes Mal.
	this.textsicht.textliste = tl;
	this.textsicht.ortliste = tol;
	this.textsicht.darstellen(g);
    }
}


