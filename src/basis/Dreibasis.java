package basis;

import vektor.Dreivektor;

// Eine Basis ist eine Liste von drei Vektoren, die alle den Betrag
// Eins besitzen.
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
}
