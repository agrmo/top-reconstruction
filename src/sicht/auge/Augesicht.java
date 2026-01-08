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
    public int perspektive;
    public int hoehe;
    public double yaw;
    public double pitch;
    public double roll;

    public Augesicht(Koerperwelt kw,
		     Dreipunkt augepunkt, int perspektive,
		     int breite, int hoehe,
		     double yaw, double pitch, double roll) {

	this.kw = kw;
	this.augepunkt = augepunkt;
	this.perspektive = perspektive;
	this.breite = breite;
	this.hoehe = hoehe;
	this.yaw = yaw;
	this.pitch = pitch;
	this.roll = roll;
    }

    // Wir müssen entscheiden, wer diese Körper darstellen wird.
    public void darstellen(Graphics g) {
	
	// Benutzen die Verleger.
	Zweistreckewelt zkw = Augeverleger.verlegen(this.kw, this.augepunkt, this.perspektive,
						    this.breite, this.hoehe,
						    this.yaw, this.pitch, this.roll);

	// Wir haben schon eine Sicht, die die Zweistreckewelt
	// darstellen kann. Benutzen sie.
	Streckesicht ks = new Streckesicht(zkw);
	ks.paintComponent(g);
    }
}


