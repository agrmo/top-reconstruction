package sicht.dreipunkt;

import punkt.Dreipunkt;
import java.awt.Graphics;
import javax.swing.JComponent;
import verleger.auge.Augeverleger;
import punkt.Zweipunkt;
import punkt.Dreipunkt;
import sicht.zweipunkt.Zweipunktsicht;

// Stellen wir die Punkten mit Hilfe einer Punktperspektive dar.
public class Dreipunktsicht extends JComponent {

    public Dreipunkt[] pl;
    public Dreipunkt augepunkt;
    public int breite;
    public int perspektive;
    public int hoehe;
    public double yaw;
    public double pitch;
    public double roll;

    public Dreipunktsicht(Dreipunkt[] pl,
			  Dreipunkt augepunkt, int perspektive,
			  int breite, int hoehe,
			  double yaw, double pitch, double roll) {
	
	this.pl = pl;
	this.augepunkt = augepunkt;
	this.perspektive = perspektive;
	this.breite = breite;
	this.hoehe = hoehe;
	this.yaw = yaw;
	this.pitch = pitch;
	this.roll = roll;
    }

    // Wir müssen entscheiden, wer diese Körper darstellen wird.
    public void paintComponent(Graphics g) {
	super.paintComponent(g);
	
	// Verlegen diese zweidimensionale Punkten zu dreidimensionalen Punkten.
	Zweipunkt[] zpl = Augeverleger.verlegen(this.pl, this.augepunkt, this.perspektive,
						this.breite, this.hoehe,
						this.yaw, this.pitch, this.roll);

	// Wir haben schon eine Sicht, die Zweipunkten darstellen
	// kann. Benutzen sie.
	Zweipunktsicht zps = new Zweipunktsicht(zpl);
	zps.paintComponent(g);
    }
}


