package sicht.vielflach.parallel;

import java.awt.Graphics;
import strecke.Dreistrecke;
import welt.vielflach.Vielflachwelt;
import sicht.Sicht;

// Die Parallelsicht zeigt insbesondere nur die erste und zweite Teile
// der Körper. Sie ist einer der einfachsten Methoden, einen
// dreidimensionalen Körper darzustellen.
public class Parallelsicht extends Sicht {

    public Vielflachwelt kw;

    // Wir nehmen an, daß die Sichtfläche genau auf der z=0 Fläche
    // stehen. Ich konnte dei Fläche bestimmbar machen.
    public Parallelsicht(Vielflachwelt kw) {
	this.kw = kw;
    }

    // Wir müssen entscheiden, wer diese Körper darstellen wird.
    public void darstellen(Graphics g) {
	// Nehme die Dreistrecken dieser Welt.
	Dreistrecke[] wk = this.kw.nehmekanten();

	for (int i = 0; i < wk.length; i++) {
	    g.drawLine((int) wk[i].von.eins, (int) wk[i].von.zwei,
		       (int) wk[i].bis.eins, (int) wk[i].bis.zwei);
	}
    }
}

