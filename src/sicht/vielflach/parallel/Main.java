package sicht.vielflach.parallel;

import java.util.ArrayList;
import javax.swing.JFrame;
import vielflach.kubus.Kubus;
import punkt.Dreipunkt;
import vielflach.Vielflach;
import welt.vielflach.Vielflachwelt;
import maler.Maler;
import sicht.Sicht;


/*
  javac -d classes $(find src -type f) \
  && java -cp classes sicht.vielflach.parallel.Main
*/

public class Main {

    public static void main(String[] args){
 	
	// Mache die Vielflachwelt.
	Kubus k = new Kubus(50);
	Dreipunkt p = new Dreipunkt(100,100,100);
	ArrayList<Vielflach> kl = new ArrayList<Vielflach>();
	kl.add(k);
	ArrayList<Dreipunkt> ol = new ArrayList<Dreipunkt>();
	ol.add(p);
	Vielflachwelt kw = new Vielflachwelt(kl, ol);
	
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

