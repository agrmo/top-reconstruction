package sicht.vielflach.giernick;

import java.util.ArrayList;
import javax.swing.JFrame;
import vielflach.Vielflach;
import vielflach.kubus.Kubus;
import punkt.Dreipunkt;
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
	ArrayList<Dreipunkt> ol = new ArrayList<Dreipunkt>();
	ol.add(new Dreipunkt(0,0,100));
	
	Vielflachwelt kw = new Vielflachwelt(kl, ol);

	// Mache die Sicht.
	int breite = 1200;
	int hoehe = 600;
	Dreipunkt ap = new Dreipunkt(0,0,0);
	Giernicksicht as = new Giernicksicht(kw, ap, 500, breite, hoehe, 0.2, 0.4);
	Maler m = new Maler(new Sicht[] {as});
	
	// Stellen die Daten dar.
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(breite, hoehe);
	frame.add(m);
	frame.setVisible(true);
    }
}
