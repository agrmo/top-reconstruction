package sicht.figur;

import java.awt.Graphics;
import java.util.ArrayList;
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

    // Wir müssen entscheiden, wer diese Figur darstellen wird.
    public void darstellen(Graphics g) {
	// Nehme die Zweistrecken dieser Welt.
	ArrayList<Zweistrecke> wk = this.fw.nehmeStrecken();

	for (int i = 0; i < wk.size(); i++) {
	    g.drawLine((int) wk.get(i).von.xteil, (int) wk.get(i).von.yteil,
		       (int) wk.get(i).bis.xteil, (int) wk.get(i).bis.yteil);
	}
    }
}

