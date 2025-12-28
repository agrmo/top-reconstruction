package verleger.linear;

import java.util.ArrayList;
import punkt.Zweipunkt;
import kante.Zweikante;
import welt.kante.Zweikantewelt;

// Ein Linearverleger verhält sich wie ein Fenster. Er nimmt eine
// zweidimensionale Kantewelt und verschiebt alle Punkten wie die
// gleichung:
//
// x' = x * m_x + b_x
// y' = y * m_y + b_y
//
public class Linearverleger {

    // Die zweidimensionale Welt mit den ursprünglichen Daten.
    Zweikantewelt zweikantewelt;

    // Die Verschiebungzahlen.
    double mx;
    double bx;
    double my;
    double by;

    public Linearverleger(Zweikantewelt zkw,
			  double mx, double bx,
			  double my, double by) {
	this.zweikantewelt = zkw;
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
	zk.bis.eins = (int) (zk.bis.eins * mx + bx);
	zk.von.zwei = (int) (zk.von.zwei * my + by);
	zk.bis.zwei = (int) (zk.bis.zwei * my + by);
    }

    // Verlegen die Welt.
    public void verlegenWelt() {

	ArrayList<Zweikante> zkl = this.zweikantewelt.kantenliste;

	for (int i = 0; i < zkl.size(); i++) {
	    Zweikante zk = zkl.get(i);
	    this.verlegenKante(zk);
	    
	    // Die Kante ist selbst bearbeitet.
	}
    }
}
