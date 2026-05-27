package verschieber;

import vektor.Dreivektor;
import vektor.Zweivektor;
import strecke.Zweistrecke;
import verdoppler.strecke.Streckeverdoppler;
import welt.vieleck.Vieleckwelt;
import welt.vielflach.Vielflachwelt;
import welt.strecke.zwei.Zweistreckewelt;

// Ein Verschieber verschiebt einfach alle Vektoren einer Welt.
public class Verschieber {

    // ein: Zweistrecke, Double, Double
    public static void verschiebe(Zweistrecke zs, double dx, double dy) {
	Zweivektor von = zs.von;
	Zweivektor bis = zs.bis;
	
	zs.von.eins = (int) (zs.von.eins + dx);
	zs.von.zwei = (int) (zs.von.zwei + dy);
	
	zs.bis.eins = (int) (zs.bis.eins + dx);
	zs.bis.zwei = (int) (zs.bis.zwei + dy);
    }

    // ein: Vieleckwelt, Zweivektor
    //
    // Verlegen die zweidimensionale Vieleckwelt zu einer
    // gleichen Welt, mit alle Orten verschoben.
    public static void verschiebe(Vieleckwelt welt,
				  Zweivektor verschiebenvektor) {

	// Für jeden Orten der Welt, addiere zu ihm den Verschiebenvektor.
	for (int i = 0; i < welt.ortliste.length; i++) {
	    welt.ortliste[i].addiere(verschiebenvektor);
	}
    }

    // ein: Zweistreckewelt, Double, Double
    public static Zweistreckewelt verschiebe(Zweistreckewelt zsw,
					     double dx,
					     double dy) {
	
	Zweistrecke[] zsl = zsw.strecken;
	Zweistrecke[] zslNeu = Streckeverdoppler.verdoppele(zsl);
	
	for (int i = 0; i < zsl.length; i++) {
	    Verschieber.verschiebe(zslNeu[i], dx, dy);
	}
	
	return new Zweistreckewelt(zslNeu);
    }

    // ein: Vielflachwelt, Dreivektor
    //
    // Verlegen die dreidimensionale Vielflachwelt zu einer
    // zweidimensionale Zweistreckewelt.
    //
    public static void verschiebe(Vielflachwelt welt,
				  Dreivektor verschiebenvektor) {

	// Für jeden Orten der Welt, addiere zu ihm den Verschiebenvektor.
	
	for (int i = 0; i < welt.stellungen.length; i++) {
	    welt.stellungen[i].ort.addiere(verschiebenvektor);
	}
    }
}
