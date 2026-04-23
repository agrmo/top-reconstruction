package welt.kreis;

import vektor.Zweivektor;
import figur.kreis.Kreis;

public class Kreiswelt {

    public Kreis[] kreise;
    public Zweivektor[] orte;

    public Kreiswelt(Kreis[] kreise, Zweivektor[] orte) {
	this.kreise = kreise;
	this.orte = orte;
    }
}
