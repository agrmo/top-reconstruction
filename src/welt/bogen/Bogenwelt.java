package welt.bogen;

import bogen.Bogen;
import vektor.Dreivektor;

public class Bogenwelt {

    public Bogen[] bogen;
    public Dreivektor[] orte;

    public Bogenwelt(Bogen[] bogen, Dreivektor[] orte) {
	this.bogen = bogen;
	this.orte = orte;
    }
}
