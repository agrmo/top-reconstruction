package sicht.auge;

import punkt.Dreipunkt;
import java.awt.Graphics;
import javax.swing.JComponent;
import sicht.kante.Kantesicht;
import verleger.auge.Augeverleger;
import welt.zweikante.Zweikantewelt;
import welt.koerper.Koerperwelt;

// Eine Sicht, die eine dreidimensionale Körperwelt einnimmt.
// Sie wandelt die Körperwelt mit nur einer Verlegung: einer punkten
// Verlegung. Sie gibt am Ende eine Zweikantewelt ab.
public class Augesicht extends JComponent {

    Koerperwelt kw;
    Dreipunkt augepunkt;
    int perspektive;
    int breite;
    int hoehe;
    int yaw;
    int pitch;
    int roll;

    public Augesicht(Koerperwelt kw,
		     Dreipunkt augepunkt, int perspektive,
		     int breite, int hoehe,
		     int yaw, int pitch, int roll) {

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
    public void paintComponent(Graphics g) {
	super.paintComponent(g);
	
	// Benutzen die Verleger.
	Zweikantewelt zkw = Augeverleger.verlegen(this.kw, this.augepunkt, this.perspektive,
						  this.breite, this.hoehe,
						  this.yaw, this.pitch, this.roll);

	// Wir haben schon eine Sicht, die die Zweikantewelt
	// darstellen kann. Benutzen sie.
	Kantesicht ks = new Kantesicht(zkw);
	ks.paintComponent(g);
    }
}


