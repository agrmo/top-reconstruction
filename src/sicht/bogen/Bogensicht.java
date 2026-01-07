package sicht.bogen;

import java.awt.Graphics;
import javax.swing.JComponent;
import punkt.Zweipunkt;
import bogen.Bogen;

// Stellen eine Reihe von Bogen dar.
public class Bogensicht extends JComponent {

    Bogen[] bogenliste;
    Zweipunkt[] ortliste;

    public Bogensicht(Bogen[] bl, Zweipunkt[] ol) {
	this.bogenliste = bl;
	this.ortliste = ol;
    }

    public void paintComponent(Graphics g) {
	super.paintComponent(g);

	for (int i = 0; i < this.bogenliste.length; i++) {
	    g.drawArc((int) this.ortliste[i].xteil, (int) this.ortliste[i].yteil,
		      this.bogenliste[i].breite, this.bogenliste[i].hoehe,
		      this.bogenliste[i].anfangwinkel, this.bogenliste[i].unterschiedwinkel);
	}
    }
}


