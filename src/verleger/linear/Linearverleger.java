package verleger.linear;

import java.util.ArrayList;
import punkt.Zweipunkt;
import kante.Zweikante;
import welt.kante.Zweikantewelt;
import verdoppler.kante.Kanteverdoppler;

// Dieser Verleger verhält sich wie ein Fenster. Er nimmt eine
// zweidimensionale Kantewelt und verschiebt alle Punkten wie die
// gleichung:
//
// x' = x * m_x + b_x
// y' = y * m_y + b_y
//
// Schwierig ist die Frage, ob man die Daten verdoppeln soll, oder nur
// inhaltlich in der gleichen Welt bearbeiten.
public class Linearverleger {

    // Die Verschiebungzahlen.
    public double mx;
    public double bx;
    public double my;
    public double by;

    public Linearverleger(double mx, double bx, double my, double by) {
	this.mx = mx;
	this.bx = bx;
	this.my = my;
	this.by = by;
    }

    // Verlegen die Kante nach den Gleichungen.
    void verlegenKante(Zweikante zk) {
	Zweipunkt von = zk.von;
	Zweipunkt bis = zk.bis;

	zk.von.eins = (int) (zk.von.eins * mx + bx);
	zk.von.zwei = (int) (zk.von.zwei * my + by);
	
	zk.bis.eins = (int) (zk.bis.eins * mx + bx);
	zk.bis.zwei = (int) (zk.bis.zwei * my + by);
    }

    // Verlegen die Welt.
    // ein: Zweikantewelt
    // aus: Zweikantewelt
    public Zweikantewelt verlegenWelt(Zweikantewelt zkw) {

	ArrayList<Zweikante> zkl = zkw.kantenliste;
	ArrayList<Zweikante> zklNeu = Kanteverdoppler.verdoppeln(zkl);

	for (int i = 0; i < zkl.size(); i++) {
	    this.verlegenKante(zklNeu.get(i));
	}

	return new Zweikantewelt(zklNeu);
    }
}
