package sicht.vielflach.schief;

import java.awt.Graphics;
import sicht.Sicht;
import sicht.strecke.Streckesicht;
import verleger.schief.Schiefverleger;
import welt.vielflach.Vielflachwelt;
import welt.zweistrecke.Zweistreckewelt;

// Eine Sicht, die eine dreidimensionale Vielflachwelt einnimmt.
// Sie wandelt die Vielflachwelt mit nur einer Verlegung: einer schiefen
// Verlegung. Sie gibt am Ende eine Zweistreckewelt ab.
public class Schiefsicht extends Sicht {

    Vielflachwelt vw;
    Schiefverleger sv;

    public Schiefsicht(Vielflachwelt vw, double a) {
	this.vw = vw;
	this.sv = new Schiefverleger(a);
    }

    // Wir müssen entscheiden, wer diese Körper darstellen wird.
    public void darstellen(Graphics g) {
	// Benutzen die Verleger.
	Zweistreckewelt zsw = this.sv.verlegenWelt(this.vw);

	// Wir haben schon eine Sicht, die die Zweistreckewelt
	// darstellen kann. Benutzen sie.
	Streckesicht ss = new Streckesicht(zsw);
	ss.darstellen(g);
    }
}


