package sicht.graph.drei;

import dreher.euler.Eulerdreher;
import java.awt.Graphics;
import javax.swing.JComponent;
import matrix.Dreimatrix;
import sicht.Sicht;
import sicht.punkt.Zweipunktsicht;
import sicht.strecke.Streckesicht;
import strecke.Dreistrecke;
import strecke.Zweistrecke;
import vektor.Dreivektor;
import vektor.Zweivektor;
import verleger.auge.Augeverleger;
import welt.graph.Dreigraphwelt;
import welt.punkt.Zweipunktwelt;
import welt.strecke.Zweistreckewelt;

// Eine Sicht, die eine dreidimensionale Graphwelt darstellt.
public class Dreigraphaugesicht extends Sicht {
    
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

	Dreivektor[] knoten = this.dgw.nehmeknoten();
	Dreistrecke[] kanten = this.dgw.nehmekanten();

	// Für jeden Knoten, verbessere den Knoten.
	for (int i = 0; i < knoten.length; i++) {
	    this.verbessereknoten(knoten[i]);
	}

	Zweivektor[] verlegteknoten = new Zweivektor[knoten.length];
	Zweistrecke[] verlegtekanten = new Zweistrecke[kanten.length];

	Dreimatrix drehung = Eulerdreher.nehmedrehung(this.winkeleins,
						      this.winkelzwei,
						      this.winkeldrei);
	
	// Verlege die Knoten.
	// Verlege den Dreivektor zu einem Zweivektor.
	for (int i = 0; i < knoten.length; i++) {
	    verlegteknoten[i] = Augeverleger.verlege(knoten[i],
						     this.entfernung, this.brennweite,
						     this.breite, this.hoehe,
						     drehung);
	}

	// Verlege die Kanten.
	// Verlege die Dreistrecke zu einer Zweistrecke.
	for (int i = 0; i < kanten.length; i++) {
	    verlegtekanten[i] = Augeverleger.verlege(kanten[i],
						     this.entfernung, this.brennweite,
						     this.breite, this.hoehe,
						     drehung);
	}

	// Stelle die Knoten dar.
	Zweipunktwelt pw = new Zweipunktwelt(verlegteknoten);
	Zweipunktsicht ps = new Zweipunktsicht(pw, this.durchmesser);
	ps.darstellen(g);

	// Stelle die Kanten dar.
	Zweistreckewelt sw = new Zweistreckewelt(verlegtekanten);
	Streckesicht ss = new Streckesicht(sw);
	ss.darstellen(g);
    }
}
