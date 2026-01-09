package sicht.zweipunkt;

import java.awt.Graphics;
import punkt.Zweipunkt;
import sicht.Sicht;

// Eine Punktsicht kann Punkte darstellen.
public class Punktsicht extends Sicht {

    // Wir müssen die Welt in die Sicht einsetzen, weil Java sie
    // irgendwann anrufen wird, die Welt darzustellen. 
    public Zweipunkt[] pl;

    // Der Durchmesser des Punktes.
    public int durchmesser;

    public Punktsicht(Zweipunkt[] pl, int d) {
	this.pl = pl;
	this.durchmesser = d;
    }

    // Die Punkte stehen schon auf einer Ebene. Stellen sie dar.
    public void darstellenPunkt(Graphics g, Zweipunkt k) {
	g.drawOval((int) k.xteil, (int) k.yteil,
		   this.durchmesser, this.durchmesser);
    }

    // Stelle jeden Punkt dieser Welt dar.
    public void darstellen(Graphics g) {
	for (int i = 0; i < this.pl.length; i++) {
	    this.darstellenPunkt(g, this.pl[i]);
	}
    }
}

