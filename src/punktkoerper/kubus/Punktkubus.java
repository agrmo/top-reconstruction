package punktkoerper.kubus;

import punktkoerper.Punktkoerper;
import koerper.Koerper;
import koerper.kubus.Kubus;
import punkt.Punkt;
import kante.Kante;

// Ein Punktkubus ist ein Kubus, der die Orten seine Kanten und Ecken
// berechnen kann. Er kennt seinen Ort.
public class Punktkubus extends Punktkoerper {

    // Dieser Kubus.
    public Kubus kubus;

    // Der Ort dieses Körpers
    public Punkt punkt;
    
    public Punktkubus(Kubus k, Punkt p) {
	this.kubus = k;
	this.punkt = p;
    }

    public Kante[] nehmeKanten() {

	Kante[] kl = this.kubus.nehmeKanten();

	for (int i = 0; i < kl.length; i++) {
	    kl[i].addieren(this.punkt);
	}

	return kl;

	// Ganz schwer zu verstehen ist, ob ich erlaubt bin, die
	// ursprüngliche Daten des Körpers zu verändern. Welche
	// Variablen sind veränderlich, welche unveränderlich?
    }
}
