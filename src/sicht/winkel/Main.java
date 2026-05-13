package sicht.winkel;

import java.awt.Graphics;
import javax.swing.JFrame;
import maler.Maler;
import sicht.Sicht;
import java.awt.Dimension;
import java.awt.Toolkit;
import spiegel.Spiegel;

/*
  javac -d classes $(find src -type f)	\
  && java -cp classes sicht.winkel.Main
*/

public class Main {

    static void beispieleins() {
	// Mache die Sicht.
	Dimension bildschirm = Toolkit.getDefaultToolkit().getScreenSize();
	double breite = bildschirm.getWidth();
	double hoehe = bildschirm.getHeight();
	int radius = 100;
	int nullradius = 5;
	double winkel = 0.8;
	Winkelsicht s = new Winkelsicht(winkel, breite, hoehe,
					radius, nullradius);
	Maler m = new Maler(new Sicht[] {s});

	// Stellen die Daten dar.
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize((int) breite, (int) hoehe);
	frame.add(m);
	frame.setVisible(true);
    }

    static void beispielzwei() {
	// Beispiele mit dem Spiegel.

	// Mache die Sicht.
	Dimension bildschirm = Toolkit.getDefaultToolkit().getScreenSize();
	double breite = bildschirm.getWidth();
	double hoehe = bildschirm.getHeight();
	int radius = 100;
	int nullradius = 5;
	double winkela = 45 * (Math.PI / 180.0);
	Winkelsicht sa = new Winkelsicht(winkela, breite, hoehe,
					 radius, nullradius);

	double winkelb = Spiegel.spiegeleyrad(winkela);
	
	Winkelsicht sb = new Winkelsicht(winkelb, breite, hoehe,
					 radius, nullradius);
	
	Maler m = new Maler(new Sicht[] {sa,sb});

	// Stellen die Daten dar.
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize((int) breite, (int) hoehe);
	frame.add(m);
	frame.setVisible(true);
    }	

    public static void main(String[] args){
	beispielzwei();
    }
}

