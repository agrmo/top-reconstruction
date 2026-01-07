package bogen;

// Der Bogen. Er hat eine Breite und eine Höhe. Der Bogen fängt mit
// dem Anfangwinkel an und breitet bei dem Unterschiedwinkel weiter.
public class Bogen {

    public int breite;
    public int hoehe;
    public int anfangwinkel;
    public int unterschiedwinkel;

    public Bogen(int b, int h, int aw, int uw) {

	this.breite = b;
	this.hoehe = h;
	this.anfangwinkel = aw;
	this.unterschiedwinkel = uw;
    }
}
