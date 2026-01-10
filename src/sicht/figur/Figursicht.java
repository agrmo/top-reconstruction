package sicht.figur;

import java.awt.Graphics;
import strecke.Zweistrecke;
import welt.figur.Figurwelt;
import sicht.Sicht;

// Die Figursicht zeigt insbesondere nur die erste und zweite Teile
// der Figur. Sie ist einer der einfachsten Methoden, einen Figur
// darzustellen.
public class Figursicht extends Sicht {

    public Figurwelt fw;

    public Figursicht(Figurwelt fw) {
	this.fw = fw;
    }

    // Stellen die Kanten dieser Welt dar.
    public void darstellen(Graphics g) {
	
	Zweistrecke[] wk = this.fw.nehmekanten();

	for (int i = 0; i < wk.length; i++) {
	    g.drawLine((int) wk[i].von.xteil, (int) wk[i].von.yteil,
		       (int) wk[i].bis.xteil, (int) wk[i].bis.yteil);
	}
    }
}

