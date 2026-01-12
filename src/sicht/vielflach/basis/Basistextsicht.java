package sicht.vielflach.basis;

import java.awt.Graphics;
import sicht.vielflach.basis.Basissicht;
import sicht.text.Textsicht;
import vektor.Zweivektor;
import sicht.Sicht;
import druck.matrix.Matrixdrucker;

// Stellen die Eigenschaften der Giernicksicht dar.
public class Basistextsicht extends Sicht {

    Basissicht gs;
    Textsicht textsicht;

    public Basistextsicht(Basissicht gs) {
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


