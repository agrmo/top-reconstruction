package sicht.linear;

import java.awt.Graphics;
import javax.swing.JComponent;
import sicht.kante.Kantesicht;
import verleger.linear.Linearverleger;
import welt.zweikante.Zweikantewelt;

// Eine Sicht, die eine Kantewelt einnimt. Sie macht eine lineare
// Abbildung der Kantewelt.
//
// Die Abbildung, die die Punkten der Welt umwandelt:
// x' = mx * x + bx
// y' = my * y + by
//
public class Linearsicht extends JComponent {

    public Zweikantewelt kw;
    public Linearverleger lv;

    public Linearsicht(Zweikantewelt kw,
		       double mx, double bx, double my, double by) {
	this.kw = kw;
	this.lv = new Linearverleger(mx, bx, my, by);
    }

    // Stellen die Kantewelt mit Hilfe zwier Verleger dar.  Er verhält
    // sich wie ein Bildschirm, und verschiebt alle Punkten, sodaß wir
    // sie sehen können.
    public void paintComponent(Graphics g) {
	super.paintComponent(g);

	// Java wird paintComponent viel Mal anrufen.
	// Das verschiebt jedes Mal die ursprüngliche Daten.
	// Leider müssen wir eine ganze neue Welt aufbauen.
	
	Zweikantewelt neueZkw = lv.verlegenWelt(this.kw);
	Kantesicht ks = new Kantesicht(neueZkw);
	
	ks.paintComponent(g);
    }
}
