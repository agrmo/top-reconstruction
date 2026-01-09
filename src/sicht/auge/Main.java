package sicht.auge;

import java.util.ArrayList;
import javax.swing.JFrame;
import koerper.Koerper;
import koerper.kubus.Kubus;
import punkt.Dreipunkt;
import welt.koerper.Koerperwelt;
import maler.Maler;
import sicht.Sicht;
import koerper.pyramide.Pyramide;

/*
  javac -d classes $(find src -type f)	\
  && java -cp classes sicht.auge.Main
*/

public class Main {

    public static void main(String[] args){
	// Mache die dreidimensionale Welt.
	ArrayList<Koerper> kl = new ArrayList<Koerper>();
	kl.add(new Kubus(30));
	kl.add(new Pyramide(40, 40));
	ArrayList<Dreipunkt> ol = new ArrayList<Dreipunkt>();
	ol.add(new Dreipunkt(0,0,200));
	ol.add(new Dreipunkt(100,100,200));
	
	Koerperwelt kw = new Koerperwelt(kl, ol);

	// Mache die Sicht.
	int breite = 1200;
	int hoehe = 600;
	Dreipunkt ap = new Dreipunkt(0,0,0);
	Augesicht as = new Augesicht(kw, ap, 500, breite, hoehe, 0.3, 0.3, 0.1);
	Maler m = new Maler(new Sicht[] {as});
	
	// Stellen die Daten dar.
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(breite, hoehe);
	frame.add(m);
	frame.setVisible(true);
    }
}
