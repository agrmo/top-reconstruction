package sicht.bogen.drei;

import bogen.Bogen;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Color;
import maler.Maler;
import sicht.Sicht;
import vektor.Dreivektor;
import welt.bogen.Dreibogenwelt;
import orientierung.Orientierung;
import stellung.Dreistellung;

/*
  javac -d classes $(find src -type f)	\
  && java -cp classes sicht.bogen.drei.Main
*/

public class Main {

    public static void main(String[] args){

	// Mache die Welt.
	Bogen[] bl = new Bogen[] {
	    new Bogen(800,200,10,90),
	    new Bogen(800,200,10,90)};

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
	Dreibogensicht s = new Dreibogensicht(dbw,
					      entfernung, brennweite,
					      breite, hoehe,
					      winkeleins,
					      winkelzwei,
					      winkeldrei);
	Maler m = new Maler(new Sicht[] {s});
	
	// Geh.
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setBackground(Color.BLACK);
        frame.getContentPane().setForeground(Color.WHITE);
	frame.setSize((int) breite, (int) hoehe);
	frame.add(m);
	frame.setVisible(true);

    }
}
