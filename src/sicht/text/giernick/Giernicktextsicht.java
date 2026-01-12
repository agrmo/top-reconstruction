package sicht.text.giernick;

import java.awt.Graphics;
import sicht.vielflach.giernick.Giernicksicht;
import sicht.text.Textsicht;
import vektor.Zweivektor;
import sicht.Sicht;
import druck.matrix.Matrixdrucker;

// Stellen die Eigenschaften der Giernicksicht dar.
public class Giernicktextsicht extends Sicht {

    Giernicksicht gs;
    Textsicht textsicht;

    public Giernicktextsicht(Giernicksicht gs) {
	this.gs = gs;
	this.textsicht = new Textsicht(new String[] {},
				       new Zweivektor[] {});
    }

    public void darstellen(Graphics g) {
	String[] tl = new String[] {
	    Matrixdrucker.drucken(this.gs.vorbasis),
	    Matrixdrucker.drucken(this.gs.basis)
	};

	Zweivektor[] tol = new Zweivektor[] {
	    new Zweivektor(0,12),
	    new Zweivektor(0,12*6),
	};

	// Ein bischen schneller. Wir benutzen die gleiche Sicht jedes Mal.
	this.textsicht.textliste = tl;
	this.textsicht.ortliste = tol;
	this.textsicht.darstellen(g);
    }
}


