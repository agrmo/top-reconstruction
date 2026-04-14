package sicht.graph.drei;

import java.awt.Graphics;
import javax.swing.JComponent;
import matrix.Dreimatrix;
import sicht.Sicht;
import sicht.graph.zwei.Zweigraphsicht;
import sicht.strecke.Streckesicht;
import vektor.Dreivektor;
import verleger.auge.Augeverleger;
import welt.graph.Dreigraphwelt;
import welt.graph.Zweigraphwelt;
import welt.strecke.Zweistreckewelt;

// Eine Sicht, die eine dreidimensionale Zweigraphwelt darstellt.
// Sie wandelt die Zweigraphwelt mit nur einer Verlegung: einer vektoren
// Verlegung.
public class Dreigraphaugesicht extends Sicht {
    
    public Dreigraphwelt dgw;

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
			      Dreivektor entfernung, double brennweite,
			      double breite, double hoehe,
			      double winkeleins,
			      double winkelzwei,
			      double winkeldrei) {

	this.dgw = dgw;
	this.entfernung = entfernung;
	this.brennweite = brennweite;
	this.breite = breite;
	this.hoehe = hoehe;
	this.winkeleins = winkeleins;
	this.winkelzwei = winkelzwei;
	this.winkeldrei = winkeldrei;
    }

    public void darstellen(Graphics g) {
	
	// Benutzen den Verleger.	
	Zweigraphwelt zgw = Augeverleger.verlege(this.dgw,
						 this.entfernung, this.brennweite,
						 this.breite, this.hoehe,
						 this.winkeleins,
						 this.winkelzwei,
						 this.winkeldrei);

	// Wir haben schon eine Sicht, die die Zweistreckewelt
	// darstellen kann. Benutzen sie.
	Zweigraphsicht zgs = new Zweigraphsicht(zgw);
	zgs.darstellen(g);
    }
}
