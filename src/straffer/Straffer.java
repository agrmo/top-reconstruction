package straffer;

import java.util.ArrayList;
import vektor.Zweivektor;
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
	
	Zweivektor von = zk.von;
	Zweivektor bis = zk.bis;

	zk.von.eins = (int) (zk.von.eins * mx);
	zk.von.zwei = (int) (zk.von.zwei * my);
	
	zk.bis.eins = (int) (zk.bis.eins * mx);
	zk.bis.zwei = (int) (zk.bis.zwei * my);
    }

    // Straffen die Welt.
    // ein: Zweistreckewelt
    // aus: Zweistreckewelt
    public static Zweistreckewelt straffenWelt(Zweistreckewelt zsw,
					       double mx,
					       double my) {

	Zweistrecke[] zsl = zsw.streckenliste;
	Zweistrecke[] zslNeu = Streckeverdoppler.verdoppeln(zsl);

	for (int i = 0; i < zsl.length; i++) {
	    Straffer.straffenStrecke(zslNeu[i], mx, my);
	}

	return new Zweistreckewelt(zslNeu);
    }
}
