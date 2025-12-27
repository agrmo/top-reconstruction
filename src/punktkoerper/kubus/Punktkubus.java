package punktkoerper.kubus;

import punktkoerper.Punktkoerper;
import koerper.Koerper;
import koerper.kubus.Kubus;
import punkt.Dreipunkt;
import kante.Dreikante;

// Ein Punktkubus ist ein Kubus, der die Orten seine Kanten und Ecken
// berechnen kann. Er kennt seinen Ort.
public class Punktkubus extends Punktkoerper {

    // Dieser Kubus.
    public Kubus kubus;

    // Der Ort dieses Körpers
    public Dreipunkt punkt;
    
    public Punktkubus(Kubus k, Dreipunkt p) {
	this.kubus = k;
	this.punkt = p;
    }

    public Dreikante[] nehmeKanten() {

	Dreikante[] kl = this.kubus.nehmeKanten();

	for (int i = 0; i < kl.length; i++) {
	    kl[i].addieren(this.punkt);
	}

	return kl;

	// Ganz schwer zu verstehen ist, ob ich erlaubt bin, die
	// ursprüngliche Daten des Körpers zu verändern. Welche
	// Variablen sind veränderlich, welche unveränderlich?
    }
}
