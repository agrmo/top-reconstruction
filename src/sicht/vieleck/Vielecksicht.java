package sicht.vieleck;

import java.awt.Graphics;
import strecke.Zweistrecke;
import welt.vieleck.Vieleckwelt;
import sicht.Sicht;

// Die Vielecksicht zeigt insbesondere nur die erste und zweite Teile
// der Vieleck. Sie ist einer der einfachsten Methoden, einen Vieleck
// darzustellen.
public class Vielecksicht extends Sicht {

    public Vieleckwelt fw;

    public Vielecksicht(Vieleckwelt fw) {
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

