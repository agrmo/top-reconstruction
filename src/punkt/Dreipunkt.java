package punkt;

// Der Dreipunkt.
//
// Ein Dreipunkt ist eine Liste von drei ganzen Zahlen.
public class Dreipunkt {

    // Die Orten dieses Dreipunktes.
    public double eins;
    public double zwei;
    public double drei;

    public Dreipunkt(double e, double z, double d) {
	this.eins = e;
	this.zwei = z;
	this.drei = d;
    }

    // Addiere die Zahlen zu diesem Dreipunkt p.
    public void addieren(Dreipunkt p) {
	this.eins += p.eins;
	this.zwei += p.zwei;
	this.drei += p.drei;
    }
}
