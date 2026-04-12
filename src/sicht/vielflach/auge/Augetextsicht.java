package sicht.vielflach.auge;

import druck.vektor.Vektordrucker;
import java.awt.Graphics;
import sicht.Sicht;
import sicht.text.Textsicht;
import sicht.vielflach.auge.Augesicht;
import vektor.Zweivektor;

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
	StringBuilder sba = new StringBuilder();
	sba.append("Betrag: ");
	sba.append(this.as.entfernung.betrag());
	StringBuilder sbb = new StringBuilder();
	sbb.append("Drehung: ");
	sbb.append(this.as.winkeleins);
	sbb.append(", ");
	sbb.append(this.as.winkelzwei);
	sbb.append(", ");
	sbb.append(this.as.winkeldrei);
	
	String[] texte = new String[] {
	    Vektordrucker.drucke(this.as.entfernung),
	    sba.toString(),
	    sbb.toString()
	};

	Zweivektor[] orte = new Zweivektor[] {
	    new Zweivektor(0,12),
	    new Zweivektor(0,12*2),
	    new Zweivektor(0,12*3)
	};

	// Ein bischen schneller. Wir benutzen die gleiche Sicht jedes Mal.
	this.textsicht.textliste = texte;
	this.textsicht.ortliste = orte;
	this.textsicht.darstellen(g);
    }
}


