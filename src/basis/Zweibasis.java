package basis;

import punkt.Zweipunkt;

// Eine Basis ist eine Liste von zwei Punkten, die alle den Betrag
// Eins besitzen.
public class Zweibasis {
    public Zweipunkt eins;
    public Zweipunkt zwei;

    // ein: Zweipunkt, Zweipunkt
    public Zweibasis(Zweipunkt eins, Zweipunkt zwei) {
	this.eins = eins;
	this.zwei = zwei;
    }
}
