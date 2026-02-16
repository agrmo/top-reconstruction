package sicht.punkt;

import java.awt.Graphics;
import vektor.Zweivektor;
import sicht.Sicht;

// Eine Punktsicht kann Vektore darstellen.  Die Punkte stehen schon
// auf einer Ebene. Ein Punkt sieht anders als ein Vektor aus, aber
// die beiden enthalten die gleiche Datenstruktur! Man muss vorsichtig
// sein.
public class Punktsicht extends Sicht {

    // Die Stellen jedes Punkts.
    public Zweivektor[] pl;

    // Der Durchmesser jedes Vektors.
    public int durchmesser;

    public Punktsicht(Zweivektor[] pl, int d) {
	this.pl = pl;
	this.durchmesser = d;
    }

    void darstellenPunkt(Graphics g, Zweivektor k) {
	g.drawOval((int) k.eins, (int) k.zwei,
		   this.durchmesser, this.durchmesser);
    }

    // Stelle jeden Vektor dar.
    public void darstellen(Graphics g) {
	for (int i = 0; i < this.pl.length; i++) {
	    this.darstellenPunkt(g, this.pl[i]);
	}
    }
}

