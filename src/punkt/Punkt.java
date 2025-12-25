package punkt;

// Der Punkt.
//
// Ein Punkt ist eine Liste von ganzen Zahlen.
public class Punkt {

    // Die Orten dieses Punktes.
    public int eins;
    public int zwei;
    public int drei;

    public Punkt(int e, int z, int d) {
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
}
