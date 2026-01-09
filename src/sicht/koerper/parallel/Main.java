package sicht.koerper.parallel;

import java.util.ArrayList;
import javax.swing.JFrame;
import koerper.kubus.Kubus;
import punkt.Dreipunkt;
import koerper.Koerper;
import welt.koerper.Koerperwelt;
import maler.Maler;
import sicht.Sicht;


/*
  javac -d classes $(find src -type f) \
  && java -cp classes sicht.koerper.parallel.Main
*/

public class Main {

    public static void main(String[] args){
 	
	// Mache die Körperwelt.
	Kubus k = new Kubus(50);
	Dreipunkt p = new Dreipunkt(100,100,100);
	ArrayList<Koerper> kl = new ArrayList<Koerper>();
	kl.add(k);
	ArrayList<Dreipunkt> ol = new ArrayList<Dreipunkt>();
	ol.add(p);
	Koerperwelt kw = new Koerperwelt(kl, ol);
	
	// Mache die Parallelsicht.
	Parallelsicht s = new Parallelsicht(kw);
	Maler m = new Maler(new Sicht[] {s});

	// Stellen die Daten dar.
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(1200, 600);
	frame.add(m);
	frame.setVisible(true);
    }
}

