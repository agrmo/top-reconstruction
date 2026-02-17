package sicht.graph;

import java.awt.Graphics;
import vektor.Zweivektor;
import graph.Nachbarschaftsliste;
import welt.graph.Zweigraphwelt;
import sicht.Sicht;
import welt.strecke.Zweistreckewelt;
import strecke.Zweistrecke;
import sicht.punkt.Punktsicht;
import sicht.strecke.Streckesicht;

// Eine Sicht der zweidimensionalen Graphwelt.
public class Zweigraphsicht extends Sicht {

    Nachbarschaftsliste nl;
    Zweivektor[] orten;

    public Zweigraphsicht(Nachbarschaftsliste nl, Zweivektor[] ol) {
	this.nl = nl;
	this.orten = ol;
    }

    public void darstellen(Graphics g) {

	// Ein Graph dargestellt ist nur Kreisen und Strecken.

	// Nehme die wesentliche Daten.
	Zweigraphwelt zgw = new Zweigraphwelt(this.nl, this.orten);
	Zweistrecke[] kanten = zgw.nehmekanten();
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

