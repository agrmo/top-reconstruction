package sicht.zweipunkt;

import java.awt.Graphics;
import punkt.Zweipunkt;
import sicht.Sicht;

// Eine Punktsicht kann Punkte darstellen.
public class Punktsicht extends Sicht {

    // Wir müssen die Welt in die Sicht einsetzen, weil Java sie
    // irgendwann anrufen wird, die Welt darzustellen. 
    public Zweipunkt[] pl;

    // Die Größe des Kreises;
    public int radius;

    public Punktsicht(Zweipunkt[] pl, int r) {
	this.pl = pl;
	this.radius = r;
    }

    // Die Punkte stehen schon auf einer Ebene. Stellen sie dar.
    public void darstellenPunkt(Graphics g, Zweipunkt k) {
	g.drawOval((int) k.xteil, (int) k.yteil,
		   this.radius, this.radius);
    }

    public void darstellen(Graphics g) {
	// Stelle jede Punkt dieser Welt dar.
	for (int i = 0; i < this.pl.length; i++) {
	    this.darstellenPunkt(g, this.pl[i]);
	}
    }
}

