package sicht.linearschief;

import java.util.ArrayList;
import javax.swing.JComponent;
import java.awt.Graphics;
import welt.kante.Zweikantewelt;
import kante.Zweikante;
import welt.punktkoerper.Punktkoerperwelt;
import sicht.kante.Kantesicht;
import verleger.linear.Linearverleger;
import verleger.schief.Schiefverleger;
import vektor.Dreivektor;

// Eine Sicht, die eine dreidimensionale Punktkörperwelt einnimmt.
// Sie wandelt die Körperwelt mit zwei Verlegungen: einer schiefen
// Verlegung, und einer linearen Verlegung. Sie gibt am Ende eine
// Zweikantewelt ab.
public class Linearschiefsicht extends JComponent {

    Punktkoerperwelt pkw;
    Schiefverleger sv;
    Linearverleger lv;

    public Linearschiefsicht(Punktkoerperwelt pkw,
			     Dreivektor d,
			     double mx, double bx, double my, double by) {
	this.pkw = pkw;
	this.sv = new Schiefverleger(d);
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

