package punkt;

// Der Dreipunkt.
//
// Ein Dreipunkt ist eine Liste von ganzen Zahlen.
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

    public String drucken() {
	StringBuilder sb = new StringBuilder();
	sb.append("[");
	sb.append(this.eins);
	sb.append(",");
	sb.append(this.zwei);
	sb.append(",");
	sb.append(this.drei);
	sb.append("]");
	return sb.toString();
    }

    // Addiere die Zahlen zu diesem Dreipunkt p.
    public void addieren(Dreipunkt p) {
	this.eins += p.eins;
	this.zwei += p.zwei;
	this.drei += p.drei;
    }
}
