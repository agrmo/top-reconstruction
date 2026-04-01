package sicht.vielflach.auge;

import java.awt.Graphics;
import sicht.vielflach.auge.Augesicht;
import sicht.text.Textsicht;
import vektor.Zweivektor;
import sicht.Sicht;
import druck.vektor.Vektordrucker;
import druck.matrix.Matrixdrucker;
import matrix.Dreimatrix;
import matrix.rollnickgier.Rollnickgiermatrix;

// Eine Sicht, die einen Text der Eigenschaften der
// Augesicht auf dem Bildschirm schreibt.
public class Augetextsicht extends Sicht {

    Augesicht as;
    Textsicht textsicht;

    public Augetextsicht(Augesicht as) {
	this.as = as;
	this.textsicht = new Textsicht(new String[] {},
				       new Zweivektor[] {});
    }

    public void darstellen(Graphics g) {
	Dreimatrix basismatrix = Rollnickgiermatrix.nehmebasisdrehungmatrix(this.as.augevektor);
	
	String[] tl = new String[] {
	    Vektordrucker.drucken(this.as.augevektor),
	    Matrixdrucker.drucken(basismatrix)
	};

	Zweivektor[] tol = new Zweivektor[] {
	    new Zweivektor(0,12),
	    new Zweivektor(0,12*6)
	};

	// Ein bischen schneller. Wir benutzen die gleiche Sicht jedes Mal.
	this.textsicht.textliste = tl;
	this.textsicht.ortliste = tol;
	this.textsicht.darstellen(g);
    }
}


