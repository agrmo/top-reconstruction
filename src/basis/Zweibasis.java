package basis;

import vektor.Zweivektor;

// Eine Basis ist eine Liste von zwei Zweivektoren, die alle den Betrag Eins besitzen.
public class Zweibasis {
    public Zweivektor eins;
    public Zweivektor zwei;

    // ein: Zweivektor, Zweivektor
    public Zweibasis(Zweivektor eins, Zweivektor zwei) {
	this.eins = eins;
	this.zwei = zwei;
    }

    // Mache ein String dieser Basis.
    public String drucken() {
	StringBuilder sb = new StringBuilder();
	sb.append("[");
	sb.append(this.eins.drucken());
	sb.append(",");
	sb.append(this.zwei.drucken());
	sb.append("]");
	return sb.toString();
    }
}
