package auge;

import matrix.Dreimatrix;
import vektor.Dreivektor;

// Das Auge. Er besizt die Eigenschaften eines Augenpaars.
public class Auge {

    double breite;
    double hoehe;
    Dreivektor entfernung;
    double brennweite;
    Dreimatrix drehung;

    public Auge(Dreivektor entfernung, double brennweite,
		double breite, double hoehe,
		Dreimatrix drehung) {
	this.breite = breite;
	this.hoehe = hoehe;
	this.entfernung = entfernung;
	this.brennweite = brennweite;
	this.drehung = drehung;
    }
}
