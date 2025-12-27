package ecke;

import java.util.ArrayList;
import vektor.Dreivektor;
import punkt.Punkt;

// Die Ecke. Sie ist ein Begriff im Bereich der euklidschen Welt.
// 
// Eine Ecke ist eine Menge von:
// - Punkt
// - Liste von Dreivektor
//
// Die Ecke kennt seine Stelle im Euklidraum. Eine Ecke konnte
// verschiedene Kanten besitzen. Die Kanten gehen geradeaus von ihr,
// für eine bestimmte Länge. Die Kanten sind immer geradlinig. Eine
// Kante kann genau auf einer Achse liegen, oder nicht. Derselbe
// Ursprung der Kanten liegt genau auf dem Ortsvektor.
// Eine Dreiecke ist eine Menge von
// - Dreipunkt
// - Liste von Dreivektoren
//
// Eine Dreicke ist eine dreidimensionale Ecke, die eine Stelle und
// einige Kanten besitzt. Die Kanten sind als Vektoren gezeigt, weil
// den Ursprung ist schon einfach bestimmt.
public class Dreiecke {

    public Punkt punkt;

    public ArrayList<Dreivektor> kanten;

    public Dreiecke(Punkt p, ArrayList<Dreivektor> k) {
	this.punkt = p;
	this.kanten = k;
    }
}
