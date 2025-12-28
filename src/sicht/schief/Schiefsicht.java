package sicht.schief;

import java.util.ArrayList;
import javax.swing.JComponent;
import java.awt.Graphics;
import welt.kante.Zweikantewelt;
import kante.Zweikante;

// Schon ist die Schiefsicht eine Welt gegeben. Die gegebene Welt
// enthält alle Körper und ihre befindenden Stellen. Die Schiefsicht
// darf nur ausrechnen, wie die Körper aussehen. Dafür muss sie die
// Dreikanten eines Kubus gut berechnen, und so weiter.
public class Schiefsicht extends JComponent {

    public Zweikantewelt zweikantewelt;

    // ein: Dreivektor, ganze Zahl
    //
    // Zeigt die Ausbreitungsgröße. Zeigt wie groß das Bild ausdehnen
    // werden im Unterschied mit dem ursprunglichen Stellen.
    // 
    // Wir nehmen an, daß die Sichtfläche genau auf der z=0 Fläche
    // stehen. Ich konnte dei Fläche bestimmbar machen.
    public Schiefsicht(Zweikantewelt zkw) {
	this.zweikantewelt = zkw;
    }

    public void darstellenKante(Graphics g, Zweikante k) {
	g.drawLine(k.von.eins, k.von.zwei,
		   k.bis.eins, k.bis.zwei);	
    }

    // Wir müssen entscheiden, wer diese Körper darstellen wird.
    public void paintComponent(Graphics g) {
	super.paintComponent(g);

	// Stelle jede Kante dieser Welt dar.
	for (int i = 0; i < this.zweikantewelt.kantenliste.size(); i++) {
	    this.darstellenKante(g, this.zweikantewelt.kantenliste.get(i));
	}
    }
}

