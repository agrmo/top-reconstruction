package sicht.zweipunkt;

import java.awt.Graphics;
import punkt.Zweipunkt;
import sicht.Sicht;

// Eine Punktsicht kann Punkte darstellen.  Die Punkte stehen schon
// auf einer Ebene.
public class Punktsicht extends Sicht {

    // Die Stellen jedes Punktes.
    public Zweipunkt[] pl;

    // Der Durchmesser jedes Punktes.
    public int durchmesser;

    public Punktsicht(Zweipunkt[] pl, int d) {
	this.pl = pl;
	this.durchmesser = d;
    }

    public void darstellenPunkt(Graphics g, Zweipunkt k) {
	g.drawOval((int) k.xteil, (int) k.yteil,
		   this.durchmesser, this.durchmesser);
    }

    // Stelle jeden Punkt dar.
    public void darstellen(Graphics g) {
	for (int i = 0; i < this.pl.length; i++) {
	    this.darstellenPunkt(g, this.pl[i]);
	}
    }
}

