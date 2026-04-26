package sicht.vielflach;

import druck.vektor.Vektordrucker;
import java.awt.Graphics;
import sicht.Sicht;
import sicht.text.Textsicht;
import sicht.vielflach.Vielflachsicht;
import vektor.Zweivektor;

// Eine Sicht, die einen Text der Eigenschaften der
// Vielflachsicht auf dem Bildschirm schreibt.
public class Vielflachtextsicht extends Sicht {

    Vielflachsicht vs;
    Textsicht textsicht;

    public Vielflachtextsicht(Vielflachsicht vs) {
	this.vs = vs;
	this.textsicht = new Textsicht(new String[] {},
				       new Zweivektor[] {});
    }

    public void darstellen(Graphics g) {
	StringBuilder sba = new StringBuilder();
	sba.append("Betrag: ");
	sba.append(this.vs.entfernung.betrag());
	StringBuilder sbb = new StringBuilder();
	sbb.append("Drehung: ");
	sbb.append(this.vs.winkeleins);
	sbb.append(", ");
	sbb.append(this.vs.winkelzwei);
	sbb.append(", ");
	sbb.append(this.vs.winkeldrei);
	
	String[] texte = new String[] {
	    Vektordrucker.drucke(this.vs.entfernung),
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


