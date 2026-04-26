package handlung.vielflach;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import maler.Maler;
import sicht.Sicht;
import sicht.vielflach.Vielflachsicht;
import sicht.vielflach.Vielflachtextsicht;
import vektor.Dreivektor;
import vektor.Zweivektor;
import vielflach.Vielflach;
import vielflach.kubus.Kubus;
import welt.vielflach.Vielflachwelt;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes handlung.vielflach.Main;
*/

public class Main {
    static void beispieleins() {
	// Mache die Welt.
	Vielflach[] vl = new Vielflach[] {new Kubus(60)};
	Dreivektor[] ol = new Dreivektor[] {new Dreivektor(-30,-30,-30)};
	Vielflachwelt vw = new Vielflachwelt(vl, ol);
	
	// Mache die Sicht.
	Dimension bildschirm = Toolkit.getDefaultToolkit().getScreenSize();
	double breite = bildschirm.getWidth();
	double hoehe = bildschirm.getHeight();
	Dreivektor ap = new Dreivektor(0, 0, 200);
	Vielflachsicht vs = new Vielflachsicht(vw, ap, 500, breite, hoehe);
	
	Maler m = new Maler(new Sicht[] {vs});
	
	// Mache die Handlung.
	Vielflachhandlung h = new Vielflachhandlung(m, vs, vw);

	// Geh.
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
	Vielflach[] vl = new Vielflach[] {new Kubus(30)};
	Dreivektor[] ol = new Dreivektor[] {new Dreivektor(-15,-15,-15)};
	Vielflachwelt vw = new Vielflachwelt(vl, ol);
	
	// Mache die Sicht.
	Dimension bildschirm = Toolkit.getDefaultToolkit().getScreenSize();
	double breite = bildschirm.getWidth();
	double hoehe = bildschirm.getHeight();
	Dreivektor ap = new Dreivektor(50,50,0);
	Vielflachsicht vs = new Vielflachsicht(vw, ap, 500, breite, hoehe);
	Vielflachtextsicht ats = new Vielflachtextsicht(vs);

	Maler m = new Maler(new Sicht[] {vs, ats});
	
	// Mache die Handlung.
	Vielflachhandlung h = new Vielflachhandlung(m, vs, vw);

	// Geh.
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setBackground(Color.BLACK);
	frame.getContentPane().setForeground(Color.WHITE);
	frame.setSize((int) breite, (int) hoehe);
	frame.add(m);
	frame.addKeyListener(h);
	frame.setVisible(true);
    }

    static void beispieldrei() {
	// Mache die Welt.
	Vielflach[] vl = new Vielflach[] {
	    new Kubus(30),
	    new Kubus(30)
	};
	Dreivektor[] ol = new Dreivektor[] {
	    new Dreivektor(-15,-15,-15),
	    new Dreivektor(-15,30,30)
	};
	Vielflachwelt vw = new Vielflachwelt(vl, ol);
	
	// Mache die Sicht.
	Dimension bildschirm = Toolkit.getDefaultToolkit().getScreenSize();
	double breite = bildschirm.getWidth();
	double hoehe = bildschirm.getHeight();
	Dreivektor ap = new Dreivektor(50,50,0);
	Vielflachsicht vs = new Vielflachsicht(vw, ap, 500, breite, hoehe);
	Vielflachtextsicht ats = new Vielflachtextsicht(vs);

	Maler m = new Maler(new Sicht[] {vs, ats});
	
	// Mache die Handlung.
	Vielflachhandlung h = new Vielflachhandlung(m, vs, vw);

	// Geh.
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setBackground(Color.BLACK);
	frame.getContentPane().setForeground(Color.WHITE);
	frame.setSize((int) breite, (int) hoehe);
	frame.add(m);
	frame.addKeyListener(h);
	frame.setVisible(true);
    }

    static void beispielvier() {
	// Mache die Welt.
	Vielflach[] vl = new Vielflach[] {new Kubus(30)};
	Dreivektor[] ol = new Dreivektor[] {new Dreivektor(-15,-15,-15)};
	Vielflachwelt vw = new Vielflachwelt(vl, ol);
	
	// Mache die Sicht.
	Dimension bildschirm = Toolkit.getDefaultToolkit().getScreenSize();
	double breite = bildschirm.getWidth();
	double hoehe = bildschirm.getHeight();
	Dreivektor ap = new Dreivektor(0, 0, 100);
	Vielflachsicht vs = new Vielflachsicht(vw, ap, 500, breite, hoehe);
	Maler m = new Maler(new Sicht[] {vs});
	
	// Mache die Handlung.
	Vielflachzeithandlung h = new Vielflachzeithandlung(m, vs, vw);

	// Darstellen.
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setBackground(Color.BLACK);
	frame.getContentPane().setForeground(Color.WHITE);
	frame.setSize((int) breite, (int) hoehe);
	frame.add(m);
	frame.addMouseListener(h);
	frame.addMouseMotionListener(h);
	frame.addKeyListener(h);
	frame.setVisible(true);
    }
    
    public static void main(String[] args) {
	beispieleins();
    }
}
