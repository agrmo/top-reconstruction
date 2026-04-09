package sicht.vielflach.auge;

import java.util.ArrayList;
import javax.swing.JFrame;
import maler.Maler;
import sicht.Sicht;
import vektor.Dreivektor;
import vielflach.Vielflach;
import vielflach.kubus.Kubus;
import welt.vielflach.Vielflachwelt;

/*
  javac -d classes $(find src -type f)	\
  && java -cp classes sicht.vielflach.auge.Main
*/

public class Main {

    public static void main(String[] args){	

	// Mache die Welt.
	ArrayList<Vielflach> kl = new ArrayList<Vielflach>();
	kl.add(new Kubus(30));
	ArrayList<Dreivektor> ol = new ArrayList<Dreivektor>();
	ol.add(new Dreivektor(0,0,200));
	Vielflachwelt welt = new Vielflachwelt(kl, ol);

	// Mache die Sicht.
	double breite = 1200;
	double hoehe = 600;
	double brennweite = 500;
	Dreivektor ap = new Dreivektor(100,100,100);
	Augesicht as = new Augesicht(welt, ap, brennweite, breite, hoehe);
	Maler m = new Maler(new Sicht[] {as});
	
	// Stelle die Daten dar.
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize((int) breite, (int) hoehe);
	frame.add(m);
	frame.setVisible(true);
    }
}
