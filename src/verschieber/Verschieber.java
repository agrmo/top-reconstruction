package verschieber;

import vektor.Dreivektor;
import vektor.Zweivektor;
import strecke.Zweistrecke;
import verdoppler.strecke.Streckeverdoppler;
import welt.vieleck.Vieleckwelt;
import welt.vielflach.Vielflachwelt;
import welt.zweistrecke.Zweistreckewelt;

// Ein Verschieber verschiebt einfach alle Vektoren einer Welt.
public class Verschieber {

    // ein: Zweistrecke, Double, Double
    public static void verschiebenStrecke(Zweistrecke zk, double dx, double dy) {
	Zweivektor von = zk.von;
	Zweivektor bis = zk.bis;
	
	zk.von.eins = (int) (zk.von.eins + dx);
	zk.von.zwei = (int) (zk.von.zwei + dy);
	
	zk.bis.eins = (int) (zk.bis.eins + dx);
	zk.bis.zwei = (int) (zk.bis.zwei + dy);
    }

    // ein: Vieleckwelt, Zweivektor
    //
    // Verlegen die zweidimensionale Vieleckwelt zu einer
    // gleichen Welt, mit alle Orten verschoben.
    public static void verschieben(Vieleckwelt welt,
				   Zweivektor verschiebenvektor) {

	// Für jeden Orten der Welt, addiere zu ihm den Verschiebenvektor.
	for (int i = 0; i < welt.ortliste.size(); i++) {
	    welt.ortliste.get(i).addiere(verschiebenvektor);
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

    // ein: Vielflachwelt, Dreivektor
    //
    // Verlegen die dreidimensionale Vielflachwelt zu einer
    // zweidimensionale Zweistreckewelt.
    //
    public static void verschieben(Vielflachwelt welt,
				   Dreivektor verschiebenvektor) {

	// Für jeden Orten der Welt, addiere zu ihm den Verschiebenvektor.
	
	for (int i = 0; i < welt.ortliste.size(); i++) {
	    welt.ortliste.get(i).addiere(verschiebenvektor);
	}
    }
}
