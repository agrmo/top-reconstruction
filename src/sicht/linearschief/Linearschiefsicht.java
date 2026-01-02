package sicht.linearschief;

import java.awt.Graphics;
import javax.swing.JComponent;
import sicht.kante.Kantesicht;
import straffer.Straffer;
import verschieber.Verschieber;
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

    public double mx;
    public double bx;
    public double my;
    public double by;

    public Linearschiefsicht(Koerperwelt kw,
			     double a,
			     double mx, double bx, double my, double by) {
	this.kw = kw;
	this.sv = new Schiefverleger(a);
	
	this.mx = mx;
	this.bx = bx;
	this.my = my;
	this.by = by;
    }

    // Stellen die Körperwelt mit Hilfe zwier Verleger dar:
    //
    // 1. Schiefverleger: Er nimmt die Welt von einer
    // dreidimensionalen zu einer zweidimensionalen.
    //
    // 2. Straffer: Er verhält sich wie ein Bildschirm, und
    // verschiebt alle Punkten, sodaß wir sie sehen können.
    public void paintComponent(Graphics g) {
	super.paintComponent(g);
	
	// Benutzen die Verlegungen.
	Zweikantewelt zkw = this.sv.verlegenWelt(this.kw);

	// Straffen die Punkten.
	Zweikantewelt zkwNeu = Straffer.straffenWelt(zkw,
						     this.mx, this.my);
	
	// Verschieben die Punkten.
	Zweikantewelt zkwNeuNeu = Verschieber.verschieben(zkwNeu,
							  this.bx, this.by);

	// Wir haben schon eine Sicht, die die Zweikantewelt
	// darstellen kann. Benutzen sie.
	Kantesicht ks = new Kantesicht(zkwNeuNeu);
	ks.paintComponent(g);
    }
}

