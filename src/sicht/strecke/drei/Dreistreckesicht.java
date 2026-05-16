package sicht.strecke.drei;

import auge.Auge;
import java.awt.Graphics;
import javax.swing.JComponent;
import matrix.Dreimatrix;
import sicht.Sicht;
import sicht.strecke.zwei.Zweistreckesicht;
import strecke.Dreistrecke;
import strecke.Zweistrecke;
import verleger.strecke.Streckeverleger;
import welt.strecke.drei.Dreistreckewelt;
import welt.strecke.zwei.Zweistreckewelt;
import dreher.euler.Eulerdreher;

// Eine Dreistreckesicht kann dreidimensionalen Strecken darstellen.
// Wir benutzen die Verlegung der Ein-Punkt-Perspektive.
public class Dreistreckesicht extends Sicht {

    // Die Welt.
    public Dreistreckewelt dsw;

    // Das Auge.
    Auge auge;
    
    public Dreistreckesicht(Dreistreckewelt dsw, Auge auge) {
	this.dsw = dsw;
	this.auge = auge;
    }

    public void darstellen(Graphics g) {

	Zweistrecke[] zsl = new Zweistrecke[dsw.strecken.length];
	Dreimatrix drehung = Eulerdreher.nehmedrehung(this.auge.winkeleins,
						      this.auge.winkelzwei,
						      this.auge.winkeldrei);
	
	// Stelle jede Strecke dieser Welt dar.
	for (int i = 0; i < this.dsw.strecken.length; i++) {
	    zsl[i] = Streckeverleger.verlege(this.dsw.strecken[i],
					     this.auge.entfernung, this.auge.brennweite,
					     this.auge.breite, this.auge.hoehe,
					     drehung);
	}

	Zweistreckewelt zsw = new Zweistreckewelt(zsl);
	Zweistreckesicht zss = new Zweistreckesicht(zsw);
	zss.darstellen(g);
    }
}
