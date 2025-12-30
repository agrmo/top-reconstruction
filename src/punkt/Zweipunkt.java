package punkt;

// Der Zweipunkt.
//
// Ein Zweipunkt ist eine Liste von zwei ganzen Zahlen.
public class Zweipunkt {

    // Die Orten dieses Zweipunktes.
    public int eins;
    public int zwei;

    public Zweipunkt(int e, int z) {
	this.eins = e;
	this.zwei = z;
    }

    // Addiere die Zahlen zu diesem Zweipunkt p.
    public void addieren(Zweipunkt p) {
	this.eins += p.eins;
	this.zwei += p.zwei;
    }
}
