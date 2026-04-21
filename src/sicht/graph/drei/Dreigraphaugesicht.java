package sicht.graph.drei;

import dreher.euler.Eulerdreher;
import java.awt.Graphics;
import javax.swing.JComponent;
import matrix.Dreimatrix;
import sicht.Sicht;
import sicht.graph.zwei.Zweigraphsicht;
import vektor.Dreivektor;
import vektor.Zweivektor;
import verleger.auge.Augeverleger;
import welt.graph.Dreigraphwelt;
import welt.graph.Zweigraphwelt;

// Eine Sicht, die eine dreidimensionale Graphwelt darstellt.
public class Dreigraphaugesicht extends Sicht {

    // Die Welt.
    public Dreigraphwelt dgw;

    // Jeder Knoten ist als einen Kreis dargestellt.
    double durchmesser;

    // Ein Vektor, mit dem wir die Weltkoordinaten verschieben
    // werden. Er funktioniert wie ein Augenpaar. Er zeigt wovon wir
    // uns die Welt anschauen.
    public Dreivektor entfernung;

    // Die Eigenschaften dieser Augen.
    public double breite;
    public double brennweite;
    public double hoehe;

    // Die Eulerwinkel.
    public double winkeleins;
    public double winkelzwei;
    public double winkeldrei;
    
    public Dreigraphaugesicht(Dreigraphwelt dgw,
			      double durchmesser,
			      Dreivektor entfernung, double brennweite,
			      double breite, double hoehe,
			      double winkeleins,
			      double winkelzwei,
			      double winkeldrei) {

	this.dgw = dgw;
	this.durchmesser = durchmesser;
	this.entfernung = entfernung;
	this.brennweite = brennweite;
	this.breite = breite;
	this.hoehe = hoehe;
	this.winkeleins = winkeleins;
	this.winkelzwei = winkelzwei;
	this.winkeldrei = winkeldrei;
    }
    
    public void darstellen(Graphics g) {

	// Wandle eine Dreigraphsicht zu einer Zweigraphsicht.  Wir
	// müssen nur die dreidimensionale Stellen zu
	// zweidimensionalen verlegen.

	Dreivektor[] dreiorten = this.dgw.nehmeknoten();
	Zweivektor[] zweiorten = new Zweivektor[dreiorten.length];

	// Wir brauchen nicht...die Knoten hier zu verschieben...?
	// Die Zweigraphsicht wird die Knoten richtig verschieben...?

	// Für jeden Knoten, verlegen den Knoten.
	Dreimatrix drehung = Eulerdreher.nehmedrehung(this.winkeleins,
						      this.winkelzwei,
						      this.winkeldrei);

	// Verlege jeden Vektor. 
	for (int i = 0; i < zweiorten.length; i++) {
	    zweiorten[i] = Augeverleger.verlege(dreiorten[i], this.entfernung, this.brennweite,
						 this.breite, this.hoehe,
						 drehung);
	}

	Zweigraphwelt zw = new Zweigraphwelt(this.dgw.graph, zweiorten);
	Zweigraphsicht zs = new Zweigraphsicht(zw, this.durchmesser);
	zs.darstellen(g);
    }
}
