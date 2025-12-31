package punkt;

// Der Dreipunkt.
//
// Ein Dreipunkt ist eine Liste von drei ganzen Zahlen.
public class Dreipunkt {

    // Die Orten dieses Dreipunktes.
    public int eins;
    public int zwei;
    public int drei;

    public Dreipunkt(int e, int z, int d) {
	this.eins = e;
	this.zwei = z;
	this.drei = d;
    }

    // Addiere die Zahlen zu diesem Dreipunkt p.
    public void addieren(Dreipunkt p) {
	this.eins += p.eins;
	this.zwei += p.zwei;
	this.drei += p.drei;
	// System.out.println(this.eins + " " + this.zwei + " " + this.drei);
    }
}
