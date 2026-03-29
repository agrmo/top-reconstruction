package sicht.vielflach.auge;

import java.awt.Graphics;
import sicht.vielflach.auge.Augesicht;
import sicht.text.Textsicht;
import vektor.Zweivektor;
import sicht.Sicht;
import druck.matrix.Matrixdrucker;

// Eine Sicht, die einen Text der Eigenschaften der
// Augesicht auf dem Bildschirm schreibt.
public class Augetextsicht extends Sicht {

    Augesicht vbs;
    Textsicht textsicht;

    public Augetextsicht(Augesicht vbs) {
	this.vbs = vbs;
	this.textsicht = new Textsicht(new String[] {},
				       new Zweivektor[] {});
    }

    public void darstellen(Graphics g) {
	String[] tl = new String[] {
	    Matrixdrucker.drucken(this.vbs.vorbasis),
	    Matrixdrucker.drucken(this.vbs.basis)
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


