package basis;

import vektor.Dreivektor;

// Eine Basis ist eine Liste von drei Dreivektoren, die alle den Betrag Eins besitzen.
public class Dreibasis {
    public Dreivektor eins;
    public Dreivektor zwei;
    public Dreivektor drei;

    // ein: Dreivektor, Dreivektor, Dreivektor
    public Dreibasis(Dreivektor eins, Dreivektor zwei, Dreivektor drei) {
	this.eins = eins;
	this.zwei = zwei;
	this.drei = drei;
    }

    // Mache ein String dieser Basis.
    public String drucken() {
	StringBuilder sb = new StringBuilder();
	sb.append("[");
	sb.append(this.eins.drucken());
	sb.append(",");
	sb.append(this.zwei.drucken());
	sb.append(",");
	sb.append(this.drei.drucken());
	sb.append("]");
	return sb.toString();
    }
}
