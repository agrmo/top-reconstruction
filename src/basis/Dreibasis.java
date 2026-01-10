package basis;

import punkt.Dreipunkt;

// Eine Basis ist eine Liste von drei Punkten, die alle den Betrag
// Eins besitzen.
public class Dreibasis {
    public Dreipunkt eins;
    public Dreipunkt zwei;
    public Dreipunkt drei;

    // ein: Dreipunkt, Dreipunkt, Dreipunkt
    public Dreibasis(Dreipunkt eins, Dreipunkt zwei, Dreipunkt drei) {
	this.eins = eins;
	this.zwei = zwei;
	this.drei = drei;
    }
}
