package sicht.graph.zwei;

import java.awt.Graphics;
import vektor.Zweivektor;
import welt.graph.Zweigraphwelt;
import sicht.Sicht;
import welt.strecke.Zweistreckewelt;
import strecke.Zweistrecke;
import sicht.punkt.Punktsicht;
import sicht.strecke.Streckesicht;

// Eine Sicht der zweidimensionalen Graphwelt.
public class Zweigraphsicht extends Sicht {

    Zweigraphwelt zgw;

    public Zweigraphsicht(Zweigraphwelt zgw) {
	this.zgw = zgw;
    }

    public void darstellen(Graphics g) {

	// Ein Graph dargestellt ist nur Kreisen und Strecken.

	// Nehme die wesentliche Daten.
	Zweistrecke[] kanten = this.zgw.nehmekanten();
	Zweistreckewelt zsw = new Zweistreckewelt(kanten);
	int durchmesser = 10;
	Zweivektor[] knoten = zgw.nehmeKnoten(durchmesser);

	// Mache die untereinanderliegende Sichten.
	Streckesicht ss = new Streckesicht(zsw);
	Punktsicht ps = new Punktsicht(knoten, durchmesser);

	ss.darstellen(g);
	ps.darstellen(g);
    }
}

