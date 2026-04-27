package bogen;

import vektor.Dreivektor;

// Ein dreidimensionaler Bogen. Er besitzt zwei Einheitsvektoren, eine
// Breite, eine Höhe, einen Anfangswinkel und einen Unterschiedwinkel.
public class Dreibogen {

    // Der Briete des Ovals.
    public int breite;

    // Die Höhe des Ovals.
    public int hoehe;

    // Der Anfangswinkel auf der Fläche des Bogens.
    public int anfangswinkel;

    // Der Unterschiedwinkel auf der Fläche des Bogens.
    public int unterschiedwinkel;

    // Die Richtung der Breite des Bogens. Einheitsvektor.
    public Dreivektor breitevektor;

    // Die Richtung der Höhe des Bogens. Einheitsvektor.
    public Dreivektor hoehevektor;

    public Dreibogen(int b, int h, int aw, int uw,
		     Dreivektor bv, Dreivektor hv) {
	this.breite = b;
	this.hoehe = h;
	this.anfangswinkel = aw;
	this.unterschiedwinkel = uw;
	this.breitevektor = bv;
	this.hoehevektor = hv;
    }
}
