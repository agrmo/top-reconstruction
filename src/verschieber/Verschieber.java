package verschieber;

import punkt.Dreipunkt;
import punkt.Zweipunkt;
import welt.koerper.Koerperwelt;
import welt.figur.Figurwelt;
import figur.Figur;

// Ein Verschieber nimmt eine dreidimensionale Körperwelt zu
// der gleichen Art, aber mit alle Punkten verschoben.
public class Verschieber {

    public Verschieber() {
	
    }

    // ein: Körperwelt, Dreipunkt
    //
    // Verlegen die dreidimensionale Körperwelt zu einer
    // zweidimensionale Zweikantewelt.
    //
    public static void verschieben(Koerperwelt kw,
				   Dreipunkt verschiebenpunkt) {

	// Für jeden Orten der Welt, addiere zu ihm den Verschiebenpunkt.
	
	for (int i = 0; i < kw.ortliste.size(); i++) {
	    kw.ortliste.get(i).addieren(verschiebenpunkt);
	}
    }

    // ein: Figurwelt, Zweipunkt
    //
    // Verlegen die zweidimensionale Figurwelt zu einer
    // gleichen Welt, mit alle Orten verschoben.
    public static void verschieben(Figurwelt fw,
				   Zweipunkt verschiebenpunkt) {
	// Für jeden Orten der Welt, addiere zu ihm den Verschiebenpunkt.

	for (int i = 0; i < fw.ortliste.size(); i++) {
	    fw.ortliste.get(i).addieren(verschiebenpunkt);
	}
    }
}
