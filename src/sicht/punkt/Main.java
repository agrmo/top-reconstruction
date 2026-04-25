package sicht.punkt;

import java.awt.Graphics;
import javax.swing.JFrame;
import maler.Maler;
import sicht.Sicht;
import vektor.Dreivektor;
import vektor.Zweivektor;
import vieleck.quadrat.Quadrat;
import vielflach.kubus.Kubus;
import welt.punkt.Zweipunktwelt;
import verleger.punkt.Punktverleger;
import dreher.dreimatrix.Dreimatrixdreher;
import matrix.Dreimatrix;

/*
  javac -d classes $(find src -type f)	\
  && java -cp classes sicht.punkt.Main
*/

public class Main {

    static void beispieleins() {
	// Mache die Vektore.
	Quadrat q = new Quadrat(50);
	Zweivektor[] pl = q.nehmeecken();

	// Mache die Sicht.
	Zweipunktwelt pw = new Zweipunktwelt(pl);
	int durchmesser = 10;
	Zweipunktsicht s = new Zweipunktsicht(pw, durchmesser);
	Maler m = new Maler(new Sicht[] {s});

	// Stellen die Daten dar.
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(1200, 600);
	frame.add(m);
	frame.setVisible(true);
    }

    static void beispielzwei() {
	// Mache die dreidimensionalen Daten.
	Kubus k = new Kubus(2);
	Dreivektor[] dpl = k.nehmeecken();

	// Mache die Sicht.
	int breite = 1200;
	int hoehe = 600;
	Dreivektor entfernung = new Dreivektor(0,0,10);
	int brennweite = 500;

	Zweivektor[] zpl = new Zweivektor[dpl.length];
	Dreimatrix drehung = Dreimatrixdreher.nehmedreherx(0.1);
	
	for (int i = 0; i < dpl.length; i++) {
	    zpl[i] = Punktverleger.verlege(dpl[i], entfernung, brennweite,
					   breite, hoehe,
					   drehung);
	}
	
	int durchmesser = 20;
	Zweipunktwelt pw = new Zweipunktwelt(zpl);
	Zweipunktsicht s = new Zweipunktsicht(pw, durchmesser);
	Maler m = new Maler(new Sicht[] {s});
	
	// Stellen die Daten dar.
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(breite, hoehe);
	frame.add(m);
	frame.setVisible(true);
    }

    public static void main(String[] args){
	beispielzwei();
    }
}

