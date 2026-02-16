package sicht.strecke.straff;

import java.awt.Graphics;
import verschieber.Verschieber;
import sicht.strecke.Streckesicht;
import straffer.Straffer;
import welt.zweistrecke.Zweistreckewelt;
import sicht.Sicht;

// Eine Sicht, die eine Streckewelt einnimt. Sie macht eine straffe
// Abbildung der Streckewelt.
//
// Die Abbildung, die die Vektoren der Welt umwandelt:
// x' = mx * x
// y' = my * y
//
public class Straffsicht extends Sicht {

    public Zweistreckewelt welt;
    public double mx;
    public double my;

    public Straffsicht(Zweistreckewelt welt,
		       double mx, double my) {
	this.welt = welt;
	this.mx = mx;
	this.my = my;
    }

    // Stellen die Streckewelt mit Hilfe zwier Verleger dar.  Er verhält
    // sich wie ein Bildschirm, und verschiebt alle Vektoren, sodaß wir
    // sie sehen können.
    public void darstellen(Graphics g) {
	
	// Java wird paintComponent viel Mal anrufen.  Das würde jedes
	// Mal die ursprüngliche Daten verschieben. Das kann nicht
	// sein. Deshalb müssen wir leider eine ganze neue Welt
	// aufbauen.
	
	Zweistreckewelt zsw = Straffer.straffenWelt(this.welt, this.mx, this.my);
	Streckesicht ss = new Streckesicht(zsw);
	ss.darstellen(g);
    }
}
