package sicht.kante;

import java.util.ArrayList;
import javax.swing.JComponent;
import java.awt.Graphics;
import welt.zweikante.Zweikantewelt;
import kante.Zweikante;

// Eine Kantesicht kann Kanten darstellen.
public class Kantesicht extends JComponent {

    // Wir müssen die Welt in die Sicht einsetzen, weil Java sie
    // irgendwann anrufen wird, die Welt darzustellen. 
    public Zweikantewelt zkw;
    
    public Kantesicht(Zweikantewelt zkw) {
	this.zkw = zkw;
    }

    // Die Kanten stehen schon auf einer Ebene. Stellen sie dar.
    public void darstellenKante(Graphics g, Zweikante k) {
	g.drawLine(k.von.eins, k.von.zwei,
		   k.bis.eins, k.bis.zwei);
    }

    public void paintComponent(Graphics g) {
	super.paintComponent(g);

	// Stelle jede Kante dieser Welt dar.
	for (int i = 0; i < this.zkw.kantenliste.size(); i++) {
	    this.darstellenKante(g, this.zkw.kantenliste.get(i));
	}
    }
}

