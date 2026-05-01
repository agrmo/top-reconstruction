package vektor.fort.drei;

import vektor.Dreivektor;
import verdoppler.vektor.Vektorverdoppler;

// Baue einen neuen Vektor in der gleichen Richtung als der gegebene
// Vektor. Das heißt ein "fortbewegender Vektor" oder "Fortvektor."
//
// Die Vorgehensweise ist anders als in Dreifortvektor.
// 1. Nehme den Betrag des gegebenen Vektors = b1
// 2. Multipliziere den Vektor mit (b/b1).
// 3. Fertig
public class Dreifortvektor {

    // va: Der gegebene Vektor
    // betrag: Betrag des ausgehenden Vektors
    public static Dreivektor mache(Dreivektor va, double betrag) {

	double betraga = va.betrag();
	Dreivektor vb = Vektorverdoppler.verdoppeln(va);
	vb.multipliziere(betrag / betraga);
	
	return vb;
    }
}
