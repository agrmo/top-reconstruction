package sicht.augetext;

import auge.Auge;
import druck.vektor.Vektordrucker;
import java.awt.Graphics;
import sicht.Sicht;
import sicht.text.Textsicht;
import vektor.Zweivektor;

// Eine Sicht, die einen Text der Eigenschaften der
// Augen auf dem Bildschirm schreibt.
public class Augetextsicht extends Sicht {

    Auge auge;
    Textsicht textsicht;

    public Augetextsicht(Auge auge) {
	this.auge = auge;
	this.textsicht = new Textsicht(new String[] {},
				       new Zweivektor[] {});
    }

    public void darstellen(Graphics g) {
	StringBuilder sba = new StringBuilder();
	sba.append("Betrag: ");
	sba.append(this.auge.entfernung.betrag());
	StringBuilder sbb = new StringBuilder();
	sbb.append("Drehung: ");
	sbb.append(this.auge.winkeleins);
	sbb.append(", ");
	sbb.append(this.auge.winkelzwei);
	sbb.append(", ");
	sbb.append(this.auge.winkeldrei);
	
	String[] texte = new String[] {
	    Vektordrucker.drucke(this.auge.entfernung),
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
