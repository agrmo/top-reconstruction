package verschieber;

import java.util.ArrayList;
import punkt.Dreipunkt;
import punkt.Zweipunkt;
import welt.koerper.Koerperwelt;
import welt.figur.Figurwelt;
import figur.Figur;
import verdoppler.kante.Kanteverdoppler;
import welt.zweikante.Zweikantewelt;
import kante.Zweikante;

// Ein Verschieber nimmt eine dreidimensionale Körperwelt zu
// der gleichen Art, aber mit alle Punkten verschoben.
public class Verschieber {

    public Verschieber() {
	
    }
    
    // ein: Zweikante, Double, Double
    public static void verschiebenKante(Zweikante zk, double dx, double dy) {
	Zweipunkt von = zk.von;
	Zweipunkt bis = zk.bis;
	
	zk.von.eins = (int) (zk.von.eins + dx);
	zk.von.zwei = (int) (zk.von.zwei + dy);
	
	zk.bis.eins = (int) (zk.bis.eins + dx);
	zk.bis.zwei = (int) (zk.bis.zwei + dy);
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

    // ein: Zweikantewelt, Double, Double
    public static Zweikantewelt verschieben(Zweikantewelt zkw,
					    double dx,
					    double dy) {
	
	ArrayList<Zweikante> zkl = zkw.kantenliste;
	ArrayList<Zweikante> zklNeu = Kanteverdoppler.verdoppeln(zkl);
	
	for (int i = 0; i < zkl.size(); i++) {
	    Verschieber.verschiebenKante(zklNeu.get(i), dx, dy);
	}
	
	return new Zweikantewelt(zklNeu);
    }
}
