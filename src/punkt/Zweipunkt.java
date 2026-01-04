package punkt;

// Der Zweipunkt.
//
// Ein Zweipunkt ist eine Liste von zwei ganzen Zahlen.
public class Zweipunkt {

    // Die Teile dieses Zweipunktes.
    public double xteil;
    public double yteil;

    public Zweipunkt(double x, double y) {
	this.xteil = x;
	this.yteil = y;
    }

    // Addiere die Zahlen zu diesem Zweipunkt p.
    public void addieren(Zweipunkt p) {
	this.xteil += p.xteil;
	this.yteil += p.yteil;
    }
}
