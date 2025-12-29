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

    public Punktkoerperwelt pkw;
    public Schiefverleger sv;
    public Linearverleger lv;

    public Linearschiefsicht(Punktkoerperwelt pkw,
			     double a,
			     double mx, double bx, double my, double by) {
	this.pkw = pkw;
	this.sv = new Schiefverleger(a);
	this.lv = new Linearverleger(mx, bx, my, by);
    }

    // Stellen die Punktkörperwelt mit Hilfe zwier Verleger dar:
    //
    // 1. Schiefverleger: Er nimmt die Welt von einer
    // dreidimensionalen zu einer zweidimensionalen.
    //
    // 2. Linearverleger: Er verhält sich wie ein Bildschirm, und
    // verschiebt alle Punkten, sodaß wir sie sehen können.
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

