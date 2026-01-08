package sicht.strecke;

import javax.swing.JComponent;
import java.awt.Graphics;
import welt.zweistrecke.Zweistreckewelt;
import strecke.Zweistrecke;
import sicht.Sicht;

// Eine Streckesicht kann Strecken darstellen.
public class Streckesicht extends JComponent {

    // Wir müssen die Welt in die Sicht einsetzen, weil Java sie
    // irgendwann anrufen wird, die Welt darzustellen. 
    public Zweistreckewelt zsw;
    
    public Streckesicht(Zweistreckewelt zsw) {
	this.zsw = zsw;
    }

    // Die Strecken stehen schon auf einer Ebene. Stellen sie dar.
    public void darstellenStrecke(Graphics g, Zweistrecke k) {
	g.drawLine((int) k.von.xteil, (int) k.von.yteil,
		   (int) k.bis.xteil, (int) k.bis.yteil);
    }

    public void paintComponent(Graphics g) {
	super.paintComponent(g);

	// Stelle jede Strecke dieser Welt dar.
	for (int i = 0; i < this.zsw.streckenliste.length; i++) {
	    this.darstellenStrecke(g, this.zsw.streckenliste[i]);
	}
    }
}

