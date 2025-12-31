package verleger.verschieben;

import punkt.Dreipunkt;
import welt.koerper.Koerperwelt;

// Ein Verschiebenverleger nimmt eine dreidimensionale Körperwelt zu
// der gleichen Art, aber mit alle Punkten verschoben.
public class Verschiebenverleger {

    public Verschiebenverleger() {
	
    }

    // ein: Körperwelt, Dreipunkt
    //
    // Verlegen die dreidimensionale Körperwelt zu einer
    // zweidimensionale Zweikantewelt.
    //
    public static void verlegenWelt(Koerperwelt kw,
				    Dreipunkt verschiebenpunkt) {

	// Für jeden Orten der Welt, addiere zu ihm den Verschiebenpunkt.
	
	for (int i = 0; i < kw.ortliste.size(); i++) {
	    kw.ortliste.get(i).addieren(verschiebenpunkt);
	}
    }
}
