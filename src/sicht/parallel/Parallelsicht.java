package sicht.parallel;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JComponent;
import kante.Dreikante;
import welt.koerper.Koerperwelt;

// Die Parallelsicht zeigt insbesondere nur die erste und zweite Teile
// der Körper. Sie ist einer der einfachsten Methoden, einen Körper
// darzustellen.
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

	// Nehme die Dreikanten dieser Welt.
	ArrayList<Dreikante> wk = this.kw.nehmeKanten();

	for (int i = 0; i < wk.size(); i++) {
	    g.drawLine(wk.get(i).von.eins, wk.get(i).von.zwei,
		       wk.get(i).bis.eins, wk.get(i).bis.zwei);
	}
    }
}

