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

    /*
      Das Zentrum von drawCircle() von Java ist nicht genau auf dem
      gegebenen Ort dargestellt. Zum Beispiel
      
      Knoten (0,0,0) Durchmesser 3
      Kante (0,0,0) bis (10,10,10)
      
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
	     
      weil das Zentrum des Kreises nicht auf (0,0,0) steht. Wir sollen
      die Stellen des Knoten verbessern. In diesem Beispiel
      verschieben wir die Stellen des Kreises -3 in die x-,
      y- und z-Richtung.
    */
    void verbessereknoten(Dreivektor zp) {
	Dreivektor unterschied = new Dreivektor(-(this.durchmesser / 32.0),
						-(this.durchmesser / 32.0),
						-(this.durchmesser / 32.0));
	zp.addiere(unterschied);
    }

    public void darstellen(Graphics g) {

	// Wandle eine Dreigraphsicht zu einer Zweigraphsicht.  Wir
	// müssen nur die dreidimensionale Stellen zu
	// zweidimensionalen verlegen.

	Dreivektor[] dreiorten = this.dgw.nehmeknoten();
	Zweivektor[] zweiorten = new Zweivektor[dreiorten.length];

	// Für jeden Knoten, verbessere den Knoten.
	for (int i = 0; i < dreiorten.length; i++) {
	    this.verbessereknoten(dreiorten[i]);
	}

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
