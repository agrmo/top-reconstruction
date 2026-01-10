package sicht.auge;

import punkt.Dreipunkt;
import java.awt.Graphics;
import javax.swing.JComponent;
import sicht.strecke.Streckesicht;
import verleger.auge.Augeverleger;
import welt.zweistrecke.Zweistreckewelt;
import welt.koerper.Koerperwelt;
import sicht.Sicht;

// Eine Sicht, die eine dreidimensionale Körperwelt einnimmt.
// Sie wandelt die Körperwelt mit nur einer Verlegung: einer punkten
// Verlegung. Sie gibt am Ende eine Zweistreckewelt ab.
public class Augesicht extends Sicht {

    public Koerperwelt kw;
    public Dreipunkt augepunkt;
    public int breite;
    public int brennweite;
    public int hoehe;
    public double gier;
    public double nick;
    public double roll;

    public Augesicht(Koerperwelt kw,
		     Dreipunkt augepunkt, int brennweite,
		     int breite, int hoehe,
		     double gier, double nick, double roll) {

	this.kw = kw;
	this.augepunkt = augepunkt;
	this.brennweite = brennweite;
	this.breite = breite;
	this.hoehe = hoehe;
	this.gier = gier;
	this.nick = nick;
	this.roll = roll;
    }

    // Wir müssen entscheiden, wer diese Körper darstellen wird.
    public void darstellen(Graphics g) {
	
	// Benutzen die Verleger.
	Zweistreckewelt zkw = Augeverleger.verlegen(this.kw, this.augepunkt, this.brennweite,
						    this.breite, this.hoehe,
						    this.gier, this.nick, this.roll);

	// Wir haben schon eine Sicht, die die Zweistreckewelt
	// darstellen kann. Benutzen sie.
	Streckesicht ks = new Streckesicht(zkw);
	ks.darstellen(g);
    }
}
