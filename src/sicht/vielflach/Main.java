package sicht.vielflach;

import javax.swing.JFrame;
import maler.Maler;
import sicht.Sicht;
import vektor.Dreivektor;
import vielflach.Vielflach;
import vielflach.kubus.Kubus;
import welt.vielflach.Vielflachwelt;
import java.awt.Toolkit;
import java.awt.Dimension;

/*
  javac -d classes $(find src -type f)	\
  && java -cp classes sicht.vielflach.Main
*/

public class Main {

    static void beispieleins() {
	// Mache die Welt.
	Vielflach[] vl = new Vielflach[] {new Kubus(30)};
	Dreivektor[] ol = new Dreivektor[] {new Dreivektor(0,0,0)};
	Vielflachwelt welt = new Vielflachwelt(vl, ol);

	// Mache die Sicht.
	double breite = 1200;
	double hoehe = 600;
	double brennweite = 500;
	Dreivektor ap = new Dreivektor(0,0,100);
	Vielflachsicht vs = new Vielflachsicht(welt, ap, brennweite, breite, hoehe);
	Maler m = new Maler(new Sicht[] {vs});
	
	// Stelle die Daten dar.
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize((int) breite, (int) hoehe);
	frame.add(m);
	frame.setVisible(true);
    }

    static void beispielzwei() {
	// Mache die Welt.
	Vielflach[] vl = new Vielflach[] {new Kubus(30)};
	Dreivektor[] ol = new Dreivektor[] {new Dreivektor(-15,-15,-15)};
	Vielflachwelt vw = new Vielflachwelt(vl, ol);
	
	// Mache die Sicht.
	Dimension bildschirm = Toolkit.getDefaultToolkit().getScreenSize();
	double breite = bildschirm.getWidth();
	double hoehe = bildschirm.getHeight();
	Dreivektor ap = new Dreivektor(0,0,100);
	Vielflachsicht vs = new Vielflachsicht(vw, ap, 500, breite, hoehe);
	Vielflachtextsicht vts = new Vielflachtextsicht(vs);

	Maler m = new Maler(new Sicht[] {vs, vts});
	
	// Geh.
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize((int) breite, (int) hoehe);
	frame.add(m);
	frame.setVisible(true);
    }

    public static void main(String[] args){
	beispieleins();
    }
}
