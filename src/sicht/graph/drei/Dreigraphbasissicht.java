package sicht.graph.drei;

import java.awt.Graphics;
import javax.swing.JComponent;
import matrix.Dreimatrix;
import sicht.Sicht;
import sicht.graph.zwei.Zweigraphsicht;
import sicht.strecke.Streckesicht;
import vektor.Dreivektor;
import verleger.basis.Basisverleger;
import welt.graph.Dreigraphwelt;
import welt.graph.Zweigraphwelt;
import welt.strecke.Zweistreckewelt;

// Eine Sicht, die eine dreidimensionale Zweigraphwelt darstellt.
// Sie wandelt die Zweigraphwelt mit nur einer Verlegung: einer vektoren
// Verlegung.
public class Dreigraphbasissicht extends Sicht {

    public Dreigraphwelt dgw;
    public Dreivektor augevektor;
    public double breite;
    public double brennweite;
    public double hoehe;
    public Dreimatrix vorbasis;
    public Dreimatrix basis;

    public Dreigraphbasissicht(Dreigraphwelt dgw,
			       Dreivektor augevektor, double brennweite,
			       double breite, double hoehe) {

	this.dgw = dgw;
	this.augevektor = augevektor;
	this.brennweite = brennweite;
	this.breite = breite;
	this.hoehe = hoehe;
	this.vorbasis = new Dreimatrix(1,0,0,0,1,0,0,0,1);
	this.basis = new Dreimatrix(1,0,0,0,1,0,0,0,1);
    }

    public void darstellen(Graphics g) {
	
	// Benutzen den Verleger.
	
	Zweigraphwelt zgw = Basisverleger.verlegen(this.dgw,
						   this.augevektor, this.brennweite,
						   this.breite, this.hoehe,
						   this.vorbasis, this.basis);

	// Wir haben schon eine Sicht, die die Zweistreckewelt
	// darstellen kann. Benutzen sie.
	Zweigraphsicht zgs = new Zweigraphsicht(zgw);
	zgs.darstellen(g);
    }
}
