package sicht.vielflach.giernick;

import java.util.ArrayList;
import javax.swing.JFrame;
import vielflach.Vielflach;
import vielflach.kubus.Kubus;
import vektor.Dreivektor;
import welt.vielflach.Vielflachwelt;
import maler.Maler;
import sicht.Sicht;
import vielflach.pyramide.Pyramide;

/*
  javac -d classes $(find src -type f)	\
  && java -cp classes sicht.vielflach.giernick.Main
*/

public class Main {

    public static void main(String[] args){
	// Mache die dreidimensionale Welt.
	ArrayList<Vielflach> kl = new ArrayList<Vielflach>();
	kl.add(new Kubus(30));
	ArrayList<Dreivektor> ol = new ArrayList<Dreivektor>();
	ol.add(new Dreivektor(0,0,100));
	
	Vielflachwelt kw = new Vielflachwelt(kl, ol);

	// Mache die Sicht.
	double breite = 1200;
	double hoehe = 600;
	double brennweite = 500;
	Dreivektor ap = new Dreivektor(0,0,0);
	Giernicksicht as = new Giernicksicht(kw, ap, brennweite, breite, hoehe, 0.2, 0.4);
	Maler m = new Maler(new Sicht[] {as});
	
	// Stellen die Daten dar.
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize((int) breite, (int) hoehe);
	frame.add(m);
	frame.setVisible(true);
    }
}
