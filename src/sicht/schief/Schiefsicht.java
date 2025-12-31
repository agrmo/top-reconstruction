package sicht.schief;

import java.awt.Graphics;
import javax.swing.JComponent;
import sicht.kante.Kantesicht;
import verleger.schief.Schiefverleger;
import welt.kante.Zweikantewelt;
import welt.koerper.Koerperwelt;

// Eine Sicht, die eine dreidimensionale Körperwelt einnimmt.
// Sie wandelt die Körperwelt mit nur einer Verlegung: einer schiefen
// Verlegung. Sie gibt am Ende eine Zweikantewelt ab.
public class Schiefsicht extends JComponent {

    Koerperwelt kw;
    Schiefverleger sv;

    public Schiefsicht(Koerperwelt kw, double a) {
	this.kw = kw;
	this.sv = new Schiefverleger(a);
    }

    // Wir müssen entscheiden, wer diese Körper darstellen wird.
    public void paintComponent(Graphics g) {
	super.paintComponent(g);
	
	// Benutzen die Verleger.
	Zweikantewelt zkw = this.sv.verlegenWelt(this.kw);

	// Wir haben schon eine Sicht, die die Zweikantewelt
	// darstellen kann. Benutzen sie.
	Kantesicht ks = new Kantesicht(zkw);
	ks.paintComponent(g);
    }
}


