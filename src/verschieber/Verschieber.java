package verschieber;

import java.util.ArrayList;
import punkt.Dreipunkt;
import punkt.Zweipunkt;
import welt.koerper.Koerperwelt;
import welt.figur.Figurwelt;
import figur.Figur;
import verdoppler.strecke.Streckeverdoppler;
import welt.zweistrecke.Zweistreckewelt;
import strecke.Zweistrecke;

// Ein Verschieber nimmt eine dreidimensionale Körperwelt zu
// der gleichen Art, aber mit alle Punkten verschoben.
public class Verschieber {

    public Verschieber() {
	
    }
    
    // ein: Zweistrecke, Double, Double
    public static void verschiebenStrecke(Zweistrecke zk, double dx, double dy) {
	Zweipunkt von = zk.von;
	Zweipunkt bis = zk.bis;
	
	zk.von.xteil = (int) (zk.von.xteil + dx);
	zk.von.yteil = (int) (zk.von.yteil + dy);
	
	zk.bis.xteil = (int) (zk.bis.xteil + dx);
	zk.bis.yteil = (int) (zk.bis.yteil + dy);
    }
    
    // ein: Körperwelt, Dreipunkt
    //
    // Verlegen die dreidimensionale Körperwelt zu einer
    // zweidimensionale Zweistreckewelt.
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

    // ein: Zweistreckewelt, Double, Double
    public static Zweistreckewelt verschieben(Zweistreckewelt zkw,
					      double dx,
					      double dy) {
	
	Zweistrecke[] zsl = zkw.streckenliste;
	Zweistrecke[] zslNeu = Streckeverdoppler.verdoppeln(zsl);
	
	for (int i = 0; i < zsl.length; i++) {
	    Verschieber.verschiebenStrecke(zslNeu[i], dx, dy);
	}
	
	return new Zweistreckewelt(zslNeu);
    }
}
