package sicht.zweipunkt;

import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.Graphics;
import punkt.Zweipunkt;

// Eine Zweipunktsicht kann Punktn darstellen.
public class Zweipunktsicht extends JComponent {

    // Wir müssen die Welt in die Sicht einsetzen, weil Java sie
    // irgendwann anrufen wird, die Welt darzustellen. 
    public Zweipunkt[] pl;

    // Die Größe des Kreises;
    public int radius;

    public Zweipunktsicht(Zweipunkt[] pl, int r) {
	this.pl = pl;
	this.radius = r;
    }

    // Die Punktn stehen schon auf einer Ebene. Stellen sie dar.
    public void darstellenPunkt(Graphics g, Zweipunkt k) {
	g.drawOval((int) k.xteil, (int) k.yteil,
		   this.radius, this.radius);
    }

    public void paintComponent(Graphics g) {
	super.paintComponent(g);

	// Stelle jede Punkt dieser Welt dar.
	for (int i = 0; i < this.pl.length; i++) {
	    this.darstellenPunkt(g, this.pl[i]);
	}
    }
}

