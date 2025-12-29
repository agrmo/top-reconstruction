package sicht.schief;

import java.awt.Graphics;
import javax.swing.JComponent;
import sicht.kante.Kantesicht;
import vektor.Dreivektor;
import verleger.schief.Schiefverleger;
import welt.kante.Zweikantewelt;
import welt.punktkoerper.Punktkoerperwelt;

// Eine Sicht, die eine dreidimensionale Punktkörperwelt einnimmt.
// Sie wandelt die Körperwelt mit nur einer Verlegung: einer schiefen
// Verlegung. Sie gibt am Ende eine Zweikantewelt ab.
public class Schiefsicht extends JComponent {

    Punktkoerperwelt pkw;
    Schiefverleger sv;

    public Schiefsicht(Punktkoerperwelt pkw, Dreivektor d) {
	this.pkw = pkw;
	this.sv = new Schiefverleger(d);
    }

    // Wir müssen entscheiden, wer diese Körper darstellen wird.
    public void paintComponent(Graphics g) {
	super.paintComponent(g);
	
	// Benutzen die Verleger.
	Zweikantewelt zkw = this.sv.verlegenWelt(this.pkw);

	// Wir haben schon eine Sicht, die die Zweikantewelt
	// darstellen kann. Benutzen sie.
	Kantesicht ks = new Kantesicht(zkw);
	ks.paintComponent(g);
    }
}


