package sicht.strecke.drei;

import java.awt.Graphics;
import javax.swing.JComponent;
import matrix.Dreimatrix;
import sicht.Sicht;
import sicht.strecke.zwei.Zweistreckesicht;
import strecke.Dreistrecke;
import strecke.Zweistrecke;
import vektor.Dreivektor;
import verleger.strecke.Streckeverleger;
import welt.strecke.drei.Dreistreckewelt;
import welt.strecke.zwei.Zweistreckewelt;
import dreher.euler.Eulerdreher;

// Eine Dreistreckesicht kann dreidimensionalen Strecken darstellen.
// Wir benutzen die Verlegung der Ein-Punkt-Perspektive.
public class Dreistreckesicht extends Sicht {

    // Wir müssen die Welt in die Sicht einsetzen, weil Java sie
    // irgendwann anrufen wird, die Welt darzustellen. 
    public Dreistreckewelt dsw;
    Dreivektor entfernung;
    double brennweite;
    double breite;
    double hoehe;
    double winkeleins;
    double winkelzwei;
    double winkeldrei;
    
    public Dreistreckesicht(Dreistreckewelt dsw,
			    Dreivektor entfernung, double brennweite,
			    double breite, double hoehe,
			    double winkeleins,
			    double winkelzwei,
			    double winkeldrei) {
	this.dsw = dsw;
	this.entfernung = entfernung;
	this.brennweite = brennweite;
	this.breite = breite;
	this.hoehe = hoehe;
	this.winkeleins = winkeleins;
	this.winkelzwei = winkelzwei;
	this.winkeldrei = winkeldrei;
    }

    public void darstellen(Graphics g) {

	Zweistrecke[] zsl = new Zweistrecke[dsw.strecken.length];
	Dreimatrix drehung = Eulerdreher.nehmedrehung(winkeleins,
						       winkelzwei,
						       winkeldrei);
	
	// Stelle jede Strecke dieser Welt dar.
	for (int i = 0; i < this.dsw.strecken.length; i++) {
	    zsl[i] = Streckeverleger.verlege(this.dsw.strecken[i], this.entfernung,
					     this.brennweite,
					     this.breite, this.hoehe,
					     drehung);
	}

	Zweistreckewelt zsw = new Zweistreckewelt(zsl);
	Zweistreckesicht zss = new Zweistreckesicht(zsw);
	zss.darstellen(g);
    }
}
