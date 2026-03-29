package spiel.vielflach.basiszeit;

import handlung.spiel.SpielHandlung;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JFrame;
import maler.Maler;
import sicht.Sicht;
import sicht.vielflach.auge.Augesicht;
import sicht.vielflach.auge.Augetextsicht;
import vektor.Dreivektor;
import vektor.Zweivektor;
import vielflach.Vielflach;
import vielflach.kubus.Kubus;
import welt.vielflach.Vielflachwelt;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes spiel.vielflach.basiszeit.Main
*/

public class Main {
    static void beispielEins() {
	// Mache die Welt.
	ArrayList<Vielflach> kl = new ArrayList<Vielflach>();
	kl.add(new Kubus(60));
	ArrayList<Dreivektor> ol = new ArrayList<Dreivektor>();
	ol.add(new Dreivektor(-30,-30,-30));
	Vielflachwelt vw = new Vielflachwelt(kl, ol);
	
	// Mache die Sicht.
	Dimension bildschirm = Toolkit.getDefaultToolkit().getScreenSize();
	double breite = bildschirm.getWidth();
	double hoehe = bildschirm.getHeight();
	Dreivektor ap = new Dreivektor(0, 0, 100);
	Augesicht vbs = new Augesicht(vw, ap, 500, breite, hoehe);

	Maler m = new Maler(new Sicht[] {vbs});
	
	// Mache das Spiel.
	Vielflachbasiszeitspiel s = new Vielflachbasiszeitspiel(m, vbs, vw);

	// Mache die Handlung.
	SpielHandlung sh = new SpielHandlung(s);

	// Darstellen.
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setBackground(Color.BLACK);
	frame.getContentPane().setForeground(Color.WHITE);
	frame.setSize((int) breite, (int) hoehe);
	frame.add(m);
	frame.addMouseListener(sh);
	frame.addMouseMotionListener(sh);
	frame.addKeyListener(sh);
	frame.setVisible(true);
    }
    
    public static void main(String[] args) {
	beispielEins();
    }
}
