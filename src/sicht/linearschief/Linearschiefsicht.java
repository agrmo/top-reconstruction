package sicht.linearschief;

import java.awt.Graphics;
import javax.swing.JComponent;
import sicht.kante.Kantesicht;
import verleger.linear.Linearverleger;
import verleger.schief.Schiefverleger;
import welt.kante.Zweikantewelt;
import welt.punktkoerper.Punktkoerperwelt;

// Eine Sicht, die eine dreidimensionale Punktkörperwelt einnimmt.
// Sie wandelt die Körperwelt mit zwei Verlegungen: einer schiefen
// Verlegung, und einer linearen Verlegung. Sie gibt am Ende eine
// Zweikantewelt ab.
public class Linearschiefsicht extends JComponent {

    Punktkoerperwelt pkw;
    Schiefverleger sv;
    Linearverleger lv;

    public Linearschiefsicht(Punktkoerperwelt pkw,
			     double a,
			     double mx, double bx, double my, double by) {
	this.pkw = pkw;
	this.sv = new Schiefverleger(a);
	this.lv = new Linearverleger(mx, bx, my, by);
    }

    // Wir müssen entscheiden, wer diese Körper darstellen wird.
    public void paintComponent(Graphics g) {
	super.paintComponent(g);
	
	// Benutzen die Verleger.
	Zweikantewelt zkw = this.sv.verlegenWelt(this.pkw);
	lv.verlegenWelt(zkw);

	// Wir haben schon eine Sicht, die die Zweikantewelt
	// darstellen kann. Benutzen sie.
	Kantesicht ks = new Kantesicht(zkw);
	ks.paintComponent(g);
    }
}

