package sicht.auge;

import punkt.Dreipunkt;
import java.awt.Graphics;
import javax.swing.JComponent;
import sicht.strecke.Streckesicht;
import verleger.giernick.Giernickverleger;
import welt.zweistrecke.Zweistreckewelt;
import welt.vielflach.Vielflachwelt;
import sicht.Sicht;

// Eine Sicht, die eine dreidimensionale Vielflachwelt einnimmt.
// Sie wandelt die Vielflachwelt mit nur einer Verlegung: einer punkten
// Verlegung. Sie gibt am Ende eine Zweistreckewelt ab.
public class Augesicht extends Sicht {

    public Vielflachwelt kw;
    public Dreipunkt augepunkt;
    public int breite;
    public int brennweite;
    public int hoehe;
    public double gier;
    public double nick;

    public Augesicht(Vielflachwelt kw,
		     Dreipunkt augepunkt, int brennweite,
		     int breite, int hoehe,
		     double gier, double nick) {

	this.kw = kw;
	this.augepunkt = augepunkt;
	this.brennweite = brennweite;
	this.breite = breite;
	this.hoehe = hoehe;
	this.gier = gier;
	this.nick = nick;
    }

    // Wir müssen entscheiden, wer diese Körper darstellen wird.
    public void darstellen(Graphics g) {
	
	// Benutzen die Verleger.
	Zweistreckewelt zkw = Giernickverleger.verlegen(this.kw, this.augepunkt, this.brennweite,
						    this.breite, this.hoehe,
						    this.gier, this.nick);

	// Wir haben schon eine Sicht, die die Zweistreckewelt
	// darstellen kann. Benutzen sie.
	Streckesicht ks = new Streckesicht(zkw);
	ks.darstellen(g);
    }
}
