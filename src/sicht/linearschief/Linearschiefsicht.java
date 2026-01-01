package sicht.linearschief;

import java.awt.Graphics;
import javax.swing.JComponent;
import sicht.kante.Kantesicht;
import verleger.linear.Linearverleger;
import verleger.schief.Schiefverleger;
import welt.zweikante.Zweikantewelt;
import welt.koerper.Koerperwelt;

// Eine Sicht, die eine dreidimensionale Körperwelt einnimmt.
// Sie wandelt die Körperwelt mit zwei Verlegungen: einer schiefen
// Verlegung, und einer linearen Verlegung. Sie gibt am Ende eine
// Zweikantewelt ab.
//
// a: Die Tiefe der z-Achse.
//
// Lineare Funktionen, die die Punkten der Welt verändern:
// x' = mx * x + bx
// y' = my * y + by
//
public class Linearschiefsicht extends JComponent {

    public Koerperwelt kw;
    public Schiefverleger sv;
    public Linearverleger lv;

    public Linearschiefsicht(Koerperwelt kw,
			     double a,
			     double mx, double bx, double my, double by) {
	this.kw = kw;
	this.sv = new Schiefverleger(a);
	this.lv = new Linearverleger(mx, bx, my, by);
    }

    // Stellen die Körperwelt mit Hilfe zwier Verleger dar:
    //
    // 1. Schiefverleger: Er nimmt die Welt von einer
    // dreidimensionalen zu einer zweidimensionalen.
    //
    // 2. Linearverleger: Er verhält sich wie ein Bildschirm, und
    // verschiebt alle Punkten, sodaß wir sie sehen können.
    public void paintComponent(Graphics g) {
	super.paintComponent(g);
	
	// Benutzen die Verleger.
	Zweikantewelt zkw = this.sv.verlegenWelt(this.kw);
	Zweikantewelt zkwNeu = lv.verlegenWelt(zkw);

	// Wir haben schon eine Sicht, die die Zweikantewelt
	// darstellen kann. Benutzen sie.
	Kantesicht ks = new Kantesicht(zkwNeu);
	ks.paintComponent(g);
    }
}

