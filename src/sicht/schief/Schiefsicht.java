package sicht.schief;

import java.awt.Graphics;
import sicht.strecke.Streckesicht;
import verleger.schief.Schiefverleger;
import welt.zweistrecke.Zweistreckewelt;
import welt.koerper.Koerperwelt;
import sicht.Sicht;

// Eine Sicht, die eine dreidimensionale Körperwelt einnimmt.
// Sie wandelt die Körperwelt mit nur einer Verlegung: einer schiefen
// Verlegung. Sie gibt am Ende eine Zweistreckewelt ab.
public class Schiefsicht extends Sicht {

    Koerperwelt kw;
    Schiefverleger sv;

    public Schiefsicht(Koerperwelt kw, double a) {
	this.kw = kw;
	this.sv = new Schiefverleger(a);
    }

    // Wir müssen entscheiden, wer diese Körper darstellen wird.
    public void darstellen(Graphics g) {
	// Benutzen die Verleger.
	Zweistreckewelt zkw = this.sv.verlegenWelt(this.kw);

	// Wir haben schon eine Sicht, die die Zweistreckewelt
	// darstellen kann. Benutzen sie.
	Streckesicht ks = new Streckesicht(zkw);
	ks.darstellen(g);
    }
}


