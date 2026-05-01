package feld.zwei;

import vektor.Zweivektor;

// Zweidimensionale Skalafeld.
// Die Stellen sind stellen.
// Die Werte sind die Reihe von double.
public class Zweiskalafeld {

    public Zweivektor[] orte;
    public double[] werte;

    public Zweiskalafeld(Zweivektor[] orte, double[] werte) {
	this.orte = orte;
	this.werte = werte;
    }
}
