package bogen;

// Der Bogen. Er besitzt eine Breite und eine Höhe. Der Bogen fängt 
// mit dem Anfangswinkel an und verbreitet sich mit dem
// Unterschiedwinkel weiter.
public class Bogen {

    public double breite;
    public double hoehe;
    public double anfangswinkel;
    public double unterschiedwinkel;

    public Bogen(double b, double h, double aw, double uw) {
	this.breite = b;
	this.hoehe = h;
	this.anfangswinkel = aw;
	this.unterschiedwinkel = uw;
    }
}
