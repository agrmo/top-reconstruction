package sicht.vielflach.giernick;

import vektor.Dreivektor;
import java.awt.Graphics;
import javax.swing.JComponent;
import sicht.strecke.Streckesicht;
import verleger.giernick.Giernickverleger;
import welt.zweistrecke.Zweistreckewelt;
import welt.vielflach.Vielflachwelt;
import sicht.Sicht;

// Eine Sicht, die eine dreidimensionale Vielflachwelt einnimmt.  Sie
// wandelt die Vielflachwelt mit nur einer Verlegung: einer vektoren
// Verlegung. Sie gibt am Ende eine Zweistreckewelt ab.
public class Giernicksicht extends Sicht {

    public Vielflachwelt vw;
    public Dreivektor augevektor;
    public double breite;
    public double brennweite;
    public double hoehe;
    public double gier;
    public double nick;

    public Giernicksicht(Vielflachwelt vw,
			 Dreivektor augevektor, double brennweite,
			 double breite, double hoehe,
			 double gier, double nick) {

	this.vw = vw;
	this.augevektor = augevektor;
	this.brennweite = brennweite;
	this.breite = breite;
	this.hoehe = hoehe;
	this.gier = gier;
	this.nick = nick;
    }

    public void darstellen(Graphics g) {
	
	// Benutzen die Verleger.
	Zweistreckewelt zsw = Giernickverleger.verlegen(this.vw, this.augevektor, this.brennweite,
							this.breite, this.hoehe,
							this.gier, this.nick);

	// Wir haben schon eine Sicht, die die Zweistreckewelt
	// darstellen kann. Benutzen sie.
	Streckesicht ss = new Streckesicht(zsw);
	ss.darstellen(g);
    }
}
