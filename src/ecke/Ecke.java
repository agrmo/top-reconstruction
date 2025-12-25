package ecke;

import java.util.ArrayList;
import vektor.Vektor;
import punkt.Punkt;

// Die Ecke. Sie ist ein Begriff im Bereich der euklidschen Welt.
// 
// Eine Ecke ist eine Menge von:
// - Punkt
// - Liste von Vektor
//
// Die Ecke kennt seine Stelle im Euklidraum. Eine Ecke konnte
// verschiedene Kanten besitzen. Die Kanten gehen geradeaus von ihr,
// für eine bestimmte Länge. Die Kanten sind immer geradlinig. Eine
// Kante kann genau auf einer Achse liegen, oder nicht. Derselbe
// Ursprung der Kanten liegt genau auf dem Ortsvektor.
public class Ecke {

    public Punkt punkt;

    public ArrayList<Vektor> kanten;

    public Ecke(Punkt p, ArrayList<Vektor> k) {
	this.punkt = p;
	this.kanten = k;
    }
}
