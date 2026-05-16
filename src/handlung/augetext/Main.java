package handlung.augetext;

import auge.Auge;
import handlung.vielflach.Vielflachhandlung;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import maler.Maler;
import orientierung.Orientierung;
import sicht.Sicht;
import sicht.vielflach.Vielflachsicht;
import sicht.augetext.Augetextsicht;
import stellung.Dreistellung;
import vektor.Dreivektor;
import vektor.Zweivektor;
import vielflach.Vielflach;
import vielflach.kubus.Kubus;
import welt.vielflach.Vielflachwelt;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes handlung.augetext.Main;
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
	Dreivektor entfernung = new Dreivektor(50,50,0);
	double brennweite = 500;
	double winkeleins = 0;
	double winkelzwei = 0;
	double winkeldrei = 0;
	Auge auge = new Auge(entfernung, brennweite,
			     breite, hoehe,
			     winkeleins,
			     winkelzwei,
			     winkeldrei);
	Vielflachsicht vs = new Vielflachsicht(vw, auge);
	Augetextsicht ats = new Augetextsicht(auge);

	Maler m = new Maler(new Sicht[] {vs, ats});
	
	// Mache die Handlung.
	Vielflachhandlung h = new Vielflachhandlung(m, vs, vw);

	// Stelle die Daten dar.
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setBackground(Color.BLACK);
	frame.getContentPane().setForeground(Color.WHITE);
	frame.setSize((int) breite, (int) hoehe);
	frame.add(m);
	frame.addKeyListener(h);
	frame.setVisible(true);

    }
    
    static void beispielzwei() {
	// Mache die Welt.
	Vielflach[] vl = new Vielflach[] {
	    new Kubus(30),
	    new Kubus(30)
	};
	Dreistellung[] sl = new Dreistellung[] {
	    new Dreistellung(new Dreivektor(-15,-15,-15),
			     new Orientierung(0,0,0)),
	    new Dreistellung(new Dreivektor(-15,30,30),
			     new Orientierung(Math.PI / 4.0,0,0))
	};
	Vielflachwelt vw = new Vielflachwelt(vl, sl);
	
	// Mache die Sicht.
	Dimension bildschirm = Toolkit.getDefaultToolkit().getScreenSize();
	double breite = bildschirm.getWidth();
	double hoehe = bildschirm.getHeight();
	Dreivektor entfernung = new Dreivektor(50,50,0);
	double brennweite = 500;
	double winkeleins = 0;
	double winkelzwei = 0;
	double winkeldrei = 0;
	Auge auge = new Auge(entfernung, brennweite,
			     breite, hoehe,
			     winkeleins,
			     winkelzwei,
			     winkeldrei);
	Vielflachsicht vs = new Vielflachsicht(vw, auge);
	Augetextsicht ats = new Augetextsicht(auge);

	Maler m = new Maler(new Sicht[] {vs, ats});
	
	// Mache die Handlung.
	Vielflachhandlung h = new Vielflachhandlung(m, vs, vw);

	// Stelle die Daten dar.
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setBackground(Color.BLACK);
	frame.getContentPane().setForeground(Color.WHITE);
	frame.setSize((int) breite, (int) hoehe);
	frame.add(m);
	frame.addKeyListener(h);
	frame.setVisible(true);
    }

    public static void main(String[] args) {
	beispieleins();
    }
}
