package sicht.kreis;

import java.awt.Graphics;
import javax.swing.JComponent;
import punkt.Zweipunkt;
import figur.kreis.Kreis;

// Stellen eine Reihe von Kreisen dar.
public class Kreissicht extends JComponent {

    Kreis[] kreisliste;
    Zweipunkt[] ortliste;

    public Kreissicht(Kreis[] kl, Zweipunkt[] ol) {
	this.kreisliste = kl;
	this.ortliste = ol;
    }

    public void paintComponent(Graphics g) {
	super.paintComponent(g);

	for (int i = 0; i < this.kreisliste.length; i++) {
	    g.drawOval((int) this.ortliste[i].xteil, (int) this.ortliste[i].yteil,
		       this.kreisliste[i].radius, this.kreisliste[i].radius);
	}
    }
}


