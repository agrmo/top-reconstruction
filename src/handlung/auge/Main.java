package handlung.auge;

import auge.Auge;
import bogen.Bogen;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import maler.Maler;
import orientierung.Orientierung;
import sicht.Sicht;
import sicht.bogen.drei.Dreibogensicht;
import sicht.vielflach.Vielflachsicht;
import stellung.Dreistellung;
import vektor.Dreivektor;
import vielflach.Vielflach;
import vielflach.kubus.Kubus;
import welt.bogen.Dreibogenwelt;
import welt.vielflach.Vielflachwelt;


/*
  javac -d classes $(find src -type f) \
  && java -cp classes handlung.auge.Main
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
	
	// Mache die Welt.
	Vielflach[] vl = new Vielflach[] {new Kubus(30)};
	Dreistellung[] vsl = new Dreistellung[] {
	    new Dreistellung(new Dreivektor(0,0,0),
			     new Orientierung(0,0,0))
	};
	Vielflachwelt vw = new Vielflachwelt(vl, vsl);

	// Mache die Sicht.
	double breite = 1200;
	double hoehe = 600;
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
	
	Dreibogensicht dbs = new Dreibogensicht(dbw, auge);
	Vielflachsicht vs = new Vielflachsicht(vw, auge);

	// Mache den Maler.
	Maler m = new Maler(new Sicht[] {vs, dbs});

	// Mache die Handlung.
	Augehandlung handlung = new Augehandlung(m, auge);
	
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
