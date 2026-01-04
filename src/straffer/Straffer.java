package straffer;

import java.util.ArrayList;
import punkt.Zweipunkt;
import kante.Zweikante;
import welt.zweikante.Zweikantewelt;
import verdoppler.kante.Kanteverdoppler;

// Ein Straffer strafft und quetscht die Stellen der Welt nach den
// Gleichungen,
//
// x' = x * m_x
// y' = y * m_y
//
// Schwierig ist die Frage, ob man die Daten verdoppeln soll, oder nur
// inhaltlich in der gleichen Welt bearbeiten.
public class Straffer {

    // Straffen die Kante nach den Gleichungen.
    static void straffenKante(Zweikante zk,
			      double mx, double my) {
	
	Zweipunkt von = zk.von;
	Zweipunkt bis = zk.bis;

	zk.von.xteil = (int) (zk.von.xteil * mx);
	zk.von.yteil = (int) (zk.von.yteil * my);
	
	zk.bis.xteil = (int) (zk.bis.xteil * mx);
	zk.bis.yteil = (int) (zk.bis.yteil * my);
    }

    // Straffen die Welt.
    // ein: Zweikantewelt
    // aus: Zweikantewelt
    public static Zweikantewelt straffenWelt(Zweikantewelt zkw,
					     double mx,
					     double my) {

	ArrayList<Zweikante> zkl = zkw.kantenliste;
	ArrayList<Zweikante> zklNeu = Kanteverdoppler.verdoppeln(zkl);

	for (int i = 0; i < zkl.size(); i++) {
	    Straffer.straffenKante(zklNeu.get(i), mx, my);
	}

	return new Zweikantewelt(zklNeu);
    }
}
