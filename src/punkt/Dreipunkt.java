package punkt;

// Der Dreipunkt.
//
// Ein Dreipunkt ist eine Liste von drei Zahlen.
public class Dreipunkt {

    // Die Orten dieses Dreipunktes.
    public double xteil;
    public double yteil;
    public double zteil;

    public Dreipunkt(double x, double y, double z) {
	this.xteil = x;
	this.yteil = y;
	this.zteil = z;
    }

    // Addiere die Zahlen zu diesem Dreipunkt p.
    public void addieren(Dreipunkt p) {
	this.xteil += p.xteil;
	this.yteil += p.yteil;
	this.zteil += p.zteil;
    }
}
