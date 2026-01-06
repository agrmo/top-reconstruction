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
// verschiedene Strecken besitzen. Die Strecken gehen geradeaus von ihr,
// für eine bestimmte Länge. Die Strecken sind immer geradlinig. Eine
// Strecke kann genau auf einer Achse liegen, oder nicht. Derselbe
// Ursprung der Strecken liegt genau auf dem Ortsvektor.
// Eine Zweiecke ist eine Menge von
// - Zweipunkt
// - Liste von Zweivektoren
//
// Eine Zweicke ist eine dreidimensionale Ecke, die eine Stelle und
// einige Strecken besitzt. Die Strecken sind als Vektoren gezeigt, weil
// den Ursprung ist schon einfach bestimmt.
public class Zweiecke {

    public Zweipunkt punkt;

    public ArrayList<Zweivektor> strecken;

    public Zweiecke(Zweipunkt p, ArrayList<Zweivektor> k) {
	this.punkt = p;
	this.strecken = k;
    }
}
