package sicht.text.augetext;

import java.awt.Graphics;
import sicht.vielflach.giernick.Giernicksicht;
import sicht.text.Textsicht;
import punkt.Zweipunkt;
import sicht.Sicht;

// Stellen die Eigenschaften der Giernicksicht dar.
public class Augetextsicht extends Sicht {

    Giernicksicht augesicht;
    Textsicht textsicht;

    public Augetextsicht(Giernicksicht as) {
	this.augesicht = as;
	this.textsicht = new Textsicht(new String[] {},
				       new Zweipunkt[] {});
    }

    public void darstellen(Graphics g) {
	String[] tl = new String[] {
	    Double.toString(this.augesicht.nick),
	    Double.toString(this.augesicht.gier)
	};

	Zweipunkt[] tol = new Zweipunkt[] {
	    new Zweipunkt(0,12),
	    new Zweipunkt(0,24),
	};

	// Ein bischen schneller. Wir benutzen die gleiche Sicht jedes Mal.
	this.textsicht.textliste = tl;
	this.textsicht.ortliste = tol;
	this.textsicht.darstellen(g);
    }
}


