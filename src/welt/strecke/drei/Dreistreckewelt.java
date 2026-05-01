package welt.strecke.drei;
    
import welt.Welt;
import strecke.Dreistrecke;

/*
  Eine Dreistreckewelt ist eine Liste von dreidimensionalen Strecken.
*/
public class Dreistreckewelt {
    public Dreistrecke[] streckenliste;

    public Dreistreckewelt(Dreistrecke[] dsl) {
	this.streckenliste = dsl;
    }
}
