package sicht.oval;

import java.awt.Graphics;
import javax.swing.JComponent;
import punkt.Zweipunkt;
import figur.oval.Oval;

// Stellen eine Reihe von Ovalen dar.
public class Ovalsicht extends JComponent {

    Oval[] ovalliste;
    Zweipunkt[] ortliste;

    public Ovalsicht(Oval[] kl, Zweipunkt[] ol) {
	this.ovalliste = kl;
	this.ortliste = ol;
    }

    public void paintComponent(Graphics g) {
	super.paintComponent(g);

	for (int i = 0; i < this.ovalliste.length; i++) {
	    g.drawOval((int) this.ortliste[i].xteil, (int) this.ortliste[i].yteil,
		       this.ovalliste[i].xausdehnung, this.ovalliste[i].yausdehnung);
	}
    }
}


