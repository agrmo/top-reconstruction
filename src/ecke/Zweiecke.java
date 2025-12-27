package ecke;

import java.util.ArrayList;
import vektor.Zweivektor;
import punkt.Zweipunkt;

// Die Ecke. Sie ist ein Begriff im Bereich der euklidschen Welt.
// 
// Eine Ecke ist eine Menge von:
// - Zweipunkt
// - Liste von Zweivektor
//
// Die Ecke kennt seine Stelle im Euklidraum. Eine Ecke konnte
// verschiedene Kanten besitzen. Die Kanten gehen geradeaus von ihr,
// für eine bestimmte Länge. Die Kanten sind immer geradlinig. Eine
// Kante kann genau auf einer Achse liegen, oder nicht. Derselbe
// Ursprung der Kanten liegt genau auf dem Ortsvektor.
// Eine Zweiecke ist eine Menge von
// - Zweipunkt
// - Liste von Zweivektoren
//
// Eine Zweicke ist eine dreidimensionale Ecke, die eine Stelle und
// einige Kanten besitzt. Die Kanten sind als Vektoren gezeigt, weil
// den Ursprung ist schon einfach bestimmt.
public class Zweiecke {

    public Zweipunkt punkt;

    public ArrayList<Zweivektor> kanten;

    public Zweiecke(Zweipunkt p, ArrayList<Zweivektor> k) {
	this.punkt = p;
	this.kanten = k;
    }
}
