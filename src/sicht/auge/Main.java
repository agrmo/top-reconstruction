package sicht.auge;

import java.util.ArrayList;
import javax.swing.JFrame;
import koerper.Koerper;
import koerper.kubus.Kubus;
import punkt.Dreipunkt;
import welt.koerper.Koerperwelt;
import maler.Maler;
import sicht.Sicht;

/*
  javac -d classes $(find src -type f)	\
  && java -cp classes sicht.auge.Main
*/

public class Main {

    public static void main(String[] args){
	// Mache die dreidimensionale Welt.
	Kubus k = new Kubus(30);
	Dreipunkt p = new Dreipunkt(0,0,200);
	ArrayList<Koerper> kl = new ArrayList<Koerper>();
	kl.add(k);
	ArrayList<Dreipunkt> ol = new ArrayList<Dreipunkt>();
	ol.add(p);
	Koerperwelt kw = new Koerperwelt(kl, ol);

	// Mache die Sicht.
	int breite = 1200;
	int hoehe = 600;
	Dreipunkt ap = new Dreipunkt(0,0,0);
	Augesicht as = new Augesicht(kw, ap, 500, breite, hoehe, 0, 0, 0);
	Maler m = new Maler(new Sicht[] {as});
	
	// Stellen die Daten dar.
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(breite, hoehe);
	frame.add(m);
	frame.setVisible(true);
    }
}
