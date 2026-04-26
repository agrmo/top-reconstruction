package verschieber;

import vektor.Dreivektor;
import vektor.Zweivektor;
import strecke.Zweistrecke;
import verdoppler.strecke.Streckeverdoppler;
import welt.vieleck.Vieleckwelt;
import welt.vielflach.Vielflachwelt;
import welt.strecke.Zweistreckewelt;

// Ein Verschieber verschiebt einfach alle Vektoren einer Welt.
public class Verschieber {

    // ein: Zweistrecke, Double, Double
    public static void verschiebenStrecke(Zweistrecke zs, double dx, double dy) {
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
    public static void verschieben(Vieleckwelt welt,
				   Zweivektor verschiebenvektor) {

	// Für jeden Orten der Welt, addiere zu ihm den Verschiebenvektor.
	for (int i = 0; i < welt.ortliste.length; i++) {
	    welt.ortliste[i].addiere(verschiebenvektor);
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
	
	for (int i = 0; i < welt.stellungen.length; i++) {
	    welt.stellungen[i].ort.addiere(verschiebenvektor);
	}
    }
}
