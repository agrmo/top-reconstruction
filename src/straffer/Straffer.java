package straffer;

import java.util.ArrayList;
import punkt.Zweipunkt;
import strecke.Zweistrecke;
import welt.zweistrecke.Zweistreckewelt;
import verdoppler.strecke.Streckeverdoppler;

// Ein Straffer strafft und quetscht die Stellen der Welt nach den
// Gleichungen,
//
// x' = x * m_x
// y' = y * m_y
//
// Schwierig ist die Frage, ob man die Daten verdoppeln soll, oder nur
// inhaltlich in der gleichen Welt bearbeiten.
public class Straffer {

    // Straffen die Strecke nach den Gleichungen.
    static void straffenStrecke(Zweistrecke zk,
				double mx, double my) {
	
	Zweipunkt von = zk.von;
	Zweipunkt bis = zk.bis;

	zk.von.xteil = (int) (zk.von.xteil * mx);
	zk.von.yteil = (int) (zk.von.yteil * my);
	
	zk.bis.xteil = (int) (zk.bis.xteil * mx);
	zk.bis.yteil = (int) (zk.bis.yteil * my);
    }

    // Straffen die Welt.
    // ein: Zweistreckewelt
    // aus: Zweistreckewelt
    public static Zweistreckewelt straffenWelt(Zweistreckewelt zkw,
					       double mx,
					       double my) {

	ArrayList<Zweistrecke> zsl = zkw.streckenliste;
	ArrayList<Zweistrecke> zslNeu = Streckeverdoppler.verdoppeln(zsl);

	for (int i = 0; i < zsl.size(); i++) {
	    Straffer.straffenStrecke(zslNeu.get(i), mx, my);
	}

	return new Zweistreckewelt(zslNeu);
    }
}
