package sicht.straff;

import java.awt.Graphics;
import verschieber.Verschieber;
import sicht.strecke.Streckesicht;
import straffer.Straffer;
import welt.zweistrecke.Zweistreckewelt;
import sicht.Sicht;

// Eine Sicht, die eine Streckewelt einnimt. Sie macht eine straffe
// Abbildung der Streckewelt.
//
// Die Abbildung, die die Punkten der Welt umwandelt:
// x' = mx * x
// y' = my * y
//
public class Straffsicht extends Sicht {

    public Zweistreckewelt kw;

    public double mx;
    public double my;

    public Straffsicht(Zweistreckewelt kw,
		       double mx, double my) {
	this.kw = kw;
	this.mx = mx;
	this.my = my;
    }

    // Stellen die Streckewelt mit Hilfe zwier Verleger dar.  Er verhält
    // sich wie ein Bildschirm, und verschiebt alle Punkten, sodaß wir
    // sie sehen können.
    public void darstellen(Graphics g) {
	// Java wird paintComponent viel Mal anrufen.  Das verschiebt
	// jedes Mal die ursprüngliche Daten.  Leider müssen wir eine
	// ganze neue Welt aufbauen.

	Zweistreckewelt zkwNeu = Straffer.straffenWelt(this.kw, this.mx, this.my);
	
	Streckesicht ks = new Streckesicht(zkwNeu);
	
	ks.darstellen(g);
    }
}
