package spiel.vielflach.giernicktastatur;

import handlung.spiel.SpielHandlung;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;
import vielflach.Vielflach;
import vielflach.kubus.Kubus;
import vektor.Dreivektor;
import sicht.vielflach.giernick.Giernicksicht;
import welt.vielflach.Vielflachwelt;
import java.awt.Toolkit;
import java.awt.Dimension;
import sicht.Sicht;
import maler.Maler;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes spiel.vielflach.giernicktastatur.Main
*/

public class Main {
    public static void main(String[] args) {
	
	// Mache die Welt.
	ArrayList<Vielflach> kl = new ArrayList<Vielflach>();
	kl.add(new Kubus(60));
	ArrayList<Dreivektor> ol = new ArrayList<Dreivektor>();
	ol.add(new Dreivektor(-30,-30,-30));
	Vielflachwelt kw = new Vielflachwelt(kl, ol);
	
	// Mache die Sicht.
	Dimension bildschirm = Toolkit.getDefaultToolkit().getScreenSize();
	int breite = (int) bildschirm.getWidth();
	int hoehe = (int) bildschirm.getHeight();
	Dreivektor ap = new Dreivektor(0, 0, 100);
	Giernicksicht as = new Giernicksicht(kw, ap, 500, breite, hoehe, 0.0, 0.0);
	Maler m = new Maler(new Sicht[] {as});
	
	// Mache das Spiel.
	Giernicktastaturspiel s = new Giernicktastaturspiel(m, as, kw);

	// Mache die Handlung.
	SpielHandlung sh = new SpielHandlung(s);

	// Geh.
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setBackground(Color.BLACK);
	frame.getContentPane().setForeground(Color.WHITE);
	frame.setSize(breite, hoehe);
	frame.add(m);
	frame.addKeyListener(sh);
	frame.setVisible(true);	
    }
}
