package sicht.vielflach.giernick;

import vektor.Dreivektor;
import java.awt.Graphics;
import javax.swing.JComponent;
import sicht.strecke.Streckesicht;
import verleger.giernick.Giernickverleger;
import welt.zweistrecke.Zweistreckewelt;
import welt.vielflach.Vielflachwelt;
import sicht.Sicht;

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

    public Giernicksicht(Vielflachwelt kw,
			 Dreivektor augevektor, double brennweite,
			 double breite, double hoehe,
			 double gier, double nick) {

	this.kw = kw;
	this.augevektor = augevektor;
	this.brennweite = brennweite;
	this.breite = breite;
	this.hoehe = hoehe;
	this.gier = gier;
	this.nick = nick;

	// Wir brauchen eine Matrix, die die jetzige Basisvektoren 
    }

    // Wir müssen entscheiden, wer diese Körper darstellen wird.
    public void darstellen(Graphics g) {
	
	// Benutzen die Verleger.
	Zweistreckewelt zkw = Giernickverleger.verlegen(this.kw, this.augevektor, this.brennweite,
							this.breite, this.hoehe,
							this.gier, this.nick);

	// Wir haben schon eine Sicht, die die Zweistreckewelt
	// darstellen kann. Benutzen sie.
	Streckesicht ks = new Streckesicht(zkw);
	ks.darstellen(g);
    }
}
