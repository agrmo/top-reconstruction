package basis;

import vektor.Vektor;

// Eine Basis ist eine Liste von drei Vektoren, die alle den Betrag Eins haben.
public class Basis {
    public Vektor eins;
    public Vektor zwei;
    public Vektor drei;

    // ein: Vektor, Vektor, Vektor
    public Basis(Vektor eins, Vektor zwei, Vektor drei) {
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
