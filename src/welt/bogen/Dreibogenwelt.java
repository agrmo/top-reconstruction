package welt.bogen;

import bogen.Bogen;
import vektor.Dreivektor;
import stellung.Dreistellung;

public class Dreibogenwelt {

    public Bogen[] bogen;
    public Dreistellung[] stellungen;

    public Dreibogenwelt(Bogen[] bogen, Dreistellung[] stellungen) {
	this.bogen = bogen;
	this.stellungen = stellungen;
    }
}
