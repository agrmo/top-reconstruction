package sicht.vielflach.linearschief;

import java.awt.Graphics;
import sicht.strecke.Streckesicht;
import straffer.Straffer;
import verschieber.Verschieber;
import verleger.schief.Schiefverleger;
import welt.zweistrecke.Zweistreckewelt;
import welt.vielflach.Vielflachwelt;
import sicht.Sicht;

// Eine Sicht, die eine dreidimensionale Vielflachwelt einnimmt.
// Sie wandelt die Vielflachwelt mit zwei Verlegungen: einer schiefen
// Verlegung, und einer linearen Verlegung. Sie gibt am Ende eine
// Zweistreckewelt ab.
//
// a: Die Tiefe der z-Achse.
//
// Lineare Funktionen, die die Vektoren der Welt verändern:
// x' = mx * x + bx
// y' = my * y + by
//
public class Linearschiefsicht extends Sicht {

    public Vielflachwelt welt;
    public Schiefverleger sv;
    public double mx;
    public double bx;
    public double my;
    public double by;

    public Linearschiefsicht(Vielflachwelt welt,
			     double a,
			     double mx, double bx, double my, double by) {
	this.welt = welt;
	this.sv = new Schiefverleger(a);
	
	this.mx = mx;
	this.bx = bx;
	this.my = my;
	this.by = by;
    }

    // Stellen die Vielflachwelt mit Hilfe zwier Verleger dar:
    //
    // 1. Schiefverleger: Er nimmt die Welt von einer
    // dreidimensionalen zu einer zweidimensionalen.
    //
    // 2. Straffer: Er verhält sich wie ein Bildschirm, und
    // verschiebt alle Vektoren, sodaß wir sie sehen können.
    public void darstellen(Graphics g) {
	
	// Benutzen die Verlegungen.
	Zweistreckewelt zsw = this.sv.verlegenWelt(this.welt);

	// Straffen die Vektoren.
	Zweistreckewelt zswNeu = Straffer.straffenWelt(zsw,
						       this.mx, this.my);
	
	// Verschieben die Vektoren.
	Zweistreckewelt zswNeuNeu = Verschieber.verschieben(zswNeu,
							    this.bx, this.by);

	// Wir haben schon eine Sicht, die die Zweistreckewelt
	// darstellen kann. Benutzen sie.
	Streckesicht ss = new Streckesicht(zswNeuNeu);
	ss.darstellen(g);
    }
}

