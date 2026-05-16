package auge;

import vektor.Dreivektor;

// Das Auge. Er besizt die Eigenschaften eines Augenpaars.
public class Auge {
    
    public double breite;
    public double hoehe;
    public Dreivektor entfernung;
    public double brennweite;
    public double winkeleins;
    public double winkelzwei;
    public double winkeldrei;

    public Auge(Dreivektor entfernung, double brennweite,
		double breite, double hoehe,
		double winkeleins,
		double winkelzwei,
		double winkeldrei) {
	this.breite = breite;
	this.hoehe = hoehe;
	this.entfernung = entfernung;
	this.brennweite = brennweite;
	this.winkeleins = winkeleins;
	this.winkelzwei = winkelzwei;
	this.winkeldrei = winkeldrei;
    }
}
