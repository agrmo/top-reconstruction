package welt.euklid.koerper.kubus;

import welt.euklid.koerper.Euklidkoerper;
import koerper.Koerper;
import koerper.kubus.Kubus;
import vektor.Vektor;

// Ein Euklidkubus ist ein Kubus, der die Orten seine Kanten und Ecken
// berechnen kann. Er kennt seinen Ort.
public class Euklidkubus {
    
    public Kubus kubus;
    public Vektor ort;

    public Euklidkubus(Kubus k, Vektor o) {
	this.kubus = k;
	this.ort = o;
    }
}
