package sicht.bogen.zwei;

import java.awt.Graphics;
import vektor.Zweivektor;
import bogen.Bogen;
import sicht.Sicht;
import welt.bogen.Zweibogenwelt;

// Stellen eine Reihe von Bogen dar.
public class Zweibogensicht extends Sicht {

    // Die Welt.
    Zweibogenwelt zbw;
    
    public Zweibogensicht(Zweibogenwelt zbw) {
	this.zbw = zbw;
    }

    public void darstellen(Graphics g) {
	for (int i = 0; i < this.zbw.bogen.length; i++) {
	    g.drawArc((int) this.zbw.orte[i].eins, (int) this.zbw.orte[i].zwei,
		      this.zbw.bogen[i].breite, this.zbw.bogen[i].hoehe,
		      this.zbw.bogen[i].anfangwinkel, this.zbw.bogen[i].unterschiedwinkel);
	}
    }
}


