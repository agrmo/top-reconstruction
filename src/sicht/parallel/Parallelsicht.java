package sicht.parallel;

import java.awt.Graphics;
import javax.swing.JComponent;
import strecke.Dreistrecke;
import welt.koerper.Koerperwelt;

// Die Parallelsicht zeigt insbesondere nur die erste und zweite Teile
// der Körper. Sie ist einer der einfachsten Methoden, einen
// dreidimensionalen Körper darzustellen.
public class Parallelsicht extends JComponent {

    public Koerperwelt kw;

    // Wir nehmen an, daß die Sichtfläche genau auf der z=0 Fläche
    // stehen. Ich konnte dei Fläche bestimmbar machen.
    public Parallelsicht(Koerperwelt kw) {
	this.kw = kw;
    }

    // Wir müssen entscheiden, wer diese Körper darstellen wird.
    public void paintComponent(Graphics g) {
	super.paintComponent(g);

	// Nehme die Dreistrecken dieser Welt.
	Dreistrecke[] wk = this.kw.nehmeStrecken();

	for (int i = 0; i < wk.length; i++) {
	    g.drawLine((int) wk[i].von.xteil, (int) wk[i].von.yteil,
		       (int) wk[i].bis.xteil, (int) wk[i].bis.yteil);
	}
    }
}

