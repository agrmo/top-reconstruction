package sicht.vielflach.basis;

import vektor.Dreivektor;
import java.awt.Graphics;
import javax.swing.JComponent;
import sicht.strecke.Streckesicht;
import verleger.basis.Basisverleger;
import welt.strecke.Zweistreckewelt;
import welt.vielflach.Vielflachwelt;
import sicht.Sicht;
import matrix.Dreimatrix;

// Eine Sicht, die eine dreidimensionale Vielflachwelt einnimmt.
// Sie wandelt die Vielflachwelt mit nur einer Verlegung: einer vektoren
// Verlegung. Sie gibt am Ende eine Zweistreckewelt ab.
public class Vielflachbasissicht extends Sicht {

    public Vielflachwelt vw;
    public Dreivektor augevektor;
    public double breite;
    public double brennweite;
    public double hoehe;
    public Dreimatrix vorbasis;
    public Dreimatrix basis;

    public Vielflachbasissicht(Vielflachwelt vw,
			       Dreivektor augevektor, double brennweite,
			       double breite, double hoehe) {

	this.vw = vw;
	this.augevektor = augevektor;
	this.brennweite = brennweite;
	this.breite = breite;
	this.hoehe = hoehe;
	this.vorbasis = new Dreimatrix(1,0,0,0,1,0,0,0,1);
	this.basis = new Dreimatrix(1,0,0,0,1,0,0,0,1);
    }

    public void darstellen(Graphics g) {
	
	// Benutzen die Verleger.
	Zweistreckewelt zsw = Basisverleger.verlegen(this.vw, this.augevektor, this.brennweite,
						     this.breite, this.hoehe,
						     this.vorbasis, this.basis);

	// Wir haben schon eine Sicht, die die Zweistreckewelt
	// darstellen kann. Benutzen sie.
	Streckesicht ss = new Streckesicht(zsw);
	ss.darstellen(g);
    }
}
