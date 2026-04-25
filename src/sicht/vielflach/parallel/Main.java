package sicht.vielflach.parallel;

import javax.swing.JFrame;
import vielflach.kubus.Kubus;
import vektor.Dreivektor;
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

	// Mit der Parallelsicht sieht ein Kubus wie ein Quader aus.
 	
	// Mache die Welt.
	Kubus k = new Kubus(50);
	Dreivektor p = new Dreivektor(100,100,100);
	Vielflach[] vl = new Vielflach[] {k};
	Dreivektor[] ol = new Dreivektor[] {p};
	Vielflachwelt welt = new Vielflachwelt(vl, ol);
	
	// Mache die Sicht.
	Parallelsicht s = new Parallelsicht(welt);
	Maler m = new Maler(new Sicht[] {s});

	// Stellen die Daten dar.
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(1200, 600);
	frame.add(m);
	frame.setVisible(true);
    }
}

