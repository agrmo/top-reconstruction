package sicht.zweipunkt;

import java.util.ArrayList;
import javax.swing.JComponent;
import java.awt.Graphics;
import punkt.Zweipunkt;

// Eine Zweipunktsicht kann Punktn darstellen.
public class Zweipunktsicht extends JComponent {

    // Wir müssen die Welt in die Sicht einsetzen, weil Java sie
    // irgendwann anrufen wird, die Welt darzustellen. 
    public ArrayList<Zweipunkt> pl;

    int groese = 10;
    
    public Zweipunktsicht(ArrayList<Zweipunkt> pl) {
	this.pl = pl;
    }

    // Die Punktn stehen schon auf einer Ebene. Stellen sie dar.
    public void darstellenPunkt(Graphics g, Zweipunkt k) {
	g.drawOval((int) k.xteil, (int) k.yteil,
		   this.groese, this.groese);
    }

    public void paintComponent(Graphics g) {
	super.paintComponent(g);

	// Stelle jede Punkt dieser Welt dar.
	for (int i = 0; i < this.pl.size(); i++) {
	    this.darstellenPunkt(g, this.pl.get(i));
	}
    }
}

