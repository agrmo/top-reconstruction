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
    
    public Punktkubus(Kubus k, Dreipunkt p) {
	this.punkt = p;
	this.kubus = k;
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

    public String drucken() {
	StringBuilder sb = new StringBuilder();
	sb.append("Punktkubus:\n");
	sb.append(this.punkt.drucken());
	sb.append(this.kubus.drucken());
	return sb.toString();
    }
}
