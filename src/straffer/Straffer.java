package straffer;

import java.util.ArrayList;
import vektor.Zweivektor;
import strecke.Zweistrecke;
import welt.strecke.Zweistreckewelt;
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
    static void straffenStrecke(Zweistrecke zs,
				double mx, double my) {
	
	Zweivektor von = zs.von;
	Zweivektor bis = zs.bis;

	zs.von.eins = (int) (zs.von.eins * mx);
	zs.von.zwei = (int) (zs.von.zwei * my);
	
	zs.bis.eins = (int) (zs.bis.eins * mx);
	zs.bis.zwei = (int) (zs.bis.zwei * my);
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
