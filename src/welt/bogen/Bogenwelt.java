package welt.bogen;

import bogen.Bogen;
import vektor.Dreivektor;

public class Bogenwelt {

    public Bogen[] bogen;
    public Dreivektor[] orten;

    public Bogenwelt(Bogen[] bl, Dreivektor[] ol) {
	this.bogen = bl;
	this.orten = ol;
    }
}
