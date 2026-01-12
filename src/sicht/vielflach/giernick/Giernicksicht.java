package sicht.vielflach.giernick;

import vektor.Dreivektor;
import java.awt.Graphics;
import javax.swing.JComponent;
import sicht.strecke.Streckesicht;
import verleger.basis.Basisverleger;
import welt.zweistrecke.Zweistreckewelt;
import welt.vielflach.Vielflachwelt;
import sicht.Sicht;
import matrix.Dreimatrix;

// Eine Sicht, die eine dreidimensionale Vielflachwelt einnimmt.
// Sie wandelt die Vielflachwelt mit nur einer Verlegung: einer vektoren
// Verlegung. Sie gibt am Ende eine Zweistreckewelt ab.
public class Giernicksicht extends Sicht {

    public Vielflachwelt kw;
    public Dreivektor augevektor;
    public double breite;
    public double brennweite;
    public double hoehe;
    public double gier;
    public double nick;
    public Dreimatrix vorbasis;
    public Dreimatrix basis;

    public Giernicksicht(Vielflachwelt kw,
			 Dreivektor augevektor, double brennweite,
			 double breite, double hoehe,
			 double gier, double nick) {

	this.kw = kw;
	this.augevektor = augevektor;
	this.brennweite = brennweite;
	this.breite = breite;
	this.hoehe = hoehe;
	this.vorbasis = new Dreimatrix(1,0,0,0,1,0,0,0,1);
	this.basis = new Dreimatrix(1,0,0,0,1,0,0,0,1);
	this.gier = gier;
	this.nick = nick;
    }

    public void darstellen(Graphics g) {
	
	// Benutzen die Verleger.
	Zweistreckewelt zkw = Basisverleger.verlegen(this.kw, this.augevektor, this.brennweite,
						     this.breite, this.hoehe,
						     this.vorbasis, this.basis);

	// Wir haben schon eine Sicht, die die Zweistreckewelt
	// darstellen kann. Benutzen sie.
	Streckesicht ks = new Streckesicht(zkw);
	ks.darstellen(g);
    }
}
