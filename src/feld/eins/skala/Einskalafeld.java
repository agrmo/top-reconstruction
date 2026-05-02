package feld.eins.skala;

// Eindimensionale Skalafeld.  Der Eintrag is eindimensional, und die
// Ausgabe ist eindimensional.  Eine Stelle ist eine eindimensionale
// Zahl.  Ein Wert ist ein eindimensionale Zahl.
public class Einskalafeld {

    public double[] orte;
    public double[] werte;

    public Einskalafeld(double[] orte, double[] werte) {
	this.orte = orte;
	this.werte = werte;
    }
}
