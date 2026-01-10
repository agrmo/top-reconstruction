package sicht.auge;

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
  && java -cp classes sicht.auge.Main
*/

public class Main {

    public static void main(String[] args){
	// Mache die dreidimensionale Welt.
	ArrayList<Vielflach> kl = new ArrayList<Vielflach>();
	kl.add(new Kubus(30));
	ArrayList<Dreipunkt> ol = new ArrayList<Dreipunkt>();
	ol.add(new Dreipunkt(0,0,200));
	
	Vielflachwelt kw = new Vielflachwelt(kl, ol);

	// Mache die Sicht.
	int breite = 1200;
	int hoehe = 600;
	Dreipunkt ap = new Dreipunkt(0,0,100);
	Augesicht as = new Augesicht(kw, ap, 500, breite, hoehe, 0.5, 0.3);
	Maler m = new Maler(new Sicht[] {as});
	
	// Stellen die Daten dar.
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(breite, hoehe);
	frame.add(m);
	frame.setVisible(true);
    }
}
