package sicht.vielflach.auge;

import java.awt.Graphics;
import sicht.vielflach.auge.Augesicht;
import sicht.text.Textsicht;
import vektor.Zweivektor;
import sicht.Sicht;
import druck.vektor.Vektordrucker;

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
	StringBuilder sb = new StringBuilder();
	sb.append("Betrag: ");
	sb.append(this.as.augevektor.betrag());
	
	String[] texte = new String[] {
	    Vektordrucker.drucken(this.as.augevektor),
	    sb.toString()
	};

	Zweivektor[] orte = new Zweivektor[] {
	    new Zweivektor(0,12),
	    new Zweivektor(0,12*2)
	};

	// Ein bischen schneller. Wir benutzen die gleiche Sicht jedes Mal.
	this.textsicht.textliste = texte;
	this.textsicht.ortliste = orte;
	this.textsicht.darstellen(g);
    }
}


