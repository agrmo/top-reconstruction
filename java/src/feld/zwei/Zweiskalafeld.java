package feld.zwei;

import vektor.Zweivektor;

// Zweidimensionale Skalafeld.
// Die Stellen sind stellen.
// Die Werte sind die Reihe von double.
//
// Ich glaube, wir können die Felder viel besser nennen. Es gibt die
// Dimension des Eintrags, und es gibt die Dimension der Ausgabe.
// Eintragdimension: n
// Ausgabedimension: m
// Name des Feldes: n-m-Feld
// Oder etwas...
//
public class Zweiskalafeld {

    public Zweivektor[] orte;
    public double[] werte;

    public Zweiskalafeld(Zweivektor[] orte, double[] werte) {
	this.orte = orte;
	this.werte = werte;
    }
}
