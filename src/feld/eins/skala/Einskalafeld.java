package feld.eins.skala;

// Eindimensionale Skalafeld.
// Die Stellen sind stellen.
// Die Werte sind die Reihe von double.
public class Einskalafeld {

    public double[] orte;
    public double[] werte;

    public Einskalafeld(double[] orte, double[] werte) {
	this.orte = orte;
	this.werte = werte;
    }
}
