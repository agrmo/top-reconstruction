package sicht.vielflachtext;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import maler.Maler;
import orientierung.Orientierung;
import sicht.Sicht;
import stellung.Dreistellung;
import vektor.Dreivektor;
import vielflach.Vielflach;
import vielflach.kubus.Kubus;
import welt.vielflach.Vielflachwelt;
import sicht.vielflach.Vielflachsicht;

/*
  javac -d classes $(find src -type f)	\
  && java -cp classes sicht.vielflachtext.Main
*/

public class Main {

    static void beispieleins() {
	// Mache die Welt.
	Vielflach[] vl = new Vielflach[] {new Kubus(30)};
	Dreistellung[] sl = new Dreistellung[] {
	    new Dreistellung(new Dreivektor(-15,-15,-15),
			     new Orientierung(0,0,0))
	};
	Vielflachwelt vw = new Vielflachwelt(vl, sl);
	
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
