package verschieber;

import punkt.Dreipunkt;
import punkt.Zweipunkt;
import strecke.Zweistrecke;
import verdoppler.strecke.Streckeverdoppler;
import welt.vieleck.Vieleckwelt;
import welt.vielflach.Vielflachwelt;
import welt.zweistrecke.Zweistreckewelt;

// Ein Verschieber verschiebt einfach alle Punkten einer Welt.
public class Verschieber {

    // ein: Zweistrecke, Double, Double
    public static void verschiebenStrecke(Zweistrecke zk, double dx, double dy) {
	Zweipunkt von = zk.von;
	Zweipunkt bis = zk.bis;
	
	zk.von.xteil = (int) (zk.von.xteil + dx);
	zk.von.yteil = (int) (zk.von.yteil + dy);
	
	zk.bis.xteil = (int) (zk.bis.xteil + dx);
	zk.bis.yteil = (int) (zk.bis.yteil + dy);
    }

    // ein: Vieleckwelt, Zweipunkt
    //
    // Verlegen die zweidimensionale Vieleckwelt zu einer
    // gleichen Welt, mit alle Orten verschoben.
    public static void verschieben(Vieleckwelt welt,
				   Zweipunkt verschiebenpunkt) {

	// Für jeden Orten der Welt, addiere zu ihm den Verschiebenpunkt.
	for (int i = 0; i < welt.ortliste.size(); i++) {
	    welt.ortliste.get(i).addieren(verschiebenpunkt);
	}
    }

    // ein: Zweistreckewelt, Double, Double
    public static Zweistreckewelt verschieben(Zweistreckewelt zsw,
					      double dx,
					      double dy) {
	
	Zweistrecke[] zsl = zsw.streckenliste;
	Zweistrecke[] zslNeu = Streckeverdoppler.verdoppeln(zsl);
	
	for (int i = 0; i < zsl.length; i++) {
	    Verschieber.verschiebenStrecke(zslNeu[i], dx, dy);
	}
	
	return new Zweistreckewelt(zslNeu);
    }

    // ein: Vielflachwelt, Dreipunkt
    //
    // Verlegen die dreidimensionale Vielflachwelt zu einer
    // zweidimensionale Zweistreckewelt.
    //
    public static void verschieben(Vielflachwelt welt,
				   Dreipunkt verschiebenpunkt) {

	// Für jeden Orten der Welt, addiere zu ihm den Verschiebenpunkt.
	
	for (int i = 0; i < welt.ortliste.size(); i++) {
	    welt.ortliste.get(i).addieren(verschiebenpunkt);
	}
    }
}
