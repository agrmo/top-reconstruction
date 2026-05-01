package sicht.feld.eins.skala;

import java.awt.Graphics;
import sicht.Sicht;
import feld.eins.skala.Einskalafeld;
import welt.vektor.Zweivektorwelt;
import sicht.vektor.zwei.Zweivektorsicht;
import vektor.Zweivektor;

// Eindimensionales Skalafeld.
// Die Stellen sind eine Reihe von Zahlen.
// Die Werte sind eine Reihe von Zahlen.
//
// Um dieses Feld darzustellen, bauen wir eine Zweivektorwelt, wobei
// jeder Vektor senkrecht in the +y Richtung zeigt. Leider zeigt +y
// für Java nach unten. Es ist mir egal...
public class Einskalafeldsicht extends Sicht {

    public Einskalafeld esf;
    public double breite;

    public Einskalafeldsicht(Einskalafeld esf, double breite) {
	this.esf = esf;
	this.breite = breite;
    }

    public void darstellen(Graphics g) {

	Zweivektor[] orte = new Zweivektor[this.esf.orte.length];
	Zweivektor[] vektoren = new Zweivektor[this.esf.orte.length];
	
	for (int i = 0; i < this.esf.orte.length; i++) {
	    orte[i] = new Zweivektor(i * this.breite, 100);
	    vektoren[i] = new Zweivektor(0, this.esf.werte[i]);
	}

	Zweivektorwelt zvw = new Zweivektorwelt(orte, vektoren);
	Zweivektorsicht zvs = new Zweivektorsicht(zvw);
	zvs.darstellen(g);
    }
}
