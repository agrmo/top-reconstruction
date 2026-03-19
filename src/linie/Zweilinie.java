package linie;

import vektor.Zweivektor;

// Eine Linie ist eine Linie ohne festgelegte Endpunkte.  Verlängt man
// eine Strecke unendlich über beide Endpunkte hinaus, entsteht eine
// Gerade.
public class Zweilinie {
    public Zweivektor von;
    public Zweivektor bis;
    
    public Zweilinie(Zweivektor v, Zweivektor b) {
	this.von = v;
	this.bis = b;
    }
}
