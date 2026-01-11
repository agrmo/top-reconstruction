package sicht.vektor;

import java.awt.Graphics;
import vektor.Zweivektor;
import sicht.Sicht;

// Eine Vektorsicht kann Vektore darstellen.  Die Vektore stehen schon
// auf einer Ebene.
public class Vektorsicht extends Sicht {

    // Die Stellen jedes Vektores.
    public Zweivektor[] pl;

    // Der Durchmesser jedes Vektores.
    public int durchmesser;

    public Vektorsicht(Zweivektor[] pl, int d) {
	this.pl = pl;
	this.durchmesser = d;
    }

    public void darstellenVektor(Graphics g, Zweivektor k) {
	g.drawOval((int) k.eins, (int) k.zwei,
		   this.durchmesser, this.durchmesser);
    }

    // Stelle jeden Vektor dar.
    public void darstellen(Graphics g) {
	for (int i = 0; i < this.pl.length; i++) {
	    this.darstellenVektor(g, this.pl[i]);
	}
    }
}

