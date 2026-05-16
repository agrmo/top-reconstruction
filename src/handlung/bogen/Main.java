package handlung.bogen;

import auge.Auge;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import maler.Maler;
import sicht.Sicht;
import bogen.Bogen;
import vektor.Dreivektor;
import welt.bogen.Dreibogenwelt;
import orientierung.Orientierung;
import stellung.Dreistellung;
import sicht.bogen.drei.Dreibogensicht;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes handlung.bogen.Main
*/

public class Main {
    static void beispieleins() {
	// Mache die Welt.
	Bogen[] bl = new Bogen[] {
	    new Bogen(200,200,0,90),
	    new Bogen(200,200,0,180)};

	Dreistellung[] sl = new Dreistellung[] {
	    new Dreistellung(new Dreivektor(-30,-30,-30),
			     new Orientierung(0,0,0)),
	    new Dreistellung(new Dreivektor(30,30,30),
			     new Orientierung(0,0,0))
	};
	
	Dreibogenwelt dbw = new Dreibogenwelt(bl, sl);

	// Mache die Sicht.
	Dimension bildschirm = Toolkit.getDefaultToolkit().getScreenSize();
	double breite = bildschirm.getWidth();
	double hoehe = bildschirm.getHeight();
	double brennweite = 500;
	Dreivektor entfernung = new Dreivektor(0,0,100);
	double winkeleins = 0;
	double winkelzwei = 0;
	double winkeldrei = 0;
	Auge auge = new Auge(entfernung, brennweite,
			     breite, hoehe,
			     winkeleins,
			     winkelzwei,
			     winkeldrei);
	Dreibogensicht s = new Dreibogensicht(dbw, auge);
	Maler m = new Maler(new Sicht[] {s});
	
	// Mache die Handlung.
	Bogenhandlung handlung = new Bogenhandlung(m, s, dbw);

	// Stelle die Daten dar..
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setBackground(Color.BLACK);
	frame.getContentPane().setForeground(Color.WHITE);
	frame.setSize((int) breite, (int) hoehe);
	frame.add(m);
	frame.addKeyListener(handlung);
	frame.setVisible(true);
    }

    public static void main(String[] args) {
	beispieleins();
    }
}
