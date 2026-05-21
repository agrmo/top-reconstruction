package sicht.kreis.zwei;

import java.awt.Graphics;
import sicht.Sicht;
import welt.kreis.zwei.Zweikreiswelt;

// Stellen eine Reihe von Kreisen in einer zweidimensionalen Welt dar.
public class Zweikreissicht extends Sicht {

    Zweikreiswelt kw;

    public Zweikreissicht(Zweikreiswelt kw) {
	this.kw = kw;
    }

    public void darstellen(Graphics g) {
	for (int i = 0; i < this.kw.kreise.length; i++) {
	    g.drawOval((int) this.kw.orte[i].eins, (int) this.kw.orte[i].zwei,
		       this.kw.kreise[i].radius, this.kw.kreise[i].radius);
	}
    }
}


