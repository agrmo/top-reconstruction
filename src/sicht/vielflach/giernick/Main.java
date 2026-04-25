package sicht.vielflach.giernick;

import javax.swing.JFrame;
import maler.Maler;
import sicht.Sicht;
import vektor.Dreivektor;
import vielflach.Vielflach;
import vielflach.kubus.Kubus;
import welt.vielflach.Vielflachwelt;

/*
  javac -d classes $(find src -type f)	\
  && java -cp classes sicht.vielflach.giernick.Main
*/

public class Main {

    public static void main(String[] args){

	// Mache die Welt.
	Vielflach[] vl = new Vielflach[] {new Kubus(30)};
	Dreivektor[] ol = new Dreivektor[] {new Dreivektor(0,0,100)};
	Vielflachwelt vw = new Vielflachwelt(vl, ol);

	// Mache die Sicht.
	double breite = 1200;
	double hoehe = 600;
	double brennweite = 500;
	Dreivektor ap = new Dreivektor(0,0,0);
	Giernicksicht gs = new Giernicksicht(vw, ap, brennweite, breite, hoehe, 0.2, 0.4);
	Maler m = new Maler(new Sicht[] {gs});
	
	// Stellen die Daten dar.
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize((int) breite, (int) hoehe);
	frame.add(m);
	frame.setVisible(true);
    }
}
