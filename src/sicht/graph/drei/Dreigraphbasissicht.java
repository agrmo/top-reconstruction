package sicht.graph.drei;

import vektor.Dreivektor;
import java.awt.Graphics;
import javax.swing.JComponent;
import sicht.strecke.Streckesicht;
import sicht.graph.zwei.Zweigraphsicht;
import verleger.basis.Basisverleger;
import welt.strecke.Zweistreckewelt;
import welt.graph.Zweigraphwelt;
import welt.graph.Dreigraphwelt;
import sicht.Sicht;
import matrix.Dreimatrix;

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

    public Dreigraphbasissicht(Dreigraphwelt dgw) {

	this.dgw = dgw;

	// Nicht besonders wichtig, dass diese als Parameter eingehen
	// sollten. Vielleicht bestimme die alle einfach jetzt.
	this.augevektor = new Dreivektor(0,0,0);
	this.brennweite = 500;
	this.breite = 1200;
	this.hoehe = 600;
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
