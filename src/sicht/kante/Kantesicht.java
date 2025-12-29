package sicht.kante;

import java.util.ArrayList;
import javax.swing.JComponent;
import java.awt.Graphics;
import welt.kante.Zweikantewelt;
import kante.Zweikante;

// Eine Kantesicht kann Kanten darstellen.
public class Kantesicht extends JComponent {

    // Wir müssen die Welt in die Sicht einsetzen, weil Java sie
    // irgendwann anrufen wird, die Welt darzustellen. 
    public Zweikantewelt zweikantewelt;
    
    public Kantesicht(Zweikantewelt zkw) {
	this.zweikantewelt = zkw;
    }

    // Die Kanten stehen schon auf einer Ebene. Stellen sie dar.
    public void darstellenKante(Graphics g, Zweikante k) {
	g.drawLine(k.von.eins, k.von.zwei,
		   k.bis.eins, k.bis.zwei);
    }

    public void paintComponent(Graphics g) {
	super.paintComponent(g);

	// Stelle jede Kante dieser Welt dar.
	for (int i = 0; i < this.zweikantewelt.kantenliste.size(); i++) {
	    this.darstellenKante(g, this.zweikantewelt.kantenliste.get(i));
	}
    }
}

