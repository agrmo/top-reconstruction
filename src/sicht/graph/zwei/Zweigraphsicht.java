package sicht.graph.zwei;

import java.awt.Graphics;
import vektor.Zweivektor;
import welt.graph.Zweigraphwelt;
import sicht.Sicht;
import welt.strecke.Zweistreckewelt;
import welt.punkt.Zweipunktwelt;
import strecke.Zweistrecke;
import sicht.punkt.Zweipunktsicht;
import sicht.strecke.Streckesicht;

// Eine Sicht der zweidimensionalen Graphwelt.
public class Zweigraphsicht extends Sicht {

    Zweigraphwelt zgw;
    double durchmesser;

    public Zweigraphsicht(Zweigraphwelt zgw,
			  double d) {
	this.zgw = zgw;
	this.durchmesser = d;
    }

    /*
      Das Zentrum von drawCircle() von Java ist nicht genau auf dem
      gegebenen Ort dargestellt. Zum Beispiel
      
      Knoten (0,0) Durchmesser 3
      Kante (0,0) bis (10,10)
      
      Gewünscht:
      
      |---|
      | \ |
      |--\|
          \
           \
            ...

      Aber Java wird die beiden wieso darstellen,

      \
      |---|
      |\  |
      |-\-|
         \
          \
           ...
	     
      weil das Zentrum des Kreises nicht auf (0,0) steht. Wir sollen
      die Stellen des Knoten verbessern. In diesem Beispiel
      verschieben wir die Stellen des Kreises -3 in die x- und
      y-Richtung.

      Warum 4?
    */
    void verbessereknoten(Zweivektor zp) {
	Zweivektor unterschied = new Zweivektor((this.durchmesser / 4.0),
						(this.durchmesser / 4.0));
	zp.subtrahiere(unterschied);
    }

    public void darstellen(Graphics g) {
	// Ein Graph dargestellt ist nur Kreisen und Strecken.

	// Nehme die Kanten.
	Zweistrecke[] kanten = this.zgw.nehmekanten();

	// Nehme die Knoten.
	Zweistreckewelt zsw = new Zweistreckewelt(kanten);
	Zweivektor[] knoten = zgw.nehmeknoten();

	for (int i = 0; i < knoten.length; i++) {
	    this.verbessereknoten(knoten[i]);
	}

	// Mache die untereinanderliegende Sichten.
	Streckesicht ss = new Streckesicht(zsw);

	Zweipunktwelt pw = new Zweipunktwelt(knoten);
	Zweipunktsicht ps = new Zweipunktsicht(pw, this.durchmesser);

	ss.darstellen(g);
	ps.darstellen(g);
	ps.darstellen(g);
	ps.darstellen(g);
	ps.darstellen(g);
    }
}
